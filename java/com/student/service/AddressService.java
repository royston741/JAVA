package com.student.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.student.entity.Address;
import com.student.model.AddressDTO;

public interface AddressService {

	String createAddress(Address address);
	
	List<AddressDTO> getAllAddressWithSort(String field);
	
	Page<Address> findAddressWithPagination(int offset, int pageSize);
	
	Page<Address> findAddressWithPaginationWithSort(int offset, int pageSize,String field);
}
