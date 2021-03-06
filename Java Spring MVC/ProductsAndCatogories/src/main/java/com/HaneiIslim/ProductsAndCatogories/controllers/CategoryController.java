package com.HaneiIslim.ProductsAndCatogories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.HaneiIslim.ProductsAndCatogories.models.Category;
import com.HaneiIslim.ProductsAndCatogories.models.Product;
import com.HaneiIslim.ProductsAndCatogories.services.CategoryService;
import com.HaneiIslim.ProductsAndCatogories.services.ProductService;

@Controller
public class CategoryController {
	
	private final ProductService pService;
	private final CategoryService cService;
	
	public CategoryController(ProductService productService,CategoryService categoryService) {
		this.pService = productService;
		this.cService = categoryService;
	}
	
	@GetMapping("/categories/new")
	public String index(@ModelAttribute ("category") Category cate) {
		
		return "addCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@ModelAttribute("category") Category cate) {
		cService.createCategory(cate);
		
		return "redirect:/categories/new";
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		
		Category Category = cService.getCategory(id);
		List<Product> includedProducts = pService.getAllProductsInThisCategory(Category);
		List<Product> notIncludedProducts = pService.getAllProductsNotInThisCategory(Category);
		
		model.addAttribute("Category", Category);
		model.addAttribute("Products", includedProducts);
		model.addAttribute("Products", notIncludedProducts);
		
		for (Product product : includedProducts) {
			System.out.println(product.getName());
		}

		for (Product product : notIncludedProducts) {
			System.out.println(product.getName());
		}
	
		return "Categories.jsp";
	}
}