package com.ty.springboot_trainers_foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_trainers_foodapp.dto.Items;

public interface ItemsRepo extends JpaRepository<Items, Integer> {

}
