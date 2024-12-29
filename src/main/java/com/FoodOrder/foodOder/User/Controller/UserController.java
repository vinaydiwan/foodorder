package com.FoodOrder.foodOder.User.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodOrder.foodOder.Admin.DTOs.FoodItemInfo;
import com.FoodOrder.foodOder.Admin.DTOs.UserRestaurantInfo;
import com.FoodOrder.foodOder.User.DTOs.CartItem;
import com.FoodOrder.foodOder.User.DTOs.Checkout;
import com.FoodOrder.foodOder.User.DTOs.NewUser;
import com.FoodOrder.foodOder.User.DTOs.OrderDetails;
import com.FoodOrder.foodOder.User.DTOs.OrderDetailsShort;
import com.FoodOrder.foodOder.User.DTOs.UserLogin;
import com.FoodOrder.foodOder.User.Service.ShoppingService;
import com.FoodOrder.foodOder.User.Service.UserService;

@RestController
@RequestMapping("/u")
public class UserController {

//	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	private UserService userService;
	private ShoppingService shoppingService;

	public UserController(UserService userService, ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
		this.userService = userService;
	}

	@PostMapping("/signup")
	public String signup(@RequestBody NewUser newUser) {
		return userService.signup(newUser);
	}

	@PostMapping("/login")
	public String login(@RequestBody UserLogin userLogin) {
		return userService.login(userLogin);
	}

	@PostMapping("/logout")
	public String logout(@RequestBody UserLogin userLogin) {
		return userService.logout(userLogin);
	}

	@GetMapping("/restaurants")
	public List<UserRestaurantInfo> getAllRestaurants() {
		return shoppingService.getAllRestaurants();
	}

	@GetMapping("/restaurant/{restaurantId}")
	public List<FoodItemInfo> getRestaurantMenu(@PathVariable() Long restaurantId) {
		return shoppingService.getRestaurantMenu(restaurantId);
	}

	@PutMapping("/addtocart/{userId}/{forceAdd}")
	public String addFoodItemsToCart(@PathVariable() Long userId, @PathVariable() boolean forceAdd,
			@RequestBody CartItem foodItem) {
		return shoppingService.addFoodItemsToCart(userId, foodItem, forceAdd);
	}

	@PutMapping("/removefromcart/{userId}")
	public String removeFoodItemsFromCart(@PathVariable() Long userId, @RequestBody CartItem foodItem) {
		return shoppingService.removeFoodItemsFromCart(userId, foodItem);
	}

	@PutMapping("/clearcart/{userId}")
	public String clearCart(@PathVariable() Long userId) {
		return shoppingService.clearCart(userId);
	}

	@GetMapping("/checkout/{userId}")
	public Checkout checkout(@PathVariable() Long userId) {
		return shoppingService.checkout(userId);
	}

	@PutMapping("/proceedtoconfirm/{userId}")
	public Long proceedToConfirm(@PathVariable() Long userId, @RequestBody Checkout checkout) {
		return shoppingService.proceedToConfirm(userId, checkout);
	}

	@GetMapping("/orders/{userId}")
	public List<OrderDetailsShort> getAllOrders(@PathVariable() Long userId) {
		return shoppingService.getAllOrders(userId);
	}

	@GetMapping("/order/{orderId}")
	public OrderDetails getOrderDetails(@PathVariable() Long orderId) {
		return shoppingService.getOrderDetails(orderId);
	}

	@PutMapping("/ordercancel/{orderId}")
	public String cancelOrder(@PathVariable() Long orderId) {
		return shoppingService.cancelOrder(orderId);
	}
	
}
