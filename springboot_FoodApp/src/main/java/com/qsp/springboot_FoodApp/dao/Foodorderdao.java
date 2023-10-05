package com.qsp.springboot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_FoodApp.dto.FoodOrder;
import com.qsp.springboot_FoodApp.repo.Foodorderrepo;

@Repository
public class Foodorderdao {

	@Autowired
	private Foodorderrepo foodorderrepo;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodorderrepo.save(foodOrder);

	}

	public FoodOrder updateFoodOrder(int fid, FoodOrder foodOrder) {
		Optional<FoodOrder> foodOrder2 = foodorderrepo.findById(fid);
		if (foodOrder2.isPresent()) {
			foodOrder.setFid(fid);
			foodOrder.setList(foodOrder.getList());
			foodorderrepo.save(foodOrder);
			return foodOrder2.get();
		} else {
			return null;
		}

	}

	public FoodOrder deleteFoodOrder(int fid) {
		Optional<FoodOrder> foodOrder = foodorderrepo.findById(fid);
		if (foodOrder.isPresent()) {
			foodorderrepo.deleteById(fid);
			return foodOrder.get();
		} else {
			return null;
		}

	}

	public FoodOrder getFoodOrderbyid(int fid) {
		Optional<FoodOrder> foodOrder = foodorderrepo.findById(fid);
		if (foodOrder.isPresent()) {
			return foodOrder.get();
		} else {
			return null;
		}

	}

}
