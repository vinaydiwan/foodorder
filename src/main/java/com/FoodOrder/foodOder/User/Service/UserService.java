package com.FoodOrder.foodOder.User.Service;

import com.FoodOrder.foodOder.User.DTOs.NewUser;
import com.FoodOrder.foodOder.User.DTOs.UserLogin;

public interface UserService {

	String signup(NewUser newUser);

	String login(UserLogin userLogin);

	String logout(UserLogin userLogin);

}
