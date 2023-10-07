package com.ty.springboot_trainers_foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_trainers_foodapp.dto.FoodOrder;
import com.ty.springboot_trainers_foodapp.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepo repo;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return repo.save(foodOrder);
	}

	public FoodOrder updateFoodOrder(int id, FoodOrder foodOrder) {
		FoodOrder repoFoodOrder = repo.findById(id).get();
		if (repoFoodOrder != null) {
			foodOrder.setId(id);
			foodOrder.setItems(repoFoodOrder.getItems());
			return repo.save(foodOrder);
		}
		return null;
	}

	public FoodOrder deleteFoodOrder(int id) {
		if(repo.findById(id).isPresent()) {
			FoodOrder foodOrder = repo.findById(id).get();
			repo.delete(foodOrder);
			return foodOrder;
		}
		return null;
	}

	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> foodOrder = repo.findById(id);
		if (foodOrder.isPresent()) {
			return foodOrder.get();
		}
		return null;
	}

}
