package com.FoodOrder.foodOder.User.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usercart")
public class UserCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "restaurantid")
	private Long restaurantId;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "itemid")
	private Long itemId;

	@Column(name = "itemname")
	private String itemName;

	@Column(name = "price")
	private Long price;

	@Column(name = "userid")
	private Long userId;

	public UserCart() {
		super();
	}

	public UserCart(Long restaurantId, Integer quantity, Long itemId, String itemName, Long price, Long userId) {
		super();
		this.restaurantId = restaurantId;
		this.quantity = quantity;
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserCart [id=" + id + ", restaurantId=" + restaurantId + ", quantity=" + quantity + ", itemId=" + itemId
				+ ", itemName=" + itemName + ", price=" + price + ", userId=" + userId + "]";
	}

}
