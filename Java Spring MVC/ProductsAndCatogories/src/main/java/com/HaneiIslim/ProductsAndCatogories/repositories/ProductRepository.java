package com.HaneiIslim.ProductsAndCatogories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HaneiIslim.ProductsAndCatogories.models.Category;
import com.HaneiIslim.ProductsAndCatogories.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product>findAll();
	
	// Retrieves a list of all products for a particular product
    List<Product> findAllByCategories(Category cate);
    
    // Retrieves a list of any products a particular product
    // does not belong to.
    List<Product> findByCategoriesNotContains(Category cate);
}