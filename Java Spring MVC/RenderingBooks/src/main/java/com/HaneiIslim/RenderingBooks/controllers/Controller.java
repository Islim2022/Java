package com.HaneiIslim.RenderingBooks.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HaneiIslim.RenderingBooks.models.Book;
import com.HaneiIslim.RenderingBooks.services.BookService;

@RestController
public class Controller {
    private final BookService BookService;
    public Controller(BookService BookService){
        this.BookService = BookService;
    }
    
    @RequestMapping("/api/books")
    public List<Book> index() {
        return BookService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
    	
        Book book = new Book(title, desc, lang, numOfPages);
        return BookService.createBook(book);
    }
    
//    @RequestMapping("/api/books/{id}")
//    public Book show(@PathVariable("id") Long id) {
//    	
//        Book book = BookService.findBook(id);
//        return book;
//    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = BookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        BookService.deleteBook(id);
    }

}