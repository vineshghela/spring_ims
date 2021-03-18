package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String productName;
	@NotBlank
	private String productDescription;
	@NotBlank
	private String productCategory;
	private double price;
	private int stock;

	@ManyToMany(mappedBy = "addedProducts", targetEntity = Order.class)
	private List<Order> orders;

	public Product(@NotBlank String productName, @NotBlank String productDescription, @NotBlank String productCategory,
			double price, int stock) {

		this.productName = productName;
		this.productDescription = productDescription;
		this.productCategory = productCategory;
		this.price = price;
		this.stock = stock;
	}

	public Product(Long id, @NotBlank String productName, @NotBlank String productDescription,
			@NotBlank String productCategory, double price, int stock) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.productCategory = productCategory;
		this.price = price;
		this.stock = stock;
	}

}
