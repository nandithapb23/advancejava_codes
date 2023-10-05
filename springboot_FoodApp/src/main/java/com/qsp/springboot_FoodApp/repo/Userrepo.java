package com.qsp.springboot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_FoodApp.dto.User;

public interface Userrepo extends JpaRepository<User, Integer>{

}
