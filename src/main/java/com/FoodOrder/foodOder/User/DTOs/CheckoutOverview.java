package com.FoodOrder.foodOder.User.DTOs;

public class CheckoutOverview {
	private Integer totalItems;
	private Integer totalQuantity;
	private double totalPrice;
	private double gst;
	private Integer kms;
	private double deliveryCharges;
	private double platformCharges;
	private double netPrice;

	public CheckoutOverview() {
		super();
	}

	public CheckoutOverview(Integer totalItems, Integer totalQuantity, double totalPrice, double gst, Integer kms,
			double deliveryCharges, double platformCharges, double netPrice) {
		super();
		this.totalItems = totalItems;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.gst = gst;
		this.kms = kms;
		this.deliveryCharges = deliveryCharges;
		this.platformCharges = platformCharges;
		this.netPrice = netPrice;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
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

	public double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	@Override
	public String toString() {
		return "CheckoutOverview [totalItems=" + totalItems + ", totalQuantity=" + totalQuantity + ", totalPrice="
				+ totalPrice + ", gst=" + gst + ", kms=" + kms + ", deliveryCharges=" + deliveryCharges + ", platformCharges="
				+ platformCharges + ", netPrice=" + netPrice + "]";
	}

}
