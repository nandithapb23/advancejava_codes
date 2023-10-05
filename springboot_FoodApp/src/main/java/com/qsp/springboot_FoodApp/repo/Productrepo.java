package com.qsp.springboot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_FoodApp.dto.Product;

public interface Productrepo extends JpaRepository<Product, Integer>{

}
