package com.ty.springboot_trainers_foodapp.controller;

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

import com.ty.springboot_trainers_foodapp.dto.Menu;
import com.ty.springboot_trainers_foodapp.service.MenuService;
import com.ty.springboot_trainers_foodapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService service;

	@ApiOperation(value = "Save Menu", notes = "Api used to Save Menu")
	@ApiResponses({ @ApiResponse(code = 201, message = "Menu Saved Successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
		return service.saveMenu(menu);
	}

	@ApiOperation(value = "Update Menu", notes = "Api used to Update Menu")
	@ApiResponses({ @ApiResponse(code = 200, message = "Menu Updated Successfully"),
			@ApiResponse(code = 404, message = "Menu with given id not found") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestParam int id, @RequestBody Menu menu) {
		return service.updateMenu(id, menu);
	}

	@ApiOperation(value = "Delete Menu", notes = "Api used to Delete Menu")
	@ApiResponses({ @ApiResponse(code = 200, message = "Menu Deleted Successfully"),
			@ApiResponse(code = 404, message = "Menu with given id not found") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@PathVariable int id) {
		return service.deleteMenu(id);
	}

	@ApiOperation(value = "Get Menu By Id", notes = "Api used to Fetch Menu based on Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Menu Fetched Successfully"),
			@ApiResponse(code = 404, message = "Menu with given id not found") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@RequestParam int id) {
		return service.getMenuById(id);
	}

}
