package com.ty.springboot_trainers_foodapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@NotNull(message = "Name can't be null")
//	@NotBlank(message = "Name can't be blank")
	private String name;
	@NotNull(message = "Venue can't be null")
	@NotBlank(message = "Venue can't be blank")
	private String venue;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
