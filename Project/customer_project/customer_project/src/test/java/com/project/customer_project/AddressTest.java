package com.project.customer_project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.customer.service.AddressService;
import com.customer.serviceimpl.AddressServiceImpl;

public class AddressTest {

	AddressService addressService;

	@org.junit.Before
	public void setUp() throws Exception {
		addressService = new AddressServiceImpl();
	}

	@org.junit.After
	public void tearDown() throws Exception {
		addressService = null;
	}

	@Test
	public void testGetCustomerById() {
		String name = addressService.getAddressById(1).getState();
		assertEquals("Goa", name);
	}
}
