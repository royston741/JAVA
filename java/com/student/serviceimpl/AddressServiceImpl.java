package com.student.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.student.entity.Address;
import com.student.model.AddressDTO;
import com.student.repository.AddressRepository;
import com.student.service.AddressService;
import com.student.util.AddressConverter;

@Service
public class AddressServiceImpl implements AddressService{

	private static final Logger l = LoggerFactory.getLogger(Address.class);
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	AddressConverter addressConverter;
	
	@Override
	public String createAddress(Address address) {
		
		String message=null;
		addressRepository.save(address);
		if(address!=null)
		{
			message="New address saved successfully!!";
		}
		else
		{
			message="Address was not saved!!";
		}
		l.info("Address "+address.toString()+" added at"+ new Date());
		return message;
	}

	@Override
	public List<AddressDTO> getAllAddressWithSort(String field) {
		List<Address> address = addressRepository.findAll(Sort.by(Sort.Direction.DESC, field));
		List<AddressDTO> aDTO = new ArrayList<>();
		for(Address a: address)
		{
			aDTO.add(addressConverter.convertToAddressDTO(a));
		}
		return aDTO;
	}

	@Override
	public Page<Address> findAddressWithPagination(int offset, int pageSize) {
		Page<Address> address =addressRepository.findAll(PageRequest.of(offset, pageSize));
		return address;
	}

	@Override
	public Page<Address> findAddressWithPaginationWithSort(int offset, int pageSize, String field) {
		Page<Address> address =addressRepository.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return address;
	}
	

}
