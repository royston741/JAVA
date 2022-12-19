package com.customer.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.customer.entity.Order;
import com.customer.model.OrderDTO;

@Component
public class OrderConverter {

	public Order convertToEntity(OrderDTO OrderDTO) {

		Order order = new Order();
		if (OrderDTO != null) {
			BeanUtils.copyProperties(OrderDTO, order);
		}

		return order;
	}

	// convert Entity(Order) to OrderDTO
	public OrderDTO convertToOrderDTO(Order order) {

		OrderDTO orderDTO = new OrderDTO();
		if (order != null) {
			BeanUtils.copyProperties(order, orderDTO);
		}

		return orderDTO;
	}
}
