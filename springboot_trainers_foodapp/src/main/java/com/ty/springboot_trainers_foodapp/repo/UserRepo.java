package com.ty.springboot_trainers_foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_trainers_foodapp.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

	@Query("SELECT u FROM User u WHERE u.phone=?1")
	public User userByPhone(long phone);

}
