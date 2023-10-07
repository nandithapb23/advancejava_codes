package com.ty.springboot_trainers_foodapp.controller;

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

import com.ty.springboot_trainers_foodapp.dto.FoodOrder;
import com.ty.springboot_trainers_foodapp.service.FoodOrderService;
import com.ty.springboot_trainers_foodapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/order")
public class FoodOrderController {

	@Autowired
	private FoodOrderService service;

	@ApiOperation(value = "Save FoodOrder", notes = "Api used to Save FoodOrder")
	@ApiResponses({ @ApiResponse(code = 201, message = "FoodOrder Saved Successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return service.saveFoodOrder(foodOrder);
	}

	@ApiOperation(value = "Update FoodOrder", notes = "Api used to Update FoodOrder")
	@ApiResponses({ @ApiResponse(code = 200, message = "FoodOrder Updated Successfully"),
			@ApiResponse(code = 404, message = "FoodOrder with given id not found") })
	@PutMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestParam int id,
			@RequestBody FoodOrder foodOrder) {
		return service.updateFoodOrder(id, foodOrder);
	}

	@ApiOperation(value = "Delete FoodOrder", notes = "Api used to Delete FoodOrder")
	@ApiResponses({ @ApiResponse(code = 200, message = "FoodOrder Deleted Successfully"),
			@ApiResponse(code = 404, message = "FoodOrder with given id not found") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@RequestParam int id) {
		return service.deleteFoodOrder(id);
	}

	@ApiOperation(value = "Get FoodOrder By Id", notes = "Api used to Fetch FoodOrder based on Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "FoodOrder Fetched Successfully"),
			@ApiResponse(code = 404, message = "FoodOrder with given id not found") })
	@GetMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@RequestParam int id) {
		return service.getFoodOrderById(id);
	}

}
