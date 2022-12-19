package com.customer.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.customer.entity.Customer;
import com.customer.model.CustomerDTO;

@Component
public class CustomerConverter {

	public Customer convertToEntity(CustomerDTO CustomerDTO) {

		Customer customer = new Customer();
		if (CustomerDTO != null) {
			BeanUtils.copyProperties(CustomerDTO, customer);
		}

		return customer;
	}

	public CustomerDTO convertToCustomerDTO(Customer customer) {

		CustomerDTO customerDTO = new CustomerDTO();
		if (customer != null) {
			BeanUtils.copyProperties(customer, customerDTO);
		}

		return customerDTO;
	}
}
