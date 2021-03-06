package com.HaneiIslim.BookClub.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message="Title is required!")
    @Size(min=3, max=30, message="Title must be between 3 and 30 characters")
    private String title;
    
    @NotNull(message="Author is required!")
    @Size(min=3, max=30, message="Author name must be between 3 and 30 characters")
    private String author;
    
    @NotNull(message="Author is required!")
    @Size(min=10, max=100, message="you must do your thought")
    private String userThought;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="borrowed_user_id")
    private User userWhoBorrowed;
	private boolean borrow;
	
	// Constructors
	public Book() {
		
		
	}
	public Book(Long id, String title, String userThought, String author, User user, User userWhoBorrowed) {
		this.id = id;
		this.title = title;
		this.userThought = userThought;
		this.author = author;
		this.user = user;
		this.userWhoBorrowed = userWhoBorrowed;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public User getUserWhoBorrowed() {
		return userWhoBorrowed;
	}
	public void setUserWhoBorrowed(User userWhoBorrowed) {
		this.userWhoBorrowed = userWhoBorrowed;
	}
	public String getUserThought() {
		return userThought;
	}

	public void setUserThought(String userThought) {
		this.userThought = userThought;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public boolean isBorrow() {
		return borrow;
	}
	public void setBorrow(boolean borrow) {
		this.borrow = borrow;
	}
	
}
	
	
