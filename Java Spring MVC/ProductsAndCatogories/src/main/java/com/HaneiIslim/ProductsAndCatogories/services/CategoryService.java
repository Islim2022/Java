package com.HaneiIslim.ProductsAndCatogories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HaneiIslim.ProductsAndCatogories.models.Category;
import com.HaneiIslim.ProductsAndCatogories.models.Product;
import com.HaneiIslim.ProductsAndCatogories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepo;
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo=categoryRepo;	
	}
	
	// Retrieves all Categories
	public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}
	
	// Create a new Category
	public Category createCategory(Category cate) {
		return categoryRepo.save(cate);
	}
	
	// Retrieve a Category by ID 
	public Category getCategory(Long id) {
		Optional<Category> category= categoryRepo.findById(id);
		if(category.isPresent()) {
			return category.get();
		} else {
			return null;
		}
	}
	// Retrieve all Categories, which belong to a specific product
	public List<Category>getAllCategoriesInThisProduct(Product product){
		return categoryRepo.findAllByProducts(product);
	}
	
	// Retrieve all Categories, which do not belong to a specific product
	public List<Category>getAllCategoriesNotInThisProduct(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
}
