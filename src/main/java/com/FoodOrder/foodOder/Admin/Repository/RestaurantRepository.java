package com.FoodOrder.foodOder.Admin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FoodOrder.foodOder.Admin.Model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	void deleteByRestaurantId(@Param("restaurantId") Long restaurantId);

	Restaurant findByRestaurantId(@Param("restaurantId") Long restaurantId);

	List<Restaurant> findByOwnerId(@Param("ownerId") Long ownerId);

	@Query("SELECT res.restaurantId FROM Restaurant res WHERE res.ownerId = :ownerId")
	List<Long> findRestaurantIdByOwnerId(@Param("ownerId") Long ownerId);

}
