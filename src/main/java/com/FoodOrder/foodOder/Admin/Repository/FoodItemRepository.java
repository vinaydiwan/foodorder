package com.FoodOrder.foodOder.Admin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FoodOrder.foodOder.Admin.Model.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

	List<FoodItem> findAllByRestaurantId(@Param("restaurantid") Long restaurantid);

}
