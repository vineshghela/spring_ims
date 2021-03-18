package com.qa.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDto {

	private Long id;
	private String firstName;
	private String secondName;
	private String email;

	private CustomerAddressDto customerAddress;
	private List<OrdersDto> orders = new ArrayList<>();
}
