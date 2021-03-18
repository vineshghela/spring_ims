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

import com.qa.dto.CustomerAddressDto;
import com.qa.persistence.domain.CustomerAddress;
import com.qa.service.CustomerAddressService;

/**
 * @author WeDesignStore 14 Mar 2021
 */

@RestController
@CrossOrigin
@RequestMapping("/customerAddress")
public class CustomerAddressController {

	private CustomerAddressService service;

	@Autowired
	public CustomerAddressController(CustomerAddressService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<CustomerAddressDto> create(@RequestBody CustomerAddress customerAddress) {
		CustomerAddressDto created = this.service.create(customerAddress);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<CustomerAddressDto>> readAll() {
		return ResponseEntity.ok(this.service.readllAll());
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<CustomerAddressDto> readOne(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.readById(id));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerAddressDto> update(@PathVariable Long id,
			@RequestBody CustomerAddressDto customerAddressDto) {
		return new ResponseEntity<>(this.service.update(customerAddressDto, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CustomerAddressDto> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
