package com.FoodOrder.foodOder.User.Model;

import java.time.LocalDateTime;
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
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private Long orderId;

	@Column(name = "status")
	private String status;
	@Column(name = "totalprice")
	private double totalPrice;
	@Column(name = "netprice")
	private double netprice;
	@Column(name = "gst")
	private double gst;
	@Column(name = "kms")
	private Integer kms;
	@Column(name = "deliverycharges")
	private double deliveryCharges;
	@Column(name = "platformcharges")
	private double platformCharges;
	@Column(name = "userid")
	private Long userId;
	@Column(name = "totalitems")
	private Integer totalItems;
	@Column(name = "totalquantity")
	private Integer totalQuantity;
	@Column(name = "restaurantid")
	private Long restaurantId;
	@Column(name = "restaurantname")
	private String restaurantName;
	@Column(name = "orderDateTime")
	private LocalDateTime orderDateTime;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "orderid")
	private List<OrderItems> items;

	public Orders() {
		super();
	}

	public Orders(String status, double totalPrice, double netprice, double gst, Integer kms, double deliveryCharges,
			double platformCharges, Long userId, Integer totalItems, Integer totalQuantity, Long restaurantId,
			String restaurantName, LocalDateTime orderDateTime, List<OrderItems> items) {
		super();
		this.status = status;
		this.totalPrice = totalPrice;
		this.netprice = netprice;
		this.gst = gst;
		this.kms = kms;
		this.deliveryCharges = deliveryCharges;
		this.platformCharges = platformCharges;
		this.userId = userId;
		this.totalItems = totalItems;
		this.totalQuantity = totalQuantity;
		this.restaurantId = restaurantId;
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

	public List<OrderItems> getItems() {
		return items;
	}

	public void setItems(List<OrderItems> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", status=" + status + ", totalPrice=" + totalPrice + ", netprice="
				+ netprice + ", gst=" + gst + ", kms=" + kms + ", deliveryCharges=" + deliveryCharges
				+ ", platformCharges=" + platformCharges + ", userId=" + userId + ", totalItems=" + totalItems
				+ ", totalQuantity=" + totalQuantity + ", restaurantId=" + restaurantId + ", restaurantName="
				+ restaurantName + ", orderDateTime=" + orderDateTime + ", items=" + items + "]";
	}

}
