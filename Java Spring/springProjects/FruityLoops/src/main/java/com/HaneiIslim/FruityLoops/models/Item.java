package com.HaneiIslim.FruityLoops.models;

public class Item {
	private String Name;
	private double Price;
	
	public Item(String Name, double Price) {
		this.Name = Name;
		this.Price = Price;
	}
	// Getters
	public String getName() {
		return Name;
	}
	public double getPrice() {
		return Price;
	}
	
	// Setters
	public void setName(String Name) {
		this.Name = Name;
	}
	public void setPrice(double Price) {
		this.Price = Price;
	}
}
