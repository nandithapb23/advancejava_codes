package com.ty.springboot_trainers_foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_trainers_foodapp.dao.ProductDao;
import com.ty.springboot_trainers_foodapp.dto.Product;
import com.ty.springboot_trainers_foodapp.exception.IdNotFound;
import com.ty.springboot_trainers_foodapp.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		structure.setMessage("Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(int id, Product product) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		structure.setMessage("Updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.updateProduct(id, product));
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int id) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Product product = dao.deleteProduct(id);
		if (product != null) {
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Product Id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Product product = dao.getProductById(id);
		if (product != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("Product Id not found");
		}
	}

}
