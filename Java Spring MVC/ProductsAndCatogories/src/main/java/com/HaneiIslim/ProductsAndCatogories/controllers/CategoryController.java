package com.HaneiIslim.ProductsAndCatogories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HaneiIslim.ProductsAndCatogories.models.Category;
import com.HaneiIslim.ProductsAndCatogories.services.CategoryService;

@Controller
public class CategoryController {
	
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	
	@GetMapping("/categories/new")
	public String index(@ModelAttribute ("category") Category cate) {
		
		return "addCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@ModelAttribute("category") Category cate) {
		categoryService.createCategory(cate);
		
		return "redirect:/categories/new";
	}
}