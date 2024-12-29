package com.FoodOrder.foodOder.User.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.FoodOrder.foodOder.User.Model.OrderJob;

public interface OrderJobRepository extends JpaRepository<OrderJob, Long>{

	List<OrderJob> findByStatus(@Param("status") String status);

}
