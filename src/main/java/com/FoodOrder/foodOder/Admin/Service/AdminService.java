package com.FoodOrder.foodOder.Admin.Service;

import com.FoodOrder.foodOder.Admin.DTOs.AdminLogin;
import com.FoodOrder.foodOder.Admin.DTOs.NewAdmin;

public interface AdminService {
	public String signup(NewAdmin newAdmin);

	public String login(AdminLogin adminLogin);
	
	public String logout(AdminLogin adminLogin);
}
