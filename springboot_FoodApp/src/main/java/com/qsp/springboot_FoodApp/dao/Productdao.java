package com.qsp.springboot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_FoodApp.dto.Product;
import com.qsp.springboot_FoodApp.repo.Productrepo;

@Repository
public class Productdao {

	@Autowired
	private Productrepo productrepo;

	@Autowired
	private Menudao menudao;

	public Product saveProduct(Product product) {
		return productrepo.save(product);

	}

	public Product updateProduct(int pid, Product product) {
		Optional<Product> product2 = productrepo.findById(pid);
		if (product2.isPresent()) {
			product.setPid(pid);
			productrepo.save(product);
			return product2.get();
		} else {
			return null;
		}

	}

	public Product deleteproduct(int pid) {
		Optional<Product> product = productrepo.findById(pid);
		if (product.isPresent()) {
			productrepo.deleteById(pid);
			return product.get();

		} else {
			return null;
		}

	}

	public Product getproductbyid(int pid) {
		Optional<Product> product = productrepo.findById(pid);
		if (product.isPresent()) {
			return product.get();
		} else {
			return null;
		}

	}
}
