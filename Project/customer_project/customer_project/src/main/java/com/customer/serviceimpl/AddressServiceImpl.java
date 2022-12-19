package com.customer.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Address;
import com.customer.exception.ResourseNotFoundException;
import com.customer.model.AddressDTO;
import com.customer.repository.AddressRepository;
import com.customer.service.AddressService;
import com.customer.util.AddressConverter;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private AddressConverter addressConverter;

	@Override
	public AddressDTO getAddressById(int id) {
		Address foundAddress = addressRepository.findById(id).orElseThrow(() -> {
			return new ResourseNotFoundException("Address", "ID", id);
		});

		return addressConverter.convertToAddressDTO(foundAddress);
	}

	@Override
	public List<AddressDTO> getAllAddress() {
		List<Address> addresses = addressRepository.findAll();

		List<AddressDTO> allAddressDTOs = new ArrayList<>();

		for (Address addr : addresses) {
			allAddressDTOs.add(addressConverter.convertToAddressDTO(addr));
		}

		return allAddressDTOs;
	}

	@Override
	public AddressDTO updateAddress(int id, Address address) {
		Address foundAddress = addressRepository.findById(id).orElseThrow(() -> {
			return new ResourseNotFoundException("Address", "ID", id);
		});

		foundAddress.setCity(address.getCity());
		foundAddress.setState(address.getState());
		foundAddress.setPincode(address.getPincode());

		addressRepository.save(foundAddress);
		return addressConverter.convertToAddressDTO(foundAddress);
	}

	@Override
	public String deleteAddressById(int id) {

		Optional<Address> address = addressRepository.findById(id);

		if (address.isPresent()) {
			addressRepository.deleteById(id);
			return "------- ADDRESS DELETED SUCCESSFULLY -------";
		}

		return "------- ADDRESS NOT FOUND -------";
	}

	@Override
	public void deleteAllAddress() {
		addressRepository.deleteAll();
	}
}
