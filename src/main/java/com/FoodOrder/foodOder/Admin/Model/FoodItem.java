package com.FoodOrder.foodOder.Admin.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fooditems")
public class FoodItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itemid")
	private Long itemId;

	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private Long price;
	@Column(name = "description")
	private String description;
	@Column(name = "ingredients")
	private List<String> ingredients;
	@Column(name = "restaurantid")
	private Long restaurantId;

	public FoodItem() {
		super();
	}

	public FoodItem(Long itemId, String name, Long price, String description, List<String> ingredients) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.ingredients = ingredients;
	}

	public FoodItem(String name, Long price, String description, List<String> ingredients) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.ingredients = ingredients;
	}

	public FoodItem(Long itemId, String name, Long price, String description, List<String> ingredients,
			Long restaurantId) {
		super();
		this.itemId = itemId;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "FoodItem [itemId=" + itemId + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", ingredients=" + ingredients + ", restaurantId=" + restaurantId + "]";
	}

}
