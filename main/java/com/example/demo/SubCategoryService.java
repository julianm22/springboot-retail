package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {
	
	@Autowired
	private SubCategoryRepository scr;
	
	public void addSubCategory(SubCategory sc) {
		scr.save(sc);
	}
	
	public List<SubCategory> getSubCategories() {
		List<SubCategory> sclist = new ArrayList<>();
		scr.findAll().forEach(sclist::add);
		sclist.sort(SubCategory::compareTo);
		return sclist;
	}

	public boolean deleteSubCategory(int id) {
		if(scr.existsById(id)) {
			scr.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
