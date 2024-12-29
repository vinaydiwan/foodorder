package com.FoodOrder.foodOder.User.Service.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodOrder.foodOder.Admin.DTOs.FoodItemInfo;
import com.FoodOrder.foodOder.Admin.DTOs.UserRestaurantInfo;
import com.FoodOrder.foodOder.Admin.Service.RestaurantService;
import com.FoodOrder.foodOder.User.DTOs.CartItem;
import com.FoodOrder.foodOder.User.DTOs.Checkout;
import com.FoodOrder.foodOder.User.DTOs.CheckoutOverview;
import com.FoodOrder.foodOder.User.DTOs.CheckoutRestaurant;
import com.FoodOrder.foodOder.User.DTOs.CheckoutUserInfo;
import com.FoodOrder.foodOder.User.DTOs.OrderDetails;
import com.FoodOrder.foodOder.User.DTOs.OrderDetailsShort;
import com.FoodOrder.foodOder.User.DTOs.OrderItemDetails;
import com.FoodOrder.foodOder.User.DTOs.OrderStatus;
import com.FoodOrder.foodOder.User.Model.OrderItems;
import com.FoodOrder.foodOder.User.Model.OrderJob;
import com.FoodOrder.foodOder.User.Model.Orders;
import com.FoodOrder.foodOder.User.Model.UserCart;
import com.FoodOrder.foodOder.User.Model.UserInfo;
import com.FoodOrder.foodOder.User.Repository.OrderJobRepository;
import com.FoodOrder.foodOder.User.Repository.OrdersRepository;
import com.FoodOrder.foodOder.User.Repository.UserCartRepository;
import com.FoodOrder.foodOder.User.Repository.UserInfoRepository;
import com.FoodOrder.foodOder.User.Service.ShoppingService;

@Service
public class ShoppingServiceImpl implements ShoppingService {
	private static final Logger logger = LoggerFactory.getLogger(ShoppingServiceImpl.class);

	private static final double GST = 5.0;
	private static final double DELIVERY_CHARGES_PER_KM = 7.0;
	private static final double PLATFORM_CHARGES = 2.0;
	private Random random = new Random();

	private RestaurantService restaurantService;
	private UserCartRepository userCartRepo;
	private UserInfoRepository userInfoRepo;
	private OrdersRepository ordersRepo;
	private OrderJobRepository orderJobRepo;
	
	@Autowired()
	public ShoppingServiceImpl(RestaurantService restaurantService, UserCartRepository userCartRepo,
			UserInfoRepository userInfoRepo, OrdersRepository ordersRepo, OrderJobRepository orderJobRepo) {
		this.restaurantService = restaurantService;
		this.userCartRepo = userCartRepo;
		this.userInfoRepo = userInfoRepo;
		this.ordersRepo = ordersRepo;
		this.orderJobRepo = orderJobRepo;
	}

	@Override
	public List<UserRestaurantInfo> getAllRestaurants() {
		logger.debug("Inside getAllRestaurants");
		return restaurantService.getAllRestaurant();
	}

	@Override
	public List<FoodItemInfo> getRestaurantMenu(Long restaurantId) {
		logger.debug("Inside with getRestaurantMenu restaurant id: {}", restaurantId);
		return restaurantService.getRestaurantMenu(restaurantId);
	}

