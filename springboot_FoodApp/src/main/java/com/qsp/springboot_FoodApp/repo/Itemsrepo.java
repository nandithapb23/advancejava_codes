package com.qsp.springboot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_FoodApp.dto.Items;

public interface Itemsrepo extends JpaRepository<Items, Integer>{

}
