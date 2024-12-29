package com.FoodOrder.foodOder.User.DTOs;

import java.time.LocalDateTime;

public class OrderDetailsShort {
	private Long orderId;
	private String status;
	private double netprice;
	private String restaurantName;
	private LocalDateTime orderDateTime;

	public OrderDetailsShort() {
		super();
	}

	public OrderDetailsShort(Long orderId, String status, double netprice, String restaurantName,
			LocalDateTime orderDateTime) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.netprice = netprice;
		this.restaurantName = restaurantName;
		this.orderDateTime = orderDateTime;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getNetprice() {
		return netprice;
	}

	public void setNetprice(double netprice) {
		this.netprice = netprice;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	@Override
	public String toString() {
		return "OrderDetailsShort [orderId=" + orderId + ", status=" + status + ", netprice=" + netprice
				+ ", restaurantName=" + restaurantName + ", orderDateTime=" + orderDateTime + "]";
	}

}
