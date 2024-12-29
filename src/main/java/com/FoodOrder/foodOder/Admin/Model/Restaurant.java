package com.FoodOrder.foodOder.Admin.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurants")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurantid")
	private Long restaurantId;

	@Column(name = "restaurantname")
	private String restaurantName;
	@Column(name = "location")
	private String location;
	@Column(name = "description")
	private String description;
	@Column(name = "ownerid")
	private Long ownerId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurantid")
	private List<FoodItem> foodItems;

	public Restaurant() {
		super();
	}

	public Restaurant(Long restaurantId, String restaurantName, String location, String description, Long ownerId,
			List<FoodItem> foodItems) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.location = location;
		this.description = description;
		this.foodItems = foodItems;
		this.ownerId = ownerId;
	}

	public Restaurant(String restaurantName, String location, String description, Long ownerId,
			List<FoodItem> foodItems) {
		super();
		this.restaurantName = restaurantName;
		this.location = location;
		this.description = description;
		this.ownerId = ownerId;
		this.foodItems = foodItems;
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

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", location="
				+ location + ", description=" + description + ", ownerId=" + ownerId + ", foodItems=" + foodItems + "]";
	}

}
