package com.ty.springboot_trainers_foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_trainers_foodapp.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer> {

}
