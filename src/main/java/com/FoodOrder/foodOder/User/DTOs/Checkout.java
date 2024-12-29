package com.FoodOrder.foodOder.User.DTOs;

import java.util.List;

public class Checkout {
// user details

	CheckoutRestaurant restaurant;
	List<CartItem> items;
	CheckoutOverview overview;
	CheckoutUserInfo user;

	public Checkout() {
		super();
	}

	public Checkout(CheckoutRestaurant restaurant, List<CartItem> items, CheckoutOverview overview,
			CheckoutUserInfo user) {
		super();
		this.restaurant = restaurant;
		this.items = items;
		this.overview = overview;
		this.user = user;
	}

	public CheckoutRestaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(CheckoutRestaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public CheckoutOverview getOverview() {
		return overview;
	}

	public void setOverview(CheckoutOverview overview) {
		this.overview = overview;
	}

	public CheckoutUserInfo getUser() {
		return user;
	}

	public void setUser(CheckoutUserInfo user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Checkout [restaurant=" + restaurant + ", items=" + items + ", overview=" + overview + ", user=" + user
				+ "]";
	}

}
