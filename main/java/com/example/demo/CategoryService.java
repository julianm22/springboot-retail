package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository cr;
	
	public void addCategory(Category c) {
		cr.save(c);
	}
	
	public List<Category> getCategories() {
		List<Category> clist = new ArrayList<>();
		cr.findAll().forEach(clist::add);
		clist.sort(Category::compareTo);
		return clist;
	}
	
	public Category getCategoryById(int id) {
		Category c = cr.findById(id).get();
		return c;
	}

	public boolean deleteCategory(int id) {
		if(cr.existsById(id)) {
			cr.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
