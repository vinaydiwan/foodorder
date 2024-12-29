package com.FoodOrder.foodOder.Admin.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodOrder.foodOder.Admin.DTOs.FoodItemInfo;
import com.FoodOrder.foodOder.Admin.DTOs.NewFoodItem;
import com.FoodOrder.foodOder.Admin.DTOs.NewRestaurant;
import com.FoodOrder.foodOder.Admin.DTOs.OrderInfo;
import com.FoodOrder.foodOder.Admin.DTOs.RestaurantInfo;
import com.FoodOrder.foodOder.Admin.DTOs.UserRestaurantInfo;
import com.FoodOrder.foodOder.Admin.Model.FoodItem;
import com.FoodOrder.foodOder.Admin.Model.Restaurant;
import com.FoodOrder.foodOder.Admin.Repository.FoodItemRepository;
import com.FoodOrder.foodOder.Admin.Repository.RestaurantRepository;
import com.FoodOrder.foodOder.Admin.Service.RestaurantService;
import com.FoodOrder.foodOder.User.DTOs.CheckoutRestaurant;
import com.FoodOrder.foodOder.User.Model.Orders;
import com.FoodOrder.foodOder.User.Repository.OrdersRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	private RestaurantRepository restaurantRepo;
	private FoodItemRepository foodItemRepo;
	private OrdersRepository ordersRepo;

	@Autowired
	public RestaurantServiceImpl(RestaurantRepository restaurantRepo, FoodItemRepository foodItemRepo,
			OrdersRepository ordersRepo) {
		this.restaurantRepo = restaurantRepo;
		this.foodItemRepo = foodItemRepo;
		this.ordersRepo = ordersRepo;
	}

	@Override
	public String addRestaurant(NewRestaurant restaurant) {
		logger.debug("Inside addRestaurant with input: {}", restaurant);
		List<FoodItem> foodItems = new ArrayList<>();
		List<NewFoodItem> newFoodItems = restaurant.getFoodItems();

		for (NewFoodItem newFoodItem : newFoodItems) {
			FoodItem foodItem = new FoodItem(newFoodItem.getItemname(), newFoodItem.getPrice(),
					newFoodItem.getDescription(), newFoodItem.getIngredients());
			foodItems.add(foodItem);
		}

		Restaurant res = new Restaurant(restaurant.getRestaurantName(), restaurant.getLocation(),
				restaurant.getDescription(), restaurant.getOwnerId(), foodItems);
		try {
			restaurantRepo.save(res);
			logger.debug("new restaurant details added: {}", res);
		} catch (Exception e) {
			logger.error("Error while adding restaurant details: ", e);
			return "unsuccessful";
		}
		return "successful";
	}

	@Override
	public String editRestaurant(Long restaurantId, RestaurantInfo restaurant) {
		logger.debug("Inside editRestaurant with restaurantId and input: {}, {}", restaurantId, restaurant);
		List<FoodItem> foodItems = new ArrayList<>();

		// edit fooditems
		for (FoodItemInfo foodItem : restaurant.getFoodItems()) {
			FoodItem editFoodItem = new FoodItem(foodItem.getItemId(), foodItem.getItemName(), foodItem.getPrice(),
					foodItem.getDescription(), foodItem.getIngredients(), restaurantId);
			foodItems.add(editFoodItem);
		}

		// add fooditems
		for (NewFoodItem newFoodItem : restaurant.getNewfoodItems()) {
			FoodItem foodItem = new FoodItem(newFoodItem.getItemname(), newFoodItem.getPrice(),
					newFoodItem.getDescription(), newFoodItem.getIngredients());
			foodItems.add(foodItem);
		}

		// delete foodItem
		foodItemRepo.deleteAllByIdInBatch(restaurant.getDelfoodItems());

		Restaurant res = new Restaurant(restaurantId, restaurant.getRestaurantName(), restaurant.getLocation(),
				restaurant.getDescription(), restaurant.getOwnerId(), foodItems);
		logger.debug("new restaurant data: {}", res);
		try {
			restaurantRepo.save(res);
		} catch (Exception e) {
			logger.error("Error inside editRestaurant: ", e);
			return "unsuccessful";
		}
		return "successful";
	}

	@Override
	public RestaurantInfo viewRestaurant(Long restaurantId) {
		logger.debug("Inside viewRestaurant with restaurantId: {}", restaurantId);

		List<FoodItemInfo> foodItemList = new ArrayList<>();
		Restaurant restaurant = restaurantRepo.findByRestaurantId(restaurantId);
		for (FoodItem foodItem : restaurant.getFoodItems()) {
			FoodItemInfo foodItemInfo = new FoodItemInfo(foodItem.getItemId(), foodItem.getName(), foodItem.getPrice(),
					foodItem.getDescription(), foodItem.getIngredients(), restaurantId);
			foodItemList.add(foodItemInfo);
		}

		RestaurantInfo resInfo = new RestaurantInfo(restaurant.getRestaurantId(), restaurant.getRestaurantName(),
				restaurant.getLocation(), restaurant.getDescription(), restaurant.getOwnerId(), foodItemList);
		logger.debug("restaurant details: {}", resInfo);
		return resInfo;
	}

	@Override
	public String deleteRestaurant(Long restaurantId) {
		logger.debug("Inside deleteRestaurant with restaurantId: {}", restaurantId);
		try {
			restaurantRepo.deleteById(restaurantId);
		} catch (Exception e) {
			logger.error("Error while deleting restaurant details: ", e);
			return "unsuccessful";
		}
		return "successful";
	}

	@Override
	public List<RestaurantInfo> getAllRestaurant(Long ownerId) {
		logger.debug("Inside getAllRestaurant wth owner id: {}", ownerId);

		// get restaurant details
		List<RestaurantInfo> restaurantList = new ArrayList<>();
		List<Restaurant> restaurants = restaurantRepo.findByOwnerId(ownerId);
		for (Restaurant restaurant : restaurants) {
			RestaurantInfo resInfo = new RestaurantInfo(restaurant.getRestaurantId(), restaurant.getRestaurantName(),
					restaurant.getLocation(), restaurant.getDescription());
			restaurantList.add(resInfo);
		}

		logger.debug("restaurant details owned by-{}: {}", ownerId, restaurantList);
		return restaurantList;
	}

	@Override
	public List<UserRestaurantInfo> getAllRestaurant() {
		logger.debug("Inside getAllRestaurant");

		// get restaurant details
		List<UserRestaurantInfo> restaurantList = new ArrayList<>();
		List<Restaurant> restaurants = restaurantRepo.findAll();
		for (Restaurant restaurant : restaurants) {
			UserRestaurantInfo resInfo = new UserRestaurantInfo(restaurant.getRestaurantId(),
					restaurant.getRestaurantName(), restaurant.getLocation(), restaurant.getDescription());
			restaurantList.add(resInfo);
		}

		logger.debug("restaurant details: {}", restaurantList);
		return restaurantList;
	}
	
	@Override
	public List<FoodItemInfo> getRestaurantMenu(Long restaurantId) {
		logger.debug("Inside getRestaurantMenu with restaurantId: {}", restaurantId);
		List<FoodItemInfo> foodItemList = new ArrayList<>();

		List<FoodItem> foodItemsList = foodItemRepo.findAllByRestaurantId(restaurantId);
		for (FoodItem foodItem : foodItemsList) {
			FoodItemInfo foodItemInfo = new FoodItemInfo(foodItem.getItemId(), foodItem.getName(), foodItem.getPrice(),
					foodItem.getDescription(), foodItem.getIngredients(), restaurantId);
			foodItemList.add(foodItemInfo);
		}

		logger.debug("restaurant menu: {}", foodItemList);
		return foodItemList;
	}

	@Override
	public CheckoutRestaurant getRestaurantDetails(Long restaurantId) {
		logger.debug("Inside CheckoutRestaurant with restaurantId: {}", restaurantId);

		Restaurant restaurant = restaurantRepo.findByRestaurantId(restaurantId);
		CheckoutRestaurant checkoutRestaurant = new CheckoutRestaurant(restaurant.getRestaurantId(), restaurant.getRestaurantName(),
				restaurant.getLocation());
		return checkoutRestaurant;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<OrderInfo> getAllOrderDetails(Long ownerId) {
		logger.debug("Inside getAllOrderDetails with ownerId: {}", ownerId);

		List<OrderInfo> orderInfoList = new ArrayList<>();
		List<Long> restaurantIds = restaurantRepo.findRestaurantIdByOwnerId(ownerId);

		// get all order by restaurant Id
//		List<Orders> orders = ordersRepo.findAllByRestaurantIdInOrderByOrderIdDesc(restaurantIds);
//		for (Orders order : orders) {
//			List<OrderItems> orderItems = order.getItems();
//			List<OrderItemInfo> orderItemInfoList = new ArrayList<>();
//			for (OrderItems orderItem : orderItems) {
//				OrderItemInfo orderItemInfo = new OrderItemInfo(orderItem.getOrderItemId(), orderItem.getName(),
//						orderItem.getPrice(), orderItem.getQuantity(), orderItem.getTotal());
//				orderItemInfoList.add(orderItemInfo);
//			}
//			OrderInfo orderInfo = new OrderInfo(order.getOrderId(), order.getStatus(), order.getTotal(),
//					order.getUserId(), order.getTotalItems(), order.getTotalQuantity(), order.getRestaurantId(),
//					order.getOrderDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
//					orderItemInfoList);
//			orderInfoList.add(orderInfo);
//		}
		logger.debug("order info list: {}", orderInfoList);
		return orderInfoList;
	}

	@Override
	public Object getSalesDetails(Long ownerId) {

		// total no of orders
		// no of orders based on yr
		// orders from ech restaurant

		// total income
		// income based on yr
		// income from each restaurant

		List<Long> restaurantIds = restaurantRepo.findRestaurantIdByOwnerId(ownerId);
		List<Orders> orders = ordersRepo.findAllByRestaurantIdInOrderByOrderIdDesc(restaurantIds);

		return null;
	}
	
}
