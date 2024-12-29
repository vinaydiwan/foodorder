package com.FoodOrder.foodOder.Admin.DTOs;

import java.util.List;

public class NewRestaurant {
	private String restaurantName;
	private Long ownerId; // adminId
	private String location;
	private String description;
	private List<NewFoodItem> foodItems;

	public NewRestaurant() {
		super();
	}

	public NewRestaurant(String restaurantName, Long ownerId, String location, String description,
			List<NewFoodItem> foodItems) {
		super();
		this.restaurantName = restaurantName;
		this.ownerId = ownerId;
		this.location = location;
		this.description = description;
		this.foodItems = foodItems;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<NewFoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<NewFoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	@Override
	public String toString() {
		return "NewRestaurant [restaurantName=" + restaurantName + ", ownerId=" + ownerId + ", location=" + location
				+ ", description=" + description + ", foodItems=" + foodItems + "]";
	}

}
