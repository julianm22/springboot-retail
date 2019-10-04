package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
    private CategoryService cs;
	
	@Autowired
    private SubCategoryService scs;
	
	@Autowired
    private ProductService ps;

    @GetMapping(path = {"/home","/","/homep"})
    public String homePage(Model model) {
        return "index";
    }
    
    /********************Login**********************/
    
    @GetMapping(path = {"/login","/loginPage","/loginp"})
    public String loginPage(Model model) {
        return "login";
    }
    
    @GetMapping(path = {"/register","/registrationPage","/registration"})
    public String registrationPage(Model model) {
        return "register";
    }
    
    @GetMapping(path = {"/admin","/adminHome","/adminPage"})
    public String adminPage(Model model) {
        return "admin";
    }
    
    @GetMapping(path = {"/user","/userHome","/userPage"})
    public String userPage(Model model) {
        return "user";
    }
    
    @GetMapping(path = {"/invalid","/invalidLogin"})
    public String invalidLogin(Model model) {
        return "invalid";
    }
    
    /********************Category**********************/

    @GetMapping("/categoryPage")
    public String categoryPage(ModelMap model) {
        List<Category> categories = cs.getCategories();
        model.addAttribute("categories", categories);
        return "category";
    }
    
    @GetMapping("/showAllCategories")
    public String showAllCategories(ModelMap model) {
        List<Category> categories = cs.getCategories();
        model.addAttribute("categories", categories);
        return "showCategories";
    }
    
    @GetMapping("/addCategoryPage")
    public String addCategoryPage(ModelMap model) {
        List<Category> categories = cs.getCategories();
        model.addAttribute("categories", categories);
        return "addCategory";
    }

    @GetMapping("/removeCategoryPage")
    public String removeCategoryPage(ModelMap model) {
        List<Category> categories = cs.getCategories();
        model.addAttribute("categories", categories);
        return "removeCategory";
    }
    
    /*******************Sub Category*********************/
    
    @GetMapping("/subCategoryPage")
    public String subCategoryPage(ModelMap model) {
        List<SubCategory> subCategories = scs.getSubCategories();
        model.addAttribute("subCategories", subCategories);
        return "subCategory";
    }
    
    @GetMapping("/showAllSubCategories")
    public String showAllSubCategories(ModelMap model) {
        List<SubCategory> subCategories = scs.getSubCategories();
        model.addAttribute("subCategories", subCategories);
        return "showSubCategories";
    }
    
    @GetMapping("/addSubCategoryPage")
    public String addSubCategoryPage(ModelMap model) {
        List<SubCategory> subCategories = scs.getSubCategories();
        model.addAttribute("subCategories", subCategories);
        return "addSubCategory";
    }

    @GetMapping("/removeSubCategoryPage")
    public String removeSubCategoryPage(ModelMap model) {
        List<SubCategory> subCategories = scs.getSubCategories();
        model.addAttribute("subCategories", subCategories);
        return "removeSubCategory";
    }
    
    /********************Product**********************/
    
    @GetMapping("/productPage")
    public String productPage(ModelMap model) {
        List<Product> products = ps.getProducts();
        model.addAttribute("products", products);
        return "product";
    }
    
    @GetMapping("/showAllProducts")
    public String showAllProducts(ModelMap model) {
    	List<Product> products = ps.getProducts();
    	products.forEach(p -> p.setCategoryName(cs.getCategoryById(p.getCategoryId()).getCategoryName()));
        model.addAttribute("products", products);
        return "showProducts";
    }
    
    @RequestMapping("/addProductPage")
    public String addProductsPage(ModelMap model) {
    	List<Category> categories = cs.getCategories();
    	List<Product> products = ps.getProducts();
    	products.forEach(p -> p.setCategoryName(cs.getCategoryById(p.getCategoryId()).getCategoryName()));
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "addProduct";
    }

    @GetMapping("/removeProductPage")
    public String removeProductsPage(ModelMap model) {
    	List<Product> products = ps.getProducts();
    	products.forEach(p -> p.setCategoryName(cs.getCategoryById(p.getCategoryId()).getCategoryName()));
        model.addAttribute("products", products);
        return "removeProduct";
    }

}
