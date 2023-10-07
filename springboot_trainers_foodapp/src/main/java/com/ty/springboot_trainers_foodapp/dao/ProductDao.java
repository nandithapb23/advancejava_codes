package com.ty.springboot_trainers_foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_trainers_foodapp.dto.Product;
import com.ty.springboot_trainers_foodapp.repo.ProductRepo;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepo repo;

	public Product saveProduct(Product product) {
		return repo.save(product);
	}

	public Product updateProduct(int id, Product product) {
		Product repoProduct = repo.findById(id).get();
		if (repoProduct != null) {
			product.setId(id);
			return repo.save(product);
		}
		return null;
	}

	public Product deleteProduct(int id) {
		if (repo.findById(id).isPresent()) {
			Product product = repo.findById(id).get();
			repo.deleteById(id);
			return product;
		}
		return null;
	}

	public Product getProductById(int id) {
		Optional<Product> product = repo.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}

}
