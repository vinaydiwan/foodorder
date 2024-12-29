package com.FoodOrder.foodOder.Admin.DTOs;

public class OrderItemInfo {
	private Long itemId;
	private String itemName;
	private Long price;
	private Integer quantity;
	private Long total;

	public OrderItemInfo() {
		super();
	}

	public OrderItemInfo(Long itemId, String itemName, Long price, Integer quantity, Long total) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
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
		return "OrderItemInfo [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", quantity="
				+ quantity + ", total=" + total + "]";
	}

}
