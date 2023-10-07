package com.ty.springboot_trainers_foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_trainers_foodapp.dto.Menu;
import com.ty.springboot_trainers_foodapp.repo.MenuRepo;

@Repository
public class MenuDao {

	@Autowired
	private MenuRepo repo;

	public Menu saveMenu(Menu menu) {
		return repo.save(menu);
	}

	public Menu updateMenu(int id, Menu menu) {
		Menu repoMenu = repo.findById(id).get();
		if (repoMenu != null) {
			menu.setId(id);
			menu.setProducts(repoMenu.getProducts());
			return repo.save(menu);
		}
		return null;
	}

	public Menu deleteMenu(int id) {
		if (repo.findById(id).isPresent()) {
			Menu menu = repo.findById(id).get();
			repo.delete(menu);
			return menu;
		}
		return null;
	}

	public Menu getMenuById(int id) {
		Optional<Menu> menu = repo.findById(id);
		if (menu.isPresent()) {
			return null;
		}
		return menu.get();
	}

}
