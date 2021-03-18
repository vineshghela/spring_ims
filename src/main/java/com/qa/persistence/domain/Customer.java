package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WeDesignStore 14 Mar 2021
 */

@Data
@NoArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String secondName;
	@NotBlank
	@Email
	private String email;

//	@OneToOne(mappedBy = "customerDetails", fetch = FetchType.EAGER)
//	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private CustomerAddress customerAddress;

	@OneToMany(mappedBy = "customer")
	private List<Order> orders = new ArrayList<>();

	public Customer(@NotBlank String firstName, @NotBlank String secondName, @NotBlank @Email String email) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
	}

	public Customer(Long id, @NotBlank String firstName, @NotBlank String secondName, @NotBlank @Email String email) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
	}
}
