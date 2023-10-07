package com.ty.springboot_trainers_foodapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Name can't be null")
	@NotBlank(message = "Name can't be blank")
	private String name;
	@DecimalMin("1.0")
	@NotNull(message = "Price can't be null")
	private double price;
	private String description;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
