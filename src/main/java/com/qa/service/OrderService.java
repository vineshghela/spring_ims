package com.qa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dto.OrdersDto;
import com.qa.persistence.domain.Order;
import com.qa.persistence.repo.OrderRepo;

@Service
public class OrderService {

	private OrderRepo repo;

	private ModelMapper mapper;

	private OrdersDto mapToDTO(Order orders) {
		return this.mapper.map(orders, OrdersDto.class);
	}

	@Autowired
	public OrderService(OrderRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public OrdersDto create(Order orders) {
		return this.mapToDTO(this.repo.save(orders));
	}

	public List<OrdersDto> readllAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public OrdersDto readById(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow());
	}

	public OrdersDto update(OrdersDto ordersDto, Long id) {
		return ordersDto;
//		Customer toUpdate = this.repo.findById(id).orElseThrow();
//		toUpdate.setFirstName(CustomerDto.getName());
//		SpringBeanUtil.mergeNotNull(CustomerDto, toUpdate);
//		return this.mapToDTO(this.repo.save(toUpdate));
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);//
		return !this.repo.existsById(id);//
	}

	public void createOrderLine(int orderID, int prodID) {
		this.repo.insertOrder_Line(orderID, prodID);
		System.out.println("Surprise");
	}

}
