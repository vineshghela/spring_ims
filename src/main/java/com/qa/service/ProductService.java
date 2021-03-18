package com.qa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dto.ProductDto;
import com.qa.persistence.domain.Product;
import com.qa.persistence.repo.ProductRepo;

@Service
public class ProductService {

	private ProductRepo repo;

	private ModelMapper mapper;

	private ProductDto mapToDTO(Product products) {
		return this.mapper.map(products, ProductDto.class);
	}

	@Autowired
	public ProductService(ProductRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public ProductDto create(Product products) {
		return this.mapToDTO(this.repo.save(products));
	}

	public List<ProductDto> readllAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public ProductDto readById(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow());
	}

	public ProductDto update(ProductDto productDto, Long id) {
		return productDto;
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
