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

import com.qa.dto.ProductDto;
import com.qa.persistence.domain.Product;
import com.qa.service.ProductService;

/**
 * @author WeDesignStore 14 Mar 2021
 */

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductsController {

	private ProductService service;

	@Autowired
	public ProductsController(ProductService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<ProductDto> create(@RequestBody Product products) {
		ProductDto created = this.service.create(products);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<ProductDto>> readAll() {
		return ResponseEntity.ok(this.service.readllAll());
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<ProductDto> readOne(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.readById(id));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto ProductDto) {
		return new ResponseEntity<>(this.service.update(ProductDto, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ProductDto> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
