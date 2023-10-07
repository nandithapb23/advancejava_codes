package com.ty.springboot_trainers_foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_trainers_foodapp.dto.Items;
import com.ty.springboot_trainers_foodapp.repo.ItemsRepo;

@Repository
public class ItemsDao {

	@Autowired
	private ItemsRepo repo;

	public Items saveItems(Items items) {
		return repo.save(items);
	}

	public Items updateItems(int id, Items items) {
		Items repoItems = repo.findById(id).get();
		if (repoItems != null) {
			items.setId(id);
			return repo.save(items);
		}
		return null;
	}

	public Items deleteItems(int id) {
		if (repo.findById(id).isPresent()) {
			Items items = repo.findById(id).get();
			repo.delete(items);
			return items;
		}
		return null;
	}

	public Items getItemsById(int id) {
		Optional<Items> items = repo.findById(id);
		if (items.isPresent()) {
			return null;
		}
		return items.get();
	}

}
