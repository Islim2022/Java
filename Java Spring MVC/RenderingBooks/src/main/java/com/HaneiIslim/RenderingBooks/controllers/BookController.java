package com.HaneiIslim.RenderingBooks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HaneiIslim.RenderingBooks.models.Book;
import com.HaneiIslim.RenderingBooks.services.BookService;

@Controller
public class BookController {
	
    private final BookService BookService;
    public BookController(BookService BookService){
        this.BookService = BookService;
    }
    
    @RequestMapping("/")
    public String show() {
    	return "show.jsp";
    }
    
    @RequestMapping("/api/books/{id}")
    public String show2(@PathVariable("id") Long id, Model model) {
    	Book book = BookService.findBook(id);
    	model.addAttribute("book", book);
    	return "show.jsp";
    }

}
