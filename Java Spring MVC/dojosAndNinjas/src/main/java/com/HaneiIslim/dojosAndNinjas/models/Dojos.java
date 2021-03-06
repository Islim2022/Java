package com.HaneiIslim.dojosAndNinjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Dojos")
public class Dojos {
	
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 2, max = 225, message = "DojosName must not be empty and at least 2 characters.")
    private String name;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninjas> ninjas;
    
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }

    // Constructors
    public Dojos() {
        
    }

	public Dojos(Long id, String name, List<Ninjas> ninjas) {
		this.name = name;
		this.ninjas = ninjas;
		this.id = id;
	}

    // getters and setters removed for brevity
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
	
	public List<Ninjas> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninjas> ninjas) {
		this.ninjas = ninjas;
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
    

    
}
