package com.FoodOrder.foodOder.User.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FoodOrder.foodOder.User.Model.UserCart;

import jakarta.transaction.Transactional;

@Repository
public interface UserCartRepository extends JpaRepository<UserCart, Long> {

	Optional<UserCart> findFirstByUserId(@Param("userId") Long userId);

	@Transactional
	void deleteAllByUserId(@Param("userId") Long userId);

	Optional<UserCart> findByUserIdAndItemId(@Param("userId") Long userId, @Param("itemId") Long itemId);

	@Transactional
	void deleteByUserIdAndItemId(@Param("userId") Long userId, @Param("itemId") Long itemId);

	List<UserCart> findAllByUserId(@Param("userId") Long userId);

	@Query("SELECT COUNT(cart) AS totalItems FROM UserCart cart WHERE cart.userId = :userId")
	Integer getTotalItemsByUserId(Long userId);
	
	@Query("SELECT SUM(cart.quantity) AS totalQuantity FROM UserCart cart WHERE cart.userId = :userId")
	Integer getTotalQuantityByUserId(Long userId);

	@Query("SELECT SUM(cart.quantity * cart.price) AS totalPrice FROM UserCart cart WHERE cart.userId = :userId")
	double getTotalPriceByUserId(Long userId);

}
