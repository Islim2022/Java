package com.HaneiIslim.allBooks.services;

import java.util.List;
import java.util.Optional;

import com.HaneiIslim.allBooks.models.Book;
import com.HaneiIslim.allBooks.repositories.BookRepository;

public class BookService {
	
	private final BookRepository bookRepo;
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;	
	}
	
	// Retrieves all books
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	// Create a new book
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	// Retrieve a book by ID 
	public Book getBook(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if(book.isPresent()) {
			return book.get();
		} else {
			return null;
		}
	}
	
//	// Retrieve all books that are borrowed
//	public List<Book> getAllBookss(){
//		return bookRepo.findByBorrow(false);
//	}
//	
//    public Book updateBook(Book book) {
//    	Optional<Book> optionalBook = bookRepo.findById(book.getId());
//        if(optionalBook.isPresent()) {
//        	Book book2 = optionalBook.get();
//        	book2.setTitle(book2.getTitle());
//        	book2.setAuthor(book2.getAuthor());
//        	book2.setUserThought(book2.getUserThought());
//        	book2.setUserWhoBorrowed(book2.getUserWhoBorrowed());
//        	bookRepo.save(book2);
//            return book2;
//        } else {
//            return null;
//        }
//    }
//	
//	// Delete a book by id
//    public void deleteBook(Long id) {
//    	bookRepo.deleteById(id);
//    }

}
