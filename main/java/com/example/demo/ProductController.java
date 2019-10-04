package com.example.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductService ps;
	
	@Autowired
	private CategoryService cs;

	@PostMapping("/addProduct")
    public void addProduct(@RequestParam("productName") String name,
    						@RequestParam("productPrice") double price,
    						@RequestParam("description") String description,
    						@RequestParam("category") int category,
                            HttpServletResponse response) throws IOException {
		ps.addProduct(new Product(name, price, description, category));
        response.sendRedirect("addProductPage");
    }

	@PostMapping("/removeProduct")
	public void removeProduct(@RequestParam("productId") int id, 
							HttpServletResponse response) throws IOException {
		ps.deleteProduct(id);
		response.sendRedirect("removeProductPage");
	}

}
