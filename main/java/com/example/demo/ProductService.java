package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository pr;
	
	public void addProduct(Product p) {
		pr.save(p);
	}
	
	public List<Product> getProducts() {
		List<Product> plist = new ArrayList<>();
		pr.findAll().forEach(plist::add);
		plist.sort(Product::compareTo);
		return plist;
	}

	public boolean deleteProduct(int id) {
		if(pr.existsById(id)) {
			pr.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
