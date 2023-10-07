package com.ty.springboot_trainers_foodapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_trainers_foodapp.dto.Items;
import com.ty.springboot_trainers_foodapp.service.ItemsService;
import com.ty.springboot_trainers_foodapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService service;

	@ApiOperation(value = "Save Items", notes = "Api used to Save Items")
	@ApiResponses({ @ApiResponse(code = 201, message = "Items Saved Successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Items>> saveItems(@Valid @RequestBody Items items) {
		return service.saveItems(items);
	}

	@ApiOperation(value = "Update Items", notes = "Api used to Update Items")
	@ApiResponses({ @ApiResponse(code = 200, message = "Items Updated Successfully"),
			@ApiResponse(code = 404, message = "Items with given id not found") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Items>> updateItems(@Valid @RequestParam int id, @RequestBody Items items) {
		return service.updateItems(id, items);
	}

	@ApiOperation(value = "Delete Items", notes = "Api used to Delete Items")
	@ApiResponses({ @ApiResponse(code = 200, message = "Items Deleted Successfully"),
			@ApiResponse(code = 404, message = "Items with given id not found") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Items>> deleteItems(@Valid @RequestParam int id) {
		return service.deleteItems(id);
	}

	@ApiOperation(value = "Get Items By Id", notes = "Api used to Fetch Items based on Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Items Fetched Successfully"),
			@ApiResponse(code = 404, message = "Items with given id not found") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Items>> getItemsById(@Valid @RequestParam int id) {
		return service.getItemsById(id);
	}

}
