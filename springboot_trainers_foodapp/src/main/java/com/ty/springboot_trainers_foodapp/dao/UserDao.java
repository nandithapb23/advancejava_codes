package com.ty.springboot_trainers_foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_trainers_foodapp.dto.User;
import com.ty.springboot_trainers_foodapp.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User updateUser(int id, User user) {
		User repoUser = repo.findById(id).get();
		if (repoUser != null) {
			user.setId(id);
			return repo.save(user);
		}
		return null;
	}

	public User deleteUser(int id) {
		if (repo.findById(id).isPresent()) { // To avoid NoSuchElementException
			User user = repo.findById(id).get();
			repo.delete(user);
			return user;
		}
		return null;
	}

	public User getUserById(int id) {
		Optional<User> user = repo.findById(id); // To avoid NoSuchElementException
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	public User getUserByEmail(String email) {
		return repo.findByEmail(email);
	}

	public User getUserByPhone(long phone) {
		return repo.userByPhone(phone);
	}

}
