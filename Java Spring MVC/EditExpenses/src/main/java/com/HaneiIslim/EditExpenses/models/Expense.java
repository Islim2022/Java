package com.HaneiIslim.EditExpenses.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 4, max = 100, message = "Expense must not be empty")
    private String expense;
    @NotNull
    @Size(min = 4, max = 100, message = "Vendor must not be empty")
    private String vendor;
    @NotNull
    @Size(min = 3, max = 100, message = "Description must not be blank")
    private String description;
    @NotNull
    @Min(2)
    private double amount;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    public Expense() {
		
	}
    
    public Expense(String expense, String description, String vendor, double amount) {
    	this.expense = expense;
    	this.description = description;
    	this.vendor = vendor;
    	this.amount = amount;
    }
    
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getExpense() {
		return expense;
	}


	public void setExpense(String expense) {
		this.expense = expense;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
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


	// other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    
    

}
