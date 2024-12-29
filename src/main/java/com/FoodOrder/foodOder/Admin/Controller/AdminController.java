package com.FoodOrder.foodOder.Admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodOrder.foodOder.Admin.DTOs.AdminLogin;
import com.FoodOrder.foodOder.Admin.DTOs.NewAdmin;
import com.FoodOrder.foodOder.Admin.DTOs.NewRestaurant;
import com.FoodOrder.foodOder.Admin.DTOs.RestaurantInfo;
import com.FoodOrder.foodOder.Admin.Service.AdminService;
import com.FoodOrder.foodOder.Admin.Service.RestaurantService;

@RestController
@RequestMapping("/a")
public class AdminController {

	private AdminService adminService;
	private RestaurantService restaurantService;
//	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	public AdminController(AdminService adminService, RestaurantService restaurantService) {
		this.adminService = adminService;
		this.restaurantService = restaurantService;
	}

	@PostMapping("/signup")
	public String signup(@RequestBody NewAdmin newAdmin) {
		return adminService.signup(newAdmin);
	}

	@PostMapping("/login")
	public String login(@RequestBody AdminLogin adminLogin) {
		return adminService.login(adminLogin);
	}

	@PostMapping("/logout")
	public String logout(@RequestBody AdminLogin adminLogin) {
		return adminService.logout(adminLogin);
	}

	@PostMapping("/restaurant")
	public String addRestaurant(@RequestBody NewRestaurant restaurant) {
		return restaurantService.addRestaurant(restaurant);
	}

	@PutMapping("/restaurant/{restaurantId}")
	public String editRestaurant(@PathVariable() Long restaurantId, @RequestBody RestaurantInfo restaurant) {
		return restaurantService.editRestaurant(restaurantId, restaurant);
	}

	@GetMapping("/restaurants/{ownerId}")
	public List<RestaurantInfo> getAllRestaurant(@PathVariable() Long ownerId) {
		return restaurantService.getAllRestaurant(ownerId);
	}

	@GetMapping(value = "/restaurant/{restaurantId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public RestaurantInfo viewRestaurant(@PathVariable() Long restaurantId) {
		return restaurantService.viewRestaurant(restaurantId);
	}

	@DeleteMapping("/restaurant/{restaurantId}")
	public String deleteRestaurant(@PathVariable() Long restaurantId) {
		return restaurantService.deleteRestaurant(restaurantId);
	}

//	@GetMapping("/orders/{ownerId}")
//	public List<OrderInfo> getOrderDetails(@PathVariable() Long ownerId) {
//		return restaurantService.getAllOrderDetails(ownerId);
//	}

//	@GetMapping("/sales/{ownerId}")
//	public Object getSalesDetails(@PathVariable() Long ownerId) {
//		return restaurantService.getSalesDetails(ownerId);
//	}

}
