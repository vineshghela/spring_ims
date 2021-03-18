package com.qa.persistence.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	private double totalPrice;
	private String notes;
	private boolean paid;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	@ManyToMany
	@JoinTable(name = "order_line", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> addedProducts;

	public Order(LocalDate date, @NotBlank double totalPrice, String notes, boolean paid) {
		this.date = date;
		this.totalPrice = totalPrice;
		this.notes = notes;
		this.paid = paid;
	}

	public Order(Long id, LocalDate date, @NotBlank double totalPrice, String notes, boolean paid) {
		this.id = id;
		this.date = date;
		this.totalPrice = totalPrice;
		this.notes = notes;
		this.paid = paid;
	}

	public Order(LocalDate date, double totalPrice, String notes, boolean paid, Customer customer) {
		super();
		this.date = date;
		this.totalPrice = totalPrice;
		this.notes = notes;
		this.paid = paid;
		this.customer = customer;
	}

	public Order(Long id, LocalDate date, double totalPrice, String notes, boolean paid, Customer customer) {
		this.id = id;
		this.date = date;
		this.totalPrice = totalPrice;
		this.notes = notes;
		this.paid = paid;
		this.customer = customer;
	}

}