	@Override
	public String addFoodItemsToCart(Long userId, CartItem foodItem, boolean forceAdd) {
		logger.debug("Inside addFoodItemsToCart with user id: {}, forceadd: {} and input: {}", userId, forceAdd,
				foodItem);

		Optional<UserCart> singleUserCart = userCartRepo.findFirstByUserId(userId);
		if (singleUserCart.isPresent() && singleUserCart.get() != null) {
			if (singleUserCart.get().getRestaurantId() == foodItem.getRestaurantId()) {
				logger.debug("restaurant ids match");
				Optional<UserCart> userCartOp = userCartRepo.findByUserIdAndItemId(userId, foodItem.getItemId());

				if (userCartOp.isPresent() && userCartOp.get() != null) {
					// if cart already have item add quantity
					UserCart usercart = userCartOp.get();
					usercart.setQuantity(foodItem.getQuantity() + usercart.getQuantity());
					userCartRepo.save(usercart);
					logger.debug("updated cart: {}", usercart);
				} else {
					// add item to cart
					UserCart userCart = new UserCart(foodItem.getRestaurantId(), foodItem.getQuantity(),
							foodItem.getItemId(), foodItem.getItemName(), foodItem.getPrice(), userId);
					userCartRepo.save(userCart);
					logger.debug("new item added to cart: {}", userCart);
				}
			} else if (singleUserCart.get().getRestaurantId() != foodItem.getRestaurantId() && forceAdd) {
				// clear cart
				clearCart(userId);
				// add item to cart
				UserCart userCart = new UserCart(foodItem.getRestaurantId(), foodItem.getQuantity(),
						foodItem.getItemId(), foodItem.getItemName(), foodItem.getPrice(), userId);
				userCartRepo.save(userCart);
				logger.debug("new item added forcefully to cart: {}", userCart);
			} else {
				// if restaurant is different throw error
				logger.debug("restaurant mismatch");
				return "restaurant mismatch";
			}
		} else {
			// if cart is empty add
			UserCart userCart = new UserCart(foodItem.getRestaurantId(), foodItem.getQuantity(), foodItem.getItemId(),
					foodItem.getItemName(), foodItem.getPrice(), userId);
			userCartRepo.save(userCart);
			logger.debug("new item added to cart: {}", userCart);
		}

		return "updated cart";
	}

	@Override
	public String removeFoodItemsFromCart(Long userId, CartItem foodItem) {
		logger.debug("Inside removeFoodItemsFromCart with user id: {}, and input: {}", userId, foodItem);

		// if cart contains item
		Optional<UserCart> userCartOp = userCartRepo.findByUserIdAndItemId(userId, foodItem.getItemId());
		if (userCartOp.isPresent() && userCartOp.get() != null) {
			UserCart userCart = userCartOp.get();
			logger.debug("user cart: {}", userCart);
			if (userCart.getQuantity() <= foodItem.getQuantity()) {
				// delete item
				userCartRepo.deleteByUserIdAndItemId(userId, foodItem.getItemId());
				logger.debug("deleted items from cart");
			} else {
				userCart.setQuantity(userCart.getQuantity() - foodItem.getQuantity());
				userCartRepo.save(userCart);
				logger.debug("removed item from cart");
			}
		}
		return "updated cart";
	}

	@Override
	public String clearCart(Long userId) {
		logger.debug("Inside clearCart with user id: {}", userId);
		userCartRepo.deleteAllByUserId(userId);
		return "cart cleared";
	}

	@Override
	public Checkout checkout(Long userId) {
		logger.debug("Inside checkout with user id: {}", userId);

		List<CartItem> cartItemList = new ArrayList<>();
		CheckoutRestaurant restaurant = null;
		CheckoutOverview overview = null;
		CheckoutUserInfo userInfo = null;

		// get food items list
		List<UserCart> userCartList = userCartRepo.findAllByUserId(userId);
		for (UserCart userCart : userCartList) {
			CartItem cartItem = new CartItem(userCart.getRestaurantId(), userCart.getQuantity(), userCart.getItemId(),
					userCart.getItemName(), userCart.getPrice());
			cartItemList.add(cartItem);
		}
		logger.debug("cart items: {}", cartItemList);

		// get restaurant details
		if (!cartItemList.isEmpty()) {
			restaurant = restaurantService.getRestaurantDetails(cartItemList.get(0).getRestaurantId());
		}

		// get overview of checkout
		if (!cartItemList.isEmpty()) {
			overview = getCheckoutOverview(userId);
		}

		// get user details
		if (!cartItemList.isEmpty()) {
			Optional<UserInfo> userOp = userInfoRepo.findById(userId);
			if (userOp.isPresent() && userOp.get() != null) {
				UserInfo user = userOp.get();
				userInfo = new CheckoutUserInfo(user.getUserId(), user.getFirstName() + " " + user.getLastName(),
						user.getLocation(), user.getEmail(), user.getPhoneNo());
			}
		}

		Checkout checkout = new Checkout(restaurant, cartItemList, overview, userInfo);
		logger.debug("checkout details: {}", checkout);
		return checkout;
	}

