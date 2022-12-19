package com.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.customer.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query("from Order where orderPrice >:s")
	List<Order> findGreaterPrice(@Param("s") double price);

	@Query("from Order where orderPrice <:s")
	List<Order> findLessPrice(@Param("s") double price);
}
