package com.FoodOrder.foodOder.Admin.DTOs;

public class UserRestaurantInfo {
	private Long restaurantId;
	private String restaurantName;
	private String location;
	private String description;

	public UserRestaurantInfo() {
		super();
	}

	public UserRestaurantInfo(Long restaurantId, String restaurantName, String location, String description) {
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

	@Override
	public String toString() {
		return "UserRestaurantInfo [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", location="
				+ location + ", description=" + description + "]";
	}

}
