package com.qsp.springboot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_FoodApp.dto.Items;
import com.qsp.springboot_FoodApp.repo.Itemsrepo;

@Repository
public class Itemdao {

	@Autowired
	private Itemsrepo itemsrepo;

	public Items saveItems(Items items) {
		return itemsrepo.save(items);

	}

	public Items updateItems(int iid, Items items) {
		Optional<Items> items2 = itemsrepo.findById(iid);
		if (items2.isPresent()) {
			items.setItemid(iid);
			itemsrepo.save(items);
			return items2.get();
		} else {
			return null;
		}

	}

	public Items deleteItems(int iid) {
		Optional<Items> items = itemsrepo.findById(iid);
		if (items.isPresent()) {
			itemsrepo.deleteById(iid);
			return items.get();
		} else {
			return null;
		}

	}

	public Items getItemsbyid(int iid) {
		Optional<Items> items = itemsrepo.findById(iid);
		if (items.isPresent()) {
			return items.get();
		} else {
			return null;
		}

	}
}
