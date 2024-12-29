package com.FoodOrder.foodOder.Admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FoodOrder.foodOder.Admin.Model.AdminInfo;

@Repository
public interface AdminInfoRepository extends JpaRepository<AdminInfo, Long> {

	AdminInfo findByUserName(@Param("userName") String userName);

	int countByUserName(@Param("userName") String userName);

	int countByEmail(@Param("email") String email);

}
