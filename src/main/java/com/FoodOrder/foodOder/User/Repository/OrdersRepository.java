package com.FoodOrder.foodOder.User.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FoodOrder.foodOder.User.Model.Orders;

import jakarta.transaction.Transactional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

	@Query("SELECT or FROM Orders or WHERE or.restaurantId in :restaurantIds ORDER BY or.orderId DESC")
	List<Orders> findAllByRestaurantIdInOrderByOrderIdDesc(List<Long> restaurantIds);

	List<Orders> findAllByUserId(@Param("userId") Long userId);

	Orders findByOrderId(@Param("orderId") Long orderId);

	@Modifying
	@Transactional
	@Query("UPDATE Orders o SET o.status = :status WHERE o.orderId = :orderId")
	void updateStatusByOrderId(@Param("orderId") Long orderId, @Param("status") String status);

}
