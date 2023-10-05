package com.qsp.springboot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_FoodApp.dto.Menu;

public interface Menurepo extends JpaRepository<Menu, Integer>{

}
