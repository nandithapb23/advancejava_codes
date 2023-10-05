package com.qsp.springboot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_FoodApp.dto.Menu;
import com.qsp.springboot_FoodApp.repo.Menurepo;

@Repository
public class Menudao {

	@Autowired
	private Menurepo menurepo;

	public Menu saveMenu(Menu menu) {
		return menurepo.save(menu);

	}

	public Menu updateMenu(int mid, Menu menu) {
		Optional<Menu> menu2 = menurepo.findById(mid);
		if (menu2.isPresent()) {
			menu.setMid(mid);
			menu.setList(menu.getList());
			menurepo.save(menu);
			return menu2.get();
		} else {
			return null;
		}

	}

	public Menu deleteMenu(int mid) {
		Optional<Menu> menu = menurepo.findById(mid);
		if (menu.isPresent()) {
			menurepo.deleteById(mid);
			return menu.get();
		} else {
			return null;
		}

	}

	public Menu getmenubyid(int mid) {
		Optional<Menu> menu = menurepo.findById(mid);
		if (menu.isPresent()) {
			return menu.get();
		} else {
			return null;
		}

	}
}
