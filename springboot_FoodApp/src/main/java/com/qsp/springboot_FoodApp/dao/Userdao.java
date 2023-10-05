package com.qsp.springboot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_FoodApp.dto.User;
import com.qsp.springboot_FoodApp.repo.Userrepo;

@Repository
public class Userdao {

	@Autowired
	private Userrepo userrepo;

	public User saveUser(User user) {
		return userrepo.save(user);

	}

	public User updateUser(int id, User user) {
		Optional<User> user2 = userrepo.findById(id);
		if (user2.isPresent()) {
			user.setId(id);
			userrepo.save(user);
			return user2.get();
		} else {
			return null;
		}

	}

	public User deleteUser(int id) {
		Optional<User> user = userrepo.findById(id);
		if (user.isPresent()) {
			userrepo.deleteById(id);
			return user.get();
		} else {
			return null;
		}

	}

	public User getuserbyid(int id) {
		Optional<User> user = userrepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}

	}
}
