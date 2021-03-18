package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "address")
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@NotBlank
	private String street;
	@NotBlank
	private String city;
	@NotBlank
	private String postcode;
	@NotBlank
	private String country;

	@OneToOne(mappedBy = "customerAddress")
	private Customer customerDetails = null;

	public CustomerAddress(String street, String city, String postcode, String country) {

		this.street = street;
		this.city = city;
		this.postcode = postcode;
		this.country = country;
	}

	public CustomerAddress(Long id, String street, String city, String postcode, String country) {
		this.id = id;
		this.street = street;
		this.city = city;
		this.postcode = postcode;
		this.country = country;
	}
}