	private CheckoutOverview getCheckoutOverview(Long userId) {

		Integer totalItems = userCartRepo.getTotalItemsByUserId(userId);
		Integer totalQuantity = userCartRepo.getTotalQuantityByUserId(userId);
		double totalPrice = userCartRepo.getTotalPriceByUserId(userId);
		double gstPrice = totalPrice * GST / 100;
		int kms = random.nextInt(15) + 1;
		double deliveryCharges = DELIVERY_CHARGES_PER_KM * kms;
		double netPrice = totalPrice + gstPrice + deliveryCharges + PLATFORM_CHARGES;

		CheckoutOverview overview = new CheckoutOverview(totalItems, totalQuantity, totalPrice, gstPrice, kms,
				deliveryCharges, PLATFORM_CHARGES, netPrice);
		return overview;
	}

	@Override
	public Long proceedToConfirm(Long userId, Checkout checkout) {
		logger.debug("Inside proceedToConfirm with user id: {} and checout: {}", userId, checkout);

		if (checkout.getItems().isEmpty()) {
			return -1L;
		}
		List<OrderItems> orderItems = new ArrayList<>();
		for (CartItem cartItem : checkout.getItems()) {
			OrderItems orderitem = new OrderItems(cartItem.getItemId(), cartItem.getItemName(), cartItem.getPrice(),
					cartItem.getQuantity(), cartItem.getItemId() * cartItem.getPrice());
			orderItems.add(orderitem);
		}

		Orders order = new Orders(OrderStatus.OrderReceived.toString(), checkout.getOverview().getTotalPrice(),
				checkout.getOverview().getNetPrice(), checkout.getOverview().getGst(), checkout.getOverview().getKms(),
				checkout.getOverview().getDeliveryCharges(), checkout.getOverview().getPlatformCharges(), userId,
				checkout.getOverview().getTotalItems(), checkout.getOverview().getTotalQuantity(),
				checkout.getRestaurant().getRestaurantId(), checkout.getRestaurant().getRestaurantName(),
				LocalDateTime.now(), orderItems);
		ordersRepo.save(order);

		int scheduleTime = random.nextInt(5) + 3;
		OrderJob orderJob = new OrderJob(order.getOrderId(), order.getStatus(), scheduleTime, LocalDateTime.now());
		orderJobRepo.save(orderJob);
		clearCart(userId);

		logger.debug("order created: {}", order);
		return order.getOrderId();
	}

	@Override
	public List<OrderDetailsShort> getAllOrders(Long userId) {
		logger.debug("Inside getAllOrders with user id: {}", userId);

		List<Orders> orders = ordersRepo.findAllByUserId(userId);
		List<OrderDetailsShort> ordersList = new ArrayList<>();
		for (Orders order : orders) {
			OrderDetailsShort orderdetail = new OrderDetailsShort(order.getOrderId(), order.getStatus(),
					order.getNetprice(), order.getRestaurantName(), order.getOrderDateTime());
			ordersList.add(orderdetail);
		}

		logger.debug("order short details: {}", ordersList);
		return ordersList;
	}

	@Override
	public OrderDetails getOrderDetails(Long orderId) {
		logger.debug("Inside getOrderDetails with order id: {}", orderId);

		Orders order = ordersRepo.findByOrderId(orderId);
		List<OrderItemDetails> orderItems = new ArrayList<>();
		for (OrderItems orderItem : order.getItems()) {
			OrderItemDetails orderItemdetail = new OrderItemDetails(orderItem.getItemId(), orderItem.getName(),
					orderItem.getPrice(), orderItem.getQuantity(), orderItem.getTotal());
			orderItems.add(orderItemdetail);
		}
		OrderDetails orderdetail = new OrderDetails(order.getOrderId(), order.getStatus(), order.getTotalPrice(),
				order.getNetprice(), order.getGst(), order.getKms(), order.getDeliveryCharges(),
				order.getPlatformCharges(), order.getRestaurantName(), order.getOrderDateTime(), orderItems);

		logger.debug("order details: {}", orderdetail);
		return orderdetail;
	}

	@Override
	public String cancelOrder(Long orderId) {

		Orders order = ordersRepo.findByOrderId(orderId);
		if (order == null) {
			return "invalid order id";
		}
		if (!order.getStatus().equals(OrderStatus.Delivered.toString())) {
			ordersRepo.updateStatusByOrderId(orderId, OrderStatus.Cancelled.toString());
			return "order cancelled";
		}
		return "order is delivered";
	}

}
