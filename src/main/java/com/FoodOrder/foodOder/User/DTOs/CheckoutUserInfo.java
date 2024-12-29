package com.FoodOrder.foodOder.User.DTOs;

public class CheckoutUserInfo {

	private Long userId;
	private String fullName;
	private String location;
	private String email;
	private Long mobileNumber;

	public CheckoutUserInfo() {
		super();
	}

	public CheckoutUserInfo(Long userId, String fullName, String location, String email, Long mobileNumber) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.location = location;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "CheckoutUserInfo [userId=" + userId + ", fullName=" + fullName + ", location=" + location + ", email="
				+ email + ", mobileNumber=" + mobileNumber + "]";
	}

}
