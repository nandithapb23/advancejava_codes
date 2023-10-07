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

import com.ty.springboot_trainers_foodapp.dto.Product;
import com.ty.springboot_trainers_foodapp.service.ProductService;
import com.ty.springboot_trainers_foodapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@ApiOperation(value = "Save Product", notes = "Api used to Save Product")
	@ApiResponses({ @ApiResponse(code = 201, message = "Product Saved Successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@Valid @RequestBody Product product) {
		return service.saveProduct(product);
	}

	@ApiOperation(value = "Update Product", notes = "Api used to Update Product")
	@ApiResponses({ @ApiResponse(code = 200, message = "Product Updated Successfully"),
			@ApiResponse(code = 404, message = "Product with given id not found") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@Valid @RequestParam int id,
			@RequestBody Product product) {
		return service.updateProduct(id, product);
	}

	@ApiOperation(value = "Delete Product", notes = "Api used to Delete Product")
	@ApiResponses({ @ApiResponse(code = 200, message = "Product Deleted Successfully"),
			@ApiResponse(code = 404, message = "Product with given id not found") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@Valid @PathVariable int id) {
		return service.deleteProduct(id);
	}

	@ApiOperation(value = "Get Product By Id", notes = "Api used to Fetch Product based on Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Product Fetched Successfully"),
			@ApiResponse(code = 404, message = "Product with given id not found") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Product>> getProductById(@Valid @RequestParam int id) {
		return service.getProductById(id);
	}

}
