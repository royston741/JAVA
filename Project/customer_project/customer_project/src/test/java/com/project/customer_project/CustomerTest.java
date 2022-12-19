package com.project.customer_project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.customer.service.CustomerService;
import com.customer.serviceimpl.CustomerServiceImpl;

public class CustomerTest {

	// customer service reference
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
		// get customer name
		String name = customerService.getCustomerById(1).getCustomerName();
		// compare name
		assertEquals("Sam", name);
	}

}
