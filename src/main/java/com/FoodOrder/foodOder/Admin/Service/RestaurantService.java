package com.FoodOrder.foodOder.Admin.Service;

import java.util.List;

import com.FoodOrder.foodOder.Admin.DTOs.FoodItemInfo;
import com.FoodOrder.foodOder.Admin.DTOs.NewRestaurant;
import com.FoodOrder.foodOder.Admin.DTOs.OrderInfo;
import com.FoodOrder.foodOder.Admin.DTOs.RestaurantInfo;
import com.FoodOrder.foodOder.Admin.DTOs.UserRestaurantInfo;
import com.FoodOrder.foodOder.User.DTOs.CheckoutRestaurant;

public interface RestaurantService {

	String addRestaurant(NewRestaurant restaurant);

	String editRestaurant(Long restaurantId, RestaurantInfo restaurant);

	RestaurantInfo viewRestaurant(Long restaurantId);

	String deleteRestaurant(Long restaurantId);

	List<RestaurantInfo> getAllRestaurant(Long ownerId);

	List<OrderInfo> getAllOrderDetails(Long ownerId);

	Object getSalesDetails(Long ownerId);

	List<UserRestaurantInfo> getAllRestaurant();

	List<FoodItemInfo> getRestaurantMenu(Long restaurantId);

	CheckoutRestaurant getRestaurantDetails(Long restaurantId);

}
