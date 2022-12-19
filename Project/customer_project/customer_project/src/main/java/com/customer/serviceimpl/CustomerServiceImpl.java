package com.customer.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.exception.ResourseNotFoundException;
import com.customer.model.CustomerDTO;
import com.customer.repository.AddressRepository;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import com.customer.util.CustomerConverter;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addresRepository;

	@Autowired
	private CustomerConverter customerConverter;

	@Override
	public String createCustomer(Customer customer) {
		addresRepository.save(customer.getAddress());
		customerRepository.save(customer);
		if (customer != null) {
			return "---------- CUSTOMER CREATED SUCCESSFULLY ----------";
		}
		return "SOMETHING WENT WRONG! CUSTOMER NOT CREATED";
	}

	@Override
	public CustomerDTO getCustomerById(int id) {
		Customer foundCustomer = customerRepository.findById(id).orElseThrow(() -> {
			return new ResourseNotFoundException("Customer", "ID", id);
		});
		return customerConverter.convertToCustomerDTO(foundCustomer);
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {

		List<Customer> allCustomerList = customerRepository.findAll();

		List<CustomerDTO> allCustomerDTOs = new ArrayList<>();

		for (Customer customer : allCustomerList) {
			allCustomerDTOs.add(customerConverter.convertToCustomerDTO(customer));
		}

		return allCustomerDTOs;
	}

	@Override
	public CustomerDTO updateCustomer(int id, Customer customer) {

		Customer foundCustomer = customerRepository.findById(id).orElseThrow(() -> {
			return new ResourseNotFoundException("Customer", "ID", id);
		});

		foundCustomer.setCustomerName(customer.getCustomerName());
		foundCustomer.setPhone(customer.getPhone());
		foundCustomer.setEmail(customer.getEmail());

		customerRepository.save(foundCustomer);
		return customerConverter.convertToCustomerDTO(foundCustomer);

	}

	@Override
	public String deleteCustomerById(int id) {

		Optional<Customer> customer = customerRepository.findById(id);

		if (customer.isPresent()) {
			customerRepository.deleteById(id);
			return "---------- CUSTOMER DELETED SUCCESSFULLY ----------";
		}

		return "---------- CUSTOMER NOT FOUND ----------";
	}

	@Override
	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}

}
