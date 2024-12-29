package com.FoodOrder.foodOder.User.DTOs;

public class OrderItemDetails {
	private Long itemId;
	private String name;
	private Long price;
	private Integer quantity;
	private Long total;

	public OrderItemDetails() {
		super();
	}

	public OrderItemDetails(Long itemId, String name, Long price, Integer quantity, Long total) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderItemDetails [itemId=" + itemId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", total=" + total + "]";
	}

}
