package com.customer.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.customer.entity.Address;
import com.customer.model.AddressDTO;

@Component
public class AddressConverter {
	public Address convertToAddressEntity(AddressDTO addressDTO) {

		Address address = new Address();
		if (addressDTO != null) {
			BeanUtils.copyProperties(addressDTO, address);
		}

		return address;
	}

	// convert Entity to DTO
	public AddressDTO convertToAddressDTO(Address address) {

		AddressDTO addressDTO = new AddressDTO();
		if (address != null) {
			BeanUtils.copyProperties(address, addressDTO);
		}

		return addressDTO;
	}
}
