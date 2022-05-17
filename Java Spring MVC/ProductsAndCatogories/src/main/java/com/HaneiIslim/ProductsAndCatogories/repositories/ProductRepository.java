package com.HaneiIslim.ProductsAndCatogories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HaneiIslim.ProductsAndCatogories.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product>findAll();
}