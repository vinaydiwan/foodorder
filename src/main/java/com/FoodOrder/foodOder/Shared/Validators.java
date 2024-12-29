package com.FoodOrder.foodOder.Shared;

import org.springframework.stereotype.Component;

import com.FoodOrder.foodOder.Admin.Exception.CustomException;

@Component
public class Validators {

	public void matchAndValidateUsernamePassword(String username, String password, String confirmPassword)
			throws CustomException {
		if (!password.equals(confirmPassword)) {
			throw new CustomException("password mismatch");
		}

		String usernameRegex = "^[a-zA-Z0-9]{6,15}$";
		if (!username.matches(usernameRegex)) {
			throw new CustomException("invalid username or password");
		}
		String passwordRegex = "^[a-zA-Z0-9_]{8,15}$";
		if (!password.matches(passwordRegex)) {
			throw new CustomException("invalid username or password");
		}
	}

	public void validateNameAndEmail(String firstName, String lastName, String email) throws CustomException {
		String nameRegex = "^[a-zA-Z ]{4,25}$";
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

		if (!firstName.matches(nameRegex)) {
			throw new CustomException("invalid credentials");
		}
		if (!lastName.matches(nameRegex)) {
			throw new CustomException("invalid credentials");
		}
		if (!email.matches(emailRegex)) {
			throw new CustomException("invalid credentials");
		}
	}

	public void validatePasswords(String inputPass, String savedPass) throws CustomException {
		if (!inputPass.equals(savedPass)) {
			throw new CustomException("invalid username or password");
		}
	}

	public void validateMobileNumber(Long mobileNumber) {
		String mobileNumberRegex = "^[0-9]{10}$";
		if (!mobileNumber.toString().matches(mobileNumberRegex)) {
			throw new CustomException("invalid mobile number");
		}
	}
}
