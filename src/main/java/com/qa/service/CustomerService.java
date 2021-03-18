package com.qa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dto.CustomerDto;
import com.qa.persistence.domain.Customer;
import com.qa.persistence.repo.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo repo;

	private ModelMapper mapper;

	private CustomerDto mapToDTO(Customer customer) {
		return this.mapper.map(customer, CustomerDto.class);
	}

	@Autowired
	public CustomerService(CustomerRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public CustomerDto create(Customer customer) {
		return this.mapToDTO(this.repo.save(customer));
	}

	public List<CustomerDto> readllAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public CustomerDto readById(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow());
	}

	public CustomerDto update(CustomerDto customerDto, Long id) {
		return customerDto;
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
