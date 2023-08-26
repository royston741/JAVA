package com.student.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Address;
import com.student.model.AddressDTO;
import com.student.service.AddressService;
import com.student.util.AddressConverter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "")
public class AddressController {

	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AddressConverter addressConverter;
	
	@PostMapping("/createAddress")
	public String createAddress(@Valid @RequestBody AddressDTO addressDTO)
	{
		final Address address= addressConverter.convertToAddressEntity(addressDTO);
		return addressService.createAddress(address);
	}
	
	@GetMapping("/getAllAddressWithSort/{field}")
	public List<AddressDTO> getAllAddressWithSort(@PathVariable String field)
	{
		return addressService.getAllAddressWithSort(field);
	}
	
	@GetMapping("/findAddressWithPagination/{offset}/{pageSize}")
	public Page<Address> findAddressWithPagination(@PathVariable("offset") int offset,
			@PathVariable("pageSize") int pageSize)
	{
		return addressService.findAddressWithPagination(offset, pageSize);
	}
	
	
	@GetMapping("/findAddressWithPagination/{offset}/{pageSize}/{field}")
	public Page<Address> findAddressWithPaginationWithSort(@PathVariable("offset") int offset,
			@PathVariable("pageSize") int pageSize,@PathVariable("field") String field)
	{
		return addressService.findAddressWithPaginationWithSort(offset, pageSize, field);
	}
}
