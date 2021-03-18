package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dto.OrdersDto;
import com.qa.persistence.domain.Order;
import com.qa.service.OrderService;

/**
 * @author WeDesignStore 14 Mar 2021
 */

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {

	private OrderService service;

	@Autowired
	public OrderController(OrderService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<OrdersDto> create(@RequestBody Order orders) {
		OrdersDto created = this.service.create(orders);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<OrdersDto>> readAll() {
		return ResponseEntity.ok(this.service.readllAll());
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<OrdersDto> readOne(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.readById(id));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<OrdersDto> update(@PathVariable Long id, @RequestBody OrdersDto ordersDto) {
		return new ResponseEntity<>(this.service.update(ordersDto, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<OrdersDto> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/orderLine/{orderID}/product/{productID}")
	public void findByName(@PathVariable("orderID") int orderID, @PathVariable("productID") int productID) {
		this.service.createOrderLine(orderID, productID);

	}

}
