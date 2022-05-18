package com.HaneiIslim.ProductsAndCatogories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HaneiIslim.ProductsAndCatogories.models.Category;
import com.HaneiIslim.ProductsAndCatogories.models.Product;
import com.HaneiIslim.ProductsAndCatogories.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepo;
	
	public ProductService(ProductRepository productRepo) {
		this.productRepo=productRepo;	
	}
	
	// Retrieves all Products
	public List<Product> getAllCategories(){
		return productRepo.findAll();
	}
	
	// Creates a Product
	public Product createProduct(Product p) {
		this.productRepo.save(p);
		return p;
	}
	// Retrieves a Product by ID
	public Product getProduct(Long id) {
		Optional<Product> product= productRepo.findById(id);
		if(product.isPresent()) {
			return product.get();
		} else {
			return null;
		}
	}
	
	// Update a specific product
	public Product updateProduct(Product p) {
		return productRepo.save(p);
	}
	
	// Retrieve all Categories, which belong to a specific product
	public List<Product>getAllProductsInThisCategory(Category cate){
		return productRepo.findAllByCategories(cate);
	}
	
	// Retrieve all Categories, which do not belong to a specific product
	public List<Product>getAllProductsNotInThisCategory(Category cate){
		return productRepo.findByCategoriesNotContains(cate);
	}
}
