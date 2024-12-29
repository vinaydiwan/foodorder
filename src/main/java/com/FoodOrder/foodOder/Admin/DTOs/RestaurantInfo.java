package com.FoodOrder.foodOder.Admin.DTOs;

import java.util.List;

public class RestaurantInfo {
	private Long restaurantId;
	private String restaurantName;
	private String location;
	private String description;
	private Long ownerId;
	private List<FoodItemInfo> foodItems;
	private List<NewFoodItem> newfoodItems;
	private List<Long> delfoodItems;

	public RestaurantInfo() {
		super();
	}

	public RestaurantInfo(Long restaurantId, String restaurantName, String location, String description, Long ownerId,
			List<FoodItemInfo> foodItems) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.location = location;
		this.description = description;
		this.ownerId = ownerId;
		this.foodItems = foodItems;
	}

	public RestaurantInfo(Long restaurantId, String restaurantName, String location, String description,
			List<FoodItemInfo> foodItems, List<NewFoodItem> newfoodItems, List<Long> delfoodItems) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.location = location;
		this.description = description;
		this.foodItems = foodItems;
		this.newfoodItems = newfoodItems;
		this.delfoodItems = delfoodItems;
	}

	public RestaurantInfo(Long restaurantId, String restaurantName, String location, String description) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.location = location;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public List<FoodItemInfo> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItemInfo> foodItems) {
		this.foodItems = foodItems;
	}

	public List<NewFoodItem> getNewfoodItems() {
		return newfoodItems;
	}

	public void setNewfoodItems(List<NewFoodItem> newfoodItems) {
		this.newfoodItems = newfoodItems;
	}

	public List<Long> getDelfoodItems() {
		return delfoodItems;
	}

	public void setDelfoodItems(List<Long> delfoodItems) {
		this.delfoodItems = delfoodItems;
	}

	@Override
	public String toString() {
		return "RestaurantInfo [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", location="
				+ location + ", description=" + description + ", ownerId=" + ownerId + ", foodItems=" + foodItems
				+ ", newfoodItems=" + newfoodItems + ", delfoodItems=" + delfoodItems + "]";
	}

}
