package com.FoodOrder.foodOder.User.Service.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodOrder.foodOder.Admin.Exception.CustomException;
import com.FoodOrder.foodOder.Shared.Validators;
import com.FoodOrder.foodOder.User.DTOs.NewUser;
import com.FoodOrder.foodOder.User.DTOs.UserLogin;
import com.FoodOrder.foodOder.User.Model.UserInfo;
import com.FoodOrder.foodOder.User.Repository.UserInfoRepository;
import com.FoodOrder.foodOder.User.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserInfoRepository userInfoRepo;
	private Validators validator;

	@Autowired
	public UserServiceImpl(Validators validator, UserInfoRepository userInfoRepo) {
		this.validator = validator;
		this.userInfoRepo = userInfoRepo;
	}

	@Override
	public String signup(NewUser newUser) {
		logger.debug("Inside signup with user info: {}", newUser);

		try {
			// match passwords and validate password
			validator.matchAndValidateUsernamePassword(newUser.getUsername(), newUser.getPassword(),
					newUser.getConfirmPassword());
			// validate other fields
			validator.validateNameAndEmail(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail());
			// validate mobile number
			validator.validateMobileNumber(newUser.getMobileNumber());
			// check if user already exist
			checkIfAdminAndEmailAlreadyExist(newUser.getUsername(), newUser.getEmail());

			// add User
			UserInfo user = new UserInfo(newUser.getUsername(), newUser.getEmail(), newUser.getFirstName(),
					newUser.getLastName(), newUser.getPassword(), newUser.getLocation(), newUser.getMobileNumber());
			userInfoRepo.save(user);

			return "successful";
		} catch (CustomException e) {
			logger.error("Error while creating new user: ", e);
			return e.getMessage();
		} catch (Exception e) {
			logger.error("Error while creating new user: ", e);
			return "invalid credentials";
		}
	}

	@Override
	public String login(UserLogin userLogin) {
		logger.debug("Inside login with user info: {}", userLogin);

		try {
			UserInfo user = userInfoRepo.findByUserName(userLogin.getUsername());
			// check if user exist
			if (user == null) {
				throw new CustomException("user not found");
			}
			// validate user with password
			validator.validatePasswords(userLogin.getPassword(), user.getPassword());

			logger.info("User login successful");
			return "successful";
		} catch (CustomException e) {
			logger.error("Error while logging in user: ", e);
			return e.getMessage();
		} catch (Exception e) {
			logger.error("Error while logging in user: ", e);
			return "invalid username or password";
		}
	}

	@Override
	public String logout(UserLogin userLogin) {
		logger.debug("Inside logout with user info: {}", userLogin);

		try {
			UserInfo user = userInfoRepo.findByUserName(userLogin.getUsername());
			// check if user exist
			if (user == null) {
				throw new CustomException("user not found");
			}
			logger.info("User logout successful");
			return "successful";
		} catch (CustomException e) {
			logger.error("Error while logging out user: ", e);
			return e.getMessage();
		} catch (Exception e) {
			logger.error("Error while logging out user: ", e);
			return "unsuccessful";
		}
	}

	private void checkIfAdminAndEmailAlreadyExist(String username, String email) {
		int count = userInfoRepo.countByUserName(username);
		if (count != 0) {
			throw new CustomException("user already exist");
		}

		int emailcount = userInfoRepo.countByEmail(email);
		if (emailcount != 0) {
			throw new CustomException("email already exist");
		}
	}
}
