package com.qa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dto.CustomerAddressDto;
import com.qa.persistence.domain.CustomerAddress;
import com.qa.persistence.repo.CustomerAddessRepo;

@Service
public class CustomerAddressService {

	private CustomerAddessRepo repo;

	private ModelMapper mapper;

	private CustomerAddressDto mapToDTO(CustomerAddress customerAddress) {
		return this.mapper.map(customerAddress, CustomerAddressDto.class);
	}

	@Autowired
	public CustomerAddressService(CustomerAddessRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public CustomerAddressDto create(CustomerAddress customerAddress) {
		return this.mapToDTO(this.repo.save(customerAddress));
	}

	public List<CustomerAddressDto> readllAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public CustomerAddressDto readById(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow());
	}

	public CustomerAddressDto update(CustomerAddressDto customerAddressDto, Long id) {
		return customerAddressDto;
//		Customer toUpdate = this.repo.findById(id).orElseThrow();
//		toUpdate.setFirstName(CustomerDto.getName());
//		SpringBeanUtil.mergeNotNull(CustomerDto, toUpdate);
//		return this.mapToDTO(this.repo.save(toUpdate));
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);//
		return !this.repo.existsById(id);//
	}

}
