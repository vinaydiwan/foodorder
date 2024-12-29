package com.FoodOrder.foodOder.User.DTOs;

public class CheckoutRestaurant {
	private Long restaurantId;
	private String restaurantName;
	private String location;

	public CheckoutRestaurant() {
		super();
	}

	public CheckoutRestaurant(Long restaurantId, String restaurantName, String location) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.location = location;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "CheckoutRestaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", location="
				+ location + "]";
	}

}
