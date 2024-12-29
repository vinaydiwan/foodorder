package com.FoodOrder.foodOder.User.Service;

import java.util.List;

import com.FoodOrder.foodOder.Admin.DTOs.FoodItemInfo;
import com.FoodOrder.foodOder.Admin.DTOs.UserRestaurantInfo;
import com.FoodOrder.foodOder.User.DTOs.CartItem;
import com.FoodOrder.foodOder.User.DTOs.Checkout;
import com.FoodOrder.foodOder.User.DTOs.OrderDetails;
import com.FoodOrder.foodOder.User.DTOs.OrderDetailsShort;

public interface ShoppingService {

	List<UserRestaurantInfo> getAllRestaurants();

	List<FoodItemInfo> getRestaurantMenu(Long restaurantId);

	String addFoodItemsToCart(Long userId, CartItem foodItem, boolean forceAdd);

	String removeFoodItemsFromCart(Long userId, CartItem foodItem);

	Checkout checkout(Long userId);

	Long proceedToConfirm(Long userId, Checkout checkout);

	List<OrderDetailsShort> getAllOrders(Long userId);

	OrderDetails getOrderDetails(Long orderId);

	String cancelOrder(Long orderId);

	String clearCart(Long userId);

}
