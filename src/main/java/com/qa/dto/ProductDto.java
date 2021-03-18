package com.qa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

	private Long id;
	private String productName;
	private String productDescription;
	private String productCategory;
	private double price;
	private int stock;

}
