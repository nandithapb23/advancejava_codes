package com.ty.springboot_trainers_foodapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity // Lombok is not working so generate getters & setters explicitly(for lambok use
		// @Data/@Setter/@Getter)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Name can't be null")
	@NotBlank(message = "Name can't be blank")
	private String name;
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email")
	@NotBlank(message = "Email can't be blank")
	@NotNull(message = "Email can't be null")
	private String email;
	@Pattern(regexp = "^(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\S+$).{6,}$", message = "min 6 characters mandatory(1 upperCase,1 lowerCase,1 special Character,1 number)")
	private String password;
	@NotBlank(message = "Role can't be blank")
	@NotNull(message = "Role can't be null")
	private String role;
	@NotBlank(message = "Address can't be blank")
	@NotNull(message = "Address can't be null")
	private String address;
	@NotBlank(message = "Phone can't be blank")
	@NotNull(message = "Phone can't be null")
	@Pattern(regexp = "[6-9][0-9]{9}", message = "Invalid Phone")
	private String phone;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
