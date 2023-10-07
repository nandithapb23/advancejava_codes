package com.ty.springboot_trainers_foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_trainers_foodapp.dao.MenuDao;
import com.ty.springboot_trainers_foodapp.dto.Menu;
import com.ty.springboot_trainers_foodapp.exception.IdNotFound;
import com.ty.springboot_trainers_foodapp.util.ResponseStructure;

@Service
public class MenuService {

	@Autowired
	private MenuDao dao;

	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		ResponseStructure<Menu> structure = new ResponseStructure<>();
		structure.setMessage("Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(int id, Menu menu) {
		ResponseStructure<Menu> structure = new ResponseStructure<>();
		structure.setMessage("Updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.updateMenu(id, menu));
		return new ResponseEntity<ResponseStructure<Menu>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int id) {
		ResponseStructure<Menu> structure = new ResponseStructure<>();
		Menu menu = dao.deleteMenu(id);
		if (menu != null) {
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Menu Id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id) {
		ResponseStructure<Menu> structure = new ResponseStructure<>();
		Menu menu = dao.getMenuById(id);
		if (menu != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("Menu Id not found");
		}
	}

}
