package com.HaneiIslim.ProductsAndCatogories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.HaneiIslim.ProductsAndCatogories.models.Category;
import com.HaneiIslim.ProductsAndCatogories.models.Product;
import com.HaneiIslim.ProductsAndCatogories.services.CategoryService;
import com.HaneiIslim.ProductsAndCatogories.services.ProductService;

@Controller
public class HomeController {
	private final CategoryService cService;
	private final ProductService pService;

	public HomeController(CategoryService cService,ProductService pService) {
		this.cService=cService;
		this.pService=pService;
	}
	
	@GetMapping("/")
	public String homePage( Model model) {
		
		List<Category> categories = cService.getAllCategories();
		List<Product> products = pService.getAllCategories();
		
		for (Category category : categories) {
			System.out.println(category.getName());
		}

		for (Product product : products) {
			System.out.println(product.getName());
		}

		model.addAttribute("products", products);
		model.addAttribute("categories", categories);

		return "Home.jsp";
	}
	
}
