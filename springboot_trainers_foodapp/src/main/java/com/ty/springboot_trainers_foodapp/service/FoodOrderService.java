package com.ty.springboot_trainers_foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_trainers_foodapp.dao.FoodOrderDao;
import com.ty.springboot_trainers_foodapp.dto.FoodOrder;
import com.ty.springboot_trainers_foodapp.dto.Items;
import com.ty.springboot_trainers_foodapp.exception.IdNotFound;
import com.ty.springboot_trainers_foodapp.util.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao dao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		ResponseStructure<FoodOrder> structure = new ResponseStructure<>();
		List<Items> list = foodOrder.getItems();
		double totalPrice = 0;
		for (Items items : list) {
			totalPrice += items.getCost() * items.getQuantity();
		}
		foodOrder.setTotalPrice(totalPrice);
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Saved");
		structure.setData(dao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(int id, FoodOrder foodOrder) {
		ResponseStructure<FoodOrder> structure = new ResponseStructure<>();
		FoodOrder daoFoodOrder = dao.getFoodOrderById(id);
		List<Items> list = daoFoodOrder.getItems();
		double totalPrice = 0;
		for (Items items : list) {
			totalPrice += items.getCost() * items.getQuantity();
		}
		foodOrder.setTotalPrice(totalPrice);
		structure.setMessage("Updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.updateFoodOrder(id, foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
		ResponseStructure<FoodOrder> structure = new ResponseStructure<>();
		FoodOrder foodOrder = dao.deleteFoodOrder(id);
		if (foodOrder != null) {
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("FoodOrder Id not found");
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id) {
		ResponseStructure<FoodOrder> structure = new ResponseStructure<>();
		FoodOrder foodOrder = dao.getFoodOrderById(id);
		if (foodOrder != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("FoodOrder Id not found");
		}
	}

}
