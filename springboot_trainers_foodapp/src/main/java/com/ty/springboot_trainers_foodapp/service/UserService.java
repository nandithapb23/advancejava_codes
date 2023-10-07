package com.ty.springboot_trainers_foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_trainers_foodapp.dao.UserDao;
import com.ty.springboot_trainers_foodapp.dto.User;
import com.ty.springboot_trainers_foodapp.exception.IdNotFound;
import com.ty.springboot_trainers_foodapp.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("Updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.updateUser(id, user));
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		User user = dao.deleteUser(id);
		if (user != null) {
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("User Id not found");
		}
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		User user = dao.getUserById(id);
		if (user != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("User Id not found");
		}
	}

	public ResponseEntity<ResponseStructure<User>> getUserByEmail(String email) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("Found based on Email");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(dao.getUserByEmail(email));
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<User>> getUserByPhone(long phone) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("Found based on Phone");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(dao.getUserByPhone(phone));
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
	}

}
