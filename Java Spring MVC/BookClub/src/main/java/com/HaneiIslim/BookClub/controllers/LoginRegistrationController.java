package com.HaneiIslim.BookClub.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.HaneiIslim.BookClub.models.LoginUser;
import com.HaneiIslim.BookClub.models.User;
import com.HaneiIslim.BookClub.services.UserService;

@Controller
public class LoginRegistrationController {
 
 // Add once service is implemented:
  @Autowired
  private UserService userServ;
  
 
 @GetMapping("/")
 public String index(Model model, HttpSession session) {
 
	 if(session.getAttribute("userId") != null) {
		 return "redirect:/books";
	 } else {
     model.addAttribute("newUser", new User());
     model.addAttribute("newLogin", new LoginUser());
     return "Home.jsp";
	 }
 }
 
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
     
	 User registeredUser = userServ.registerUser(newUser, result);
     
     if(result.hasErrors()) {
         model.addAttribute("newLogin", new LoginUser());
         return "Home.jsp";
     } else {
    	 session.setAttribute("userId", registeredUser.getId());
    	 return "redirect:/books";
     }
 }
 
 @PostMapping("/login")
 public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {

     User user = userServ.loginUser(newLogin, result);
 
     if(result.hasErrors()) {
         model.addAttribute("newUser", new User());
         return "Home.jsp";
     } else {
    	 session.setAttribute("userId", user.getId());
    	 return "redirect:/books";
     }
 }
 
 @GetMapping("/logout")
 public String logout(HttpSession session) {
	 session.invalidate();
	 return "redirect:/";
 }
 
}
