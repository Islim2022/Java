package com.HaneiIslim.BookClub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.HaneiIslim.BookClub.models.Book;
import com.HaneiIslim.BookClub.models.User;
import com.HaneiIslim.BookClub.services.BookService;
import com.HaneiIslim.BookClub.services.UserService;

public class BookController {
	
	  @Autowired
	  private BookService bookServ;
	  private UserService userServ;
	  
	  @GetMapping("/books")
	  public String home(HttpSession session, Model model) {
	 	 // Getting the user from the session.
	 	 if (session.getAttribute("userId") != null) {
	 		 Long userId = (Long) session.getAttribute("userId");
	 		 User currentUser = userServ.getUserById(userId);
	 		 List<Book> books=bookServ.getAllBooks();
	 		 
	 		 model.addAttribute("currentUser", currentUser);
	 		 model.addAttribute("books", books);
	 		 return "Books.jsp";
	 	 } else {
	 		 return "redirect:/";
	 	 }
	  }
	  
	  @GetMapping("/books/new")
	  public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		Book book1 = new Book();
		
		model.addAttribute("Book", book1);
		return "AddBook.jsp";
	  }
	  
	  @PostMapping("/books/new")
	  public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, Model model) {
		  
		  if(result.hasErrors()) {
			  
			  return "AddBook.jsp";
			  
		  } else {
			  
			  Book bookNew = book;
			  User userId = new User();
			  userId = (User) session.getAttribute("userId");
			  
			  bookNew.setUser(userId);
			  model.addAttribute("book", bookNew);
			  bookServ.createBook(book);
			  
			  return "redirect:/books";
		  }
	  }
	  
		@GetMapping("/books/{id}")
		public String viewBook(@PathVariable("id") Long id, Model model, HttpSession session) {
			
			Book Book = bookServ.getBook(id);
			
			model.addAttribute("User", session.getAttribute("user"));
			model.addAttribute("Book", Book);
		
			return "ViewBook.jsp";
		}
		
		 @GetMapping("/books/editt/{id}")
		 public String EditBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book, HttpSession session, Model model) {
		    	Book bookEdit = bookServ.getBook(id);
		    	
		    	model.addAttribute("Book", bookEdit);
		    	model.addAttribute("User", session.getAttribute("user"));
		    	
		    	return "EditBook.jsp";
		 }
		 
		 @PostMapping("/books/edit/{id}")
		 public String EditBook(@ModelAttribute("book") Book book, HttpSession session, Model model) {
			 
			 Book bookNew = book;
			 User userId = new User();
			 userId = (User) session.getAttribute("userId");
			 
			 bookNew.setUser(userId);
			 model.addAttribute("book", bookNew);
			 bookServ.createBook(bookNew);
			 
			 return "redirect:/books";
		 }

}
