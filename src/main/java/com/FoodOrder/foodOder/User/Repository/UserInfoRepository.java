package com.FoodOrder.foodOder.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FoodOrder.foodOder.User.Model.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	int countByUserName(@Param("username") String username);

	int countByEmail(@Param("email") String email);

	UserInfo findByUserName(@Param("username") String username);

}
