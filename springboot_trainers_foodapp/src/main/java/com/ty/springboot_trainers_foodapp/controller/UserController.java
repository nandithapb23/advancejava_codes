package com.ty.springboot_trainers_foodapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_trainers_foodapp.dto.User;
import com.ty.springboot_trainers_foodapp.service.UserService;
import com.ty.springboot_trainers_foodapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@ApiOperation(value = "Save User", notes = "Api used to Save User")
	@ApiResponses({ @ApiResponse(code = 201, message = "User Saved Successfully"),
			@ApiResponse(code = 400, message = "Name and Address can't be null or blank") })
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@Valid @RequestBody User user) {
		return service.saveUser(user);
	}

	@ApiOperation(value = "Update User", notes = "Api used to Update User")
	@ApiResponses({ @ApiResponse(code = 200, message = "User Updated Successfully"),
			@ApiResponse(code = 400, message = "Name and Address can't be null or blank") })
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@Valid @RequestParam int id, @RequestBody User user) {
		return service.updateUser(id, user);
	}

	@ApiOperation(value = "Delete User", notes = "Api used to Delete User")
	@ApiResponses({ @ApiResponse(code = 200, message = "User Deleted Successfully"),
			@ApiResponse(code = 404, message = "User with the given id not available") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@Valid @PathVariable int id) {
		return service.deleteUser(id);
	}

	@ApiOperation(value = "Get User By Id", notes = "Api used to Fetch User based on Id")
	@ApiResponses({ @ApiResponse(code = 302, message = "User Found Successfully"),
			@ApiResponse(code = 404, message = "User with the given id not available") })
	@GetMapping
	public ResponseEntity<ResponseStructure<User>> getUserById(@Valid @RequestParam int id) {
		return service.getUserById(id);
	}

	@ApiOperation(value = "Get User By Email", notes = "Api used to Fetch User based on Email")
	@ApiResponses({ @ApiResponse(code = 200, message = "User Found Successfully"),
			@ApiResponse(code = 404, message = "User with the given email not available") })
	@GetMapping("/{email}")
	public ResponseEntity<ResponseStructure<User>> getUserByEmail(@Valid @PathVariable String email) {
		return service.getUserByEmail(email);
	}

	@ApiOperation(value = "Get User By Phone", notes = "Api used to Fetch User based on Phone")
	@ApiResponses({ @ApiResponse(code = 200, message = "User Found Successfully"),
			@ApiResponse(code = 404, message = "User with the given phone not available") })
	@GetMapping("/phone")
	public ResponseEntity<ResponseStructure<User>> getUserByPhone(@Valid @RequestParam long phone) {
		return service.getUserByPhone(phone);
	}

}
