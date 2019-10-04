package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService cs;

	@PostMapping("/addCategory")
    public void addCategory(@RequestParam("categoryName") String name,
                            HttpServletResponse response) throws IOException {
        Category c = new Category();
        c.setCategoryName(name);
		cs.addCategory(c);
        response.sendRedirect("addCategoryPage");
    }

	@PostMapping("/removeCategory")
	public void removeCategory(@RequestParam("categoryId") int id, 
							HttpServletResponse response) throws IOException {
		cs.deleteCategory(id);
		response.sendRedirect("removeCategoryPage");
	}

}
