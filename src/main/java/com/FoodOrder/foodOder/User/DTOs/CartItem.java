package com.FoodOrder.foodOder.User.DTOs;

public class CartItem {
	private Long restaurantId;
	private Integer quantity;
	private Long itemId;
	private String itemName;
	private Long price;

	public CartItem() {
		super();
	}

	public CartItem(Long restaurantId, Integer quantity, Long itemId, String itemName, Long price) {
		super();
		this.restaurantId = restaurantId;
		this.quantity = quantity;
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItem [restaurantId=" + restaurantId + ", quantity=" + quantity + ", itemId=" + itemId
				+ ", itemName=" + itemName + ", price=" + price + "]";
	}

}
