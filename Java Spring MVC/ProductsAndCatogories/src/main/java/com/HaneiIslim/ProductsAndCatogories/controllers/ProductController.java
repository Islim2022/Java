package com.HaneiIslim.ProductsAndCatogories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HaneiIslim.ProductsAndCatogories.models.Category;
import com.HaneiIslim.ProductsAndCatogories.models.Product;
import com.HaneiIslim.ProductsAndCatogories.services.CategoryService;
import com.HaneiIslim.ProductsAndCatogories.services.ProductService;

@Controller
public class ProductController {
	
	private final ProductService pService;
	private final CategoryService cService;
	
	public ProductController(ProductService productService,CategoryService categoryService) {
		this.pService = productService;
		this.cService = categoryService;
	}
	
	@GetMapping("/products/new")
	public String index(@ModelAttribute("product") Product p) {
		
		return "addProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@ModelAttribute("product") Product p) {
		pService.createProduct(p);
		
		return "redirect:/products/new";
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		
		Product Product = pService.getProduct(id);
		List<Category> includedCategories = cService.getAllCategoriesInThisProduct(Product);
		List<Category> notIncludedCategories = cService.getAllCategoriesNotInThisProduct(Product);
		
		model.addAttribute("Product", Product);
		model.addAttribute("Categories", includedCategories);
		model.addAttribute("Categories", notIncludedCategories);
		
		for (Category category : includedCategories) {
			System.out.println(category.getName());
		}

		for (Category category : notIncludedCategories) {
			System.out.println(category.getName());
		}
	
		return "Products.jsp";
	}
	
	@PostMapping("/products/addCategory/{id}")
	public String addCategory(@RequestParam("cate") Long cate , @PathVariable("id") Long id) {
		
		Product product = pService.getProduct(id);
		Category category = cService.getCategory(cate);
		List<Category> categories = product.getCategories();
		
		categories.add(category);
		product.setCategories(categories);
		pService.updateProduct(product);
		
		return"redirect:/";
	}
}
