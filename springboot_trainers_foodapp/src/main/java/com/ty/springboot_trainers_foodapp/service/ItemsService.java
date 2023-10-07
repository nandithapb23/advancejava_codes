package com.ty.springboot_trainers_foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_trainers_foodapp.dao.ItemsDao;
import com.ty.springboot_trainers_foodapp.dto.Items;
import com.ty.springboot_trainers_foodapp.exception.IdNotFound;
import com.ty.springboot_trainers_foodapp.util.ResponseStructure;

@Service
public class ItemsService {

	@Autowired
	private ItemsDao dao;

	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {
		ResponseStructure<Items> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("saved successfully");
		structure.setData(dao.saveItems(items));
		return new ResponseEntity<ResponseStructure<Items>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Items>> updateItems(int id, Items items) {
		ResponseStructure<Items> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("updated successfully");
		structure.setData(dao.updateItems(id, items));
		return new ResponseEntity<ResponseStructure<Items>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Items>> deleteItems(int id) {
		ResponseStructure<Items> structure = new ResponseStructure<>();
		Items items = dao.deleteItems(id);
		if (items != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("deleted successfully");
			structure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Items Id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Items>> getItemsById(int id) {
		ResponseStructure<Items> structure = new ResponseStructure<>();
		Items items = dao.getItemsById(id);
		if (items != null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("found successfully");
			structure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("Items Id not found");
		}
	}

}
