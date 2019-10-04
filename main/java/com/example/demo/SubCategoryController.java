package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubCategoryController {

	@Autowired
	private SubCategoryService scs;

	@PostMapping("/addSubCategory")
    public void addSubCategory(@RequestParam("subCategoryId") int id,
                            @RequestParam("subCategoryName") String name,
                            HttpServletResponse response) throws IOException {
        scs.addSubCategory(new SubCategory(id, name));
        response.sendRedirect("addSubCategoryPage");
    }

	@PostMapping("/removeSubCategory")
	public void removeSubCategory(@RequestParam("subCategoryId") int id, 
							HttpServletResponse response) throws IOException {
		scs.deleteSubCategory(id);
		response.sendRedirect("removeSubCategoryPage");
	}

}
