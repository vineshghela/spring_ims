package com.qa.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getters, setters , toString , hashcode and equals methods
@NoArgsConstructor
public class OrdersDto {

	private Long id;
	private LocalDate date;
	private double totalPrice;
	private String notes;
	private boolean paid;

	private List<ProductDto> products = new ArrayList<>();
}
