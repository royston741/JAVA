package com.customer.service;

import java.util.List;

import com.customer.entity.Customer;
import com.customer.model.CustomerDTO;

public interface CustomerService {
	String createCustomer(Customer customer);

	CustomerDTO updateCustomer(int id, Customer customer);

	CustomerDTO getCustomerById(int id);

	List<CustomerDTO> getAllCustomer();

	String deleteCustomerById(int id);

	void deleteAllCustomers();
}
