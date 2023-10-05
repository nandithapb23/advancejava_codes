package com.qsp.springboot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_FoodApp.dto.FoodOrder;

public interface Foodorderrepo extends JpaRepository<FoodOrder, Integer>{

}
