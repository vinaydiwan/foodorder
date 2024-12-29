package com.FoodOrder.foodOder.User.DTOs;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDetails {
	private Long orderId;
	private String status;
	private double totalPrice;
	private double netprice;
	private double gst;
	private Integer kms;
	private double deliveryCharges;
	private double platformCharges;
	private String restaurantName;
	private LocalDateTime orderDateTime;
	private List<OrderItemDetails> items;

	public OrderDetails() {
		super();
	}

	public OrderDetails(Long orderId, String status, double totalPrice, double netprice, double gst, Integer kms,
			double deliveryCharges, double platformCharges, String restaurantName, LocalDateTime orderDateTime,
			List<OrderItemDetails> items) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.totalPrice = totalPrice;
		this.netprice = netprice;
		this.gst = gst;
		this.kms = kms;
		this.deliveryCharges = deliveryCharges;
		this.platformCharges = platformCharges;
		this.restaurantName = restaurantName;
		this.orderDateTime = orderDateTime;
		this.items = items;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getNetprice() {
		return netprice;
	}

	public void setNetprice(double netprice) {
		this.netprice = netprice;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public Integer getKms() {
		return kms;
	}

	public void setKms(Integer kms) {
		this.kms = kms;
	}

	public double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public double getPlatformCharges() {
		return platformCharges;
	}

	public void setPlatformCharges(double platformCharges) {
		this.platformCharges = platformCharges;
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

	public List<OrderItemDetails> getItems() {
		return items;
	}

	public void setItems(List<OrderItemDetails> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", status=" + status + ", totalPrice=" + totalPrice + ", netprice="
				+ netprice + ", gst=" + gst + ", kms=" + kms + ", deliveryCharges=" + deliveryCharges
				+ ", platformCharges=" + platformCharges + ", restaurantName=" + restaurantName + ", orderDateTime="
				+ orderDateTime + ", items=" + items + "]";
	}

}
