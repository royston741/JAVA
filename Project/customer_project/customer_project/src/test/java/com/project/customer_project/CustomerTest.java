package com.project.customer_project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.customer.service.CustomerService;
import com.customer.serviceimpl.CustomerServiceImpl;

public class CustomerTest {

	CustomerService customerService;

	@org.junit.Before
	public void setUp() throws Exception {
		customerService = new CustomerServiceImpl();
	}

	@org.junit.After
	public void tearDown() throws Exception {
		customerService = null;
	}

	@Test
	public void testGetCustomerById() {
		String name = customerService.getCustomerById(1).getCustomerName();
		assertEquals("Sam", name);
	}

}
