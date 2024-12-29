package com.FoodOrder.foodOder.Admin.DTOs;

import java.util.List;

public class OrderInfo {
	private Long orderId;
	private String orderStatus;
	private Long total;
	private Long userId;
	private Integer totalItems;
	private Integer totalQuantity;
	private Long restaurantId;
	private String orderDateTime;
	private List<OrderItemInfo> items;

	public OrderInfo() {
		super();
	}

	public OrderInfo(Long orderId, String orderStatus, Long total, Long userId, Integer totalItems,
			Integer totalQuantity, Long restaurantId, String orderDateTime, List<OrderItemInfo> items) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.total = total;
		this.userId = userId;
		this.totalItems = totalItems;
		this.totalQuantity = totalQuantity;
		this.restaurantId = restaurantId;
		this.orderDateTime = orderDateTime;
		this.items = items;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public List<OrderItemInfo> getItems() {
		return items;
	}

	public void setItems(List<OrderItemInfo> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", orderStatus=" + orderStatus + ", total=" + total + ", userId="
				+ userId + ", totalItems=" + totalItems + ", totalQuantity=" + totalQuantity + ", restaurantId="
				+ restaurantId + ", orderDateTime=" + orderDateTime + ", items=" + items + "]";
	}

}
