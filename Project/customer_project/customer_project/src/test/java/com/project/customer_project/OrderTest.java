package com.project.customer_project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.customer.service.OrderService;
import com.customer.serviceimpl.OrderServiceImpl;

public class OrderTest {

	OrderService orderService;

	@org.junit.Before
	public void setUp() throws Exception {
		orderService = new OrderServiceImpl();
	}

	@org.junit.After
	public void tearDown() throws Exception {
		orderService = null;
	}

	@Test
	public void testGetCustomerById() {
		String name = orderService.getOrderById(1).getOrderName();
		assertEquals("TV", name);
	}
}
