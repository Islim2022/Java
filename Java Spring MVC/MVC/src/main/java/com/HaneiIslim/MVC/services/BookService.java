package com.HaneiIslim.MVC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HaneiIslim.MVC.models.Book;
import com.HaneiIslim.MVC.repositories.BookRepository;

@Service 
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepo;
    
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }
    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book updateBook(Long id, String title, String description, String language, int numberOfPages) {
    	Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(title);
            book.setDescription(description);
            book.setLanguage(language);
            book.setNumberOfPages(numberOfPages);
            bookRepo.save(book);
            return book;
        } else {
            return null;
        }
    }
    
    public void deleteBook(Long id) {
    	bookRepo.deleteById(id);
    }

}
