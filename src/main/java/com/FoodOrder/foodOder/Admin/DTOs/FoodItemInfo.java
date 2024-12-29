package com.FoodOrder.foodOder.Admin.DTOs;

import java.util.List;

public class FoodItemInfo {
	private Long itemId;
	private String itemName;
	private Long price;
	private String description;
	private List<String> ingredients;
	private Long restaurantId;

	public FoodItemInfo() {
		super();
	}

	public FoodItemInfo(Long itemId, String itemname, Long price, String description, List<String> ingredients,
			Long restaurantId) {
		super();
		this.itemId = itemId;
		this.itemName = itemname;
		this.price = price;
		this.description = description;
		this.ingredients = ingredients;
		this.restaurantId = restaurantId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemname) {
		this.itemName = itemname;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return "FoodItemInfo [itemId=" + itemId + ", itemname=" + itemName + ", price=" + price + ", description="
				+ description + ", ingredients=" + ingredients + ", restaurantId=" + restaurantId + "]";
	}

}
