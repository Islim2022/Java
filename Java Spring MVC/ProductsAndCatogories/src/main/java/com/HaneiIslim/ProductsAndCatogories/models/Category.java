package com.HaneiIslim.ProductsAndCatogories.models;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "category_id"), 
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    
	// Constructor
    public Category(Long id, String name, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}
	//Getters and Setters
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
    
}
