package com.FoodOrder.foodOder.User.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderitems")
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderitemid")
	private Long orderItemId;

	@Column(name = "itemid")
	private Long itemId;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private Long price;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "total")
	private Long total;

	@Column(name = "orderid")
	private Long orderId;

	public OrderItems() {
		super();
	}

	public OrderItems(Long itemId, String name, Long price, Integer quantity, Long total) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
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

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderItems [orderItemId=" + orderItemId + ", itemId=" + itemId + ", name=" + name + ", price=" + price
				+ ", quantity=" + quantity + ", total=" + total + ", orderId=" + orderId + "]";
	}

}
