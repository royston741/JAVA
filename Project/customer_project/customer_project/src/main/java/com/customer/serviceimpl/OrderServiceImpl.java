package com.customer.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.entity.Order;
import com.customer.exception.ResourseNotFoundException;
import com.customer.model.OrderDTO;
import com.customer.repository.CustomerRepository;
import com.customer.repository.OrderRepository;
import com.customer.service.OrderService;
import com.customer.util.OrderConverter;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderConverter orderConverter;

	@Override
	public String createOrder(Order order, int id) {
		double price = order.getOrderPrice();
		int quantity = order.getOrderQuantity();
		double totalPrice = price * quantity;
		order.setOrderPrice(totalPrice);

		Customer foundCustomer = customerRepository.findById(id).orElseThrow(() -> {
			return new ResourseNotFoundException("Customer", "ID", id);
		});

		List<Order> allOrders = foundCustomer.getOrder();
		allOrders.add(order);
		foundCustomer.setOrder(allOrders);

		order.setCustomer(foundCustomer);
//		orderRepository.save(order);
		customerRepository.save(foundCustomer);

		if (order != null) {
			return "------- ORDER SAVED -------";
		}
		return "-------- SOMETHING WENT WROG! ORDEERED NOT SAVED -------";
	}

	@Override
	public OrderDTO getOrderById(int id) {
		Order foundOrder = orderRepository.findById(id).orElseThrow(() -> {
			return new ResourseNotFoundException("Order", "ID", id);
		});
		return orderConverter.convertToOrderDTO(foundOrder);
	}

	@Override
	public List<OrderDTO> getAllOrder() {

		List<Order> allOrderList = orderRepository.findAll();

		List<OrderDTO> allOrderDTOs = new ArrayList<>();

		for (Order order : allOrderList) {
			allOrderDTOs.add(orderConverter.convertToOrderDTO(order));
		}

		return allOrderDTOs;
	}

	@Override
	public List<OrderDTO> getOrderGreaterThanPrice(double price) {
		List<Order> allOrderList = orderRepository.findGreaterPrice(price);

		List<OrderDTO> allOrderDTOs = new ArrayList<>();

		for (Order order : allOrderList) {
			allOrderDTOs.add(orderConverter.convertToOrderDTO(order));
		}

		return allOrderDTOs;
	}

	@Override
	public List<OrderDTO> getOrderLessThanPrice(double price) {
		List<Order> allOrderList = orderRepository.findLessPrice(price);

		List<OrderDTO> allOrderDTOs = new ArrayList<>();

		for (Order order : allOrderList) {
			allOrderDTOs.add(orderConverter.convertToOrderDTO(order));
		}

		return allOrderDTOs;
	}

	@Override
	public OrderDTO updateOrder(int id, Order order) {
		Order foundOrder = orderRepository.findById(id).orElseThrow(() -> {
			return new ResourseNotFoundException("Order", "ID", id);
		});

		double price = order.getOrderPrice();
		int quantity = order.getOrderQuantity();
		double totalPrice = price * quantity;
		order.setOrderPrice(totalPrice);

		foundOrder.setOrderName(order.getOrderName());
		foundOrder.setOrderPrice(order.getOrderPrice());
		foundOrder.setOrderQuantity(order.getOrderQuantity());

		orderRepository.save(foundOrder);
		return orderConverter.convertToOrderDTO(foundOrder);

	}

	@Override
	public String deleteOrderById(int id) {

		Optional<Order> order = orderRepository.findById(id);

		if (order.isPresent()) {
			orderRepository.deleteById(id);
			return "------- ORDER DELETED SUCCESSFULLY -------";
		}

		return "------- ORDER NOT FOUND -------";
	}

	@Override
	public void deleteAllOrders() {
		orderRepository.deleteAll();
	}

}
