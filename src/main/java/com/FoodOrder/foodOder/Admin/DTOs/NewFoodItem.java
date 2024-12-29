package com.FoodOrder.foodOder.Admin.DTOs;

import java.util.List;

public class NewFoodItem {
	private String itemname;
	private Long price;
	private String description;
	private List<String> ingredients;

	public NewFoodItem() {
		super();
	}

	public NewFoodItem(String itemname, Long price, String description, List<String> ingredients) {
		super();
		this.itemname = itemname;
		this.price = price;
		this.description = description;
		this.ingredients = ingredients;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
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

	@Override
	public String toString() {
		return "NewFoodItem [itemname=" + itemname + ", price=" + price + ", description=" + description
				+ ", ingredients=" + ingredients + "]";
	}

}
