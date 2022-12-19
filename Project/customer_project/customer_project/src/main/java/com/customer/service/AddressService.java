package com.customer.service;

import java.util.List;

import com.customer.entity.Address;
import com.customer.model.AddressDTO;

public interface AddressService {

	AddressDTO getAddressById(int id);

	List<AddressDTO> getAllAddress();

	AddressDTO updateAddress(int id, Address address);

	String deleteAddressById(int id);

	void deleteAllAddress();

}
