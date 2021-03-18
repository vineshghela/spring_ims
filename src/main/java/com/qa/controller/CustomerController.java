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

import com.qa.dto.CustomerDto;
import com.qa.persistence.domain.Customer;
import com.qa.service.CustomerService;

/**
 * @author WeDesignStore 14 Mar 2021
 */

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<CustomerDto> create(@RequestBody Customer customer) {
		CustomerDto created = this.service.create(customer);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<CustomerDto>> readAll() {
		return ResponseEntity.ok(this.service.readllAll());
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<CustomerDto> readOne(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.readById(id));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerDto> update(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
		return new ResponseEntity<>(this.service.update(customerDto, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CustomerDto> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
