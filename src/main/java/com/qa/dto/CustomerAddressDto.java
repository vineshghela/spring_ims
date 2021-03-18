package com.qa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerAddressDto {

	private Long id;
	private String street;
	private String city;
	private String postcode;
	private String country;
}
