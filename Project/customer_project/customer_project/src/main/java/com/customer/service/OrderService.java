package com.customer.service;

import java.util.List;

import com.customer.entity.Order;
import com.customer.model.OrderDTO;

public interface OrderService {
	String createOrder(Order order, int id);

	OrderDTO getOrderById(int id);

	OrderDTO updateOrder(int id, Order order);

	List<OrderDTO> getAllOrder();

	String deleteOrderById(int id);

	void deleteAllOrders();

	List<OrderDTO> getOrderGreaterThanPrice(double price);

	List<OrderDTO> getOrderLessThanPrice(double price);
}
