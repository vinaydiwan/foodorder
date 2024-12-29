package com.FoodOrder.foodOder.Admin.Service.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodOrder.foodOder.Admin.DTOs.AdminLogin;
import com.FoodOrder.foodOder.Admin.DTOs.NewAdmin;
import com.FoodOrder.foodOder.Admin.Exception.CustomException;
import com.FoodOrder.foodOder.Admin.Model.AdminInfo;
import com.FoodOrder.foodOder.Admin.Repository.AdminInfoRepository;
import com.FoodOrder.foodOder.Admin.Service.AdminService;
import com.FoodOrder.foodOder.Shared.Validators;

@Service
public class AdminServiceImpl implements AdminService {
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	private AdminInfoRepository adminInfoRepo;
	private Validators validator;

	@Autowired
	public AdminServiceImpl(AdminInfoRepository adminInfoRepo, Validators validator) {
		this.adminInfoRepo = adminInfoRepo;
		this.validator = validator;
	}

	@Override
	public String signup(NewAdmin newAdmin) {
		logger.debug("Inside signup with admin info: {}", newAdmin);

		try {
			// match passwords and validate password
			validator.matchAndValidateUsernamePassword(newAdmin.getUsername(), newAdmin.getPassword(),
					newAdmin.getConfirmPassword());
			// validate other fields
			validator.validateNameAndEmail(newAdmin.getFirstname(), newAdmin.getLastname(), newAdmin.getEmail());
			// check if user already exist
			checkIfAdminAndEmailAlreadyExist(newAdmin.getUsername(), newAdmin.getEmail());

			// add admin
			AdminInfo admin = new AdminInfo(newAdmin.getUsername(), newAdmin.getFirstname(), newAdmin.getLastname(),
					newAdmin.getEmail(), newAdmin.getPassword());
			adminInfoRepo.save(admin);

			return "successful";
		} catch (CustomException e) {
			logger.error("Error while creating new admin: ", e);
			return e.getMessage();
		} catch (Exception e) {
			logger.error("Error while creating new admin: ", e);
			return "invalid credentials";
		}
	}

	@Override
	public String login(AdminLogin adminLogin) {
		logger.debug("Inside login with admin info: {}", adminLogin);

		try {
			AdminInfo admin = adminInfoRepo.findByUserName(adminLogin.getUsername());
			// check if user exist
			if (admin == null) {
				throw new CustomException("user not found");
			}
			// validate user with password
			validator.validatePasswords(adminLogin.getPassword(), admin.getPassword());
			
			logger.info("Admin login successful");
			return "successful";
		} catch (CustomException e) {
			logger.error("Error while logging in admin: ", e);
			return e.getMessage();
		} catch (Exception e) {
			logger.error("Error while logging in admin: ", e);
			return "invalid username or password";
		}
	}

	@Override
	public String logout(AdminLogin adminLogin) {
		logger.debug("Inside logout with admin info: {}", adminLogin);

		try {
			AdminInfo admin = adminInfoRepo.findByUserName(adminLogin.getUsername());
			// check if user exist
			if (admin == null) {
				throw new CustomException("user not found");
			}
			logger.info("Admin logout successful");
			return "successful";
		} catch (CustomException e) {
			logger.error("Error while logging in admin: ", e);
			return e.getMessage();
		} catch (Exception e) {
			logger.error("Error while logging in admin: ", e);
			return "unsuccessful";
		}
	}

	private void checkIfAdminAndEmailAlreadyExist(String username, String email) {
		int count = adminInfoRepo.countByUserName(username);
		if (count != 0) {
			throw new CustomException("admin already exist");
		}

		int emailcount = adminInfoRepo.countByEmail(email);
		if (emailcount != 0) {
			throw new CustomException("email already exist");
		}
	}
}
