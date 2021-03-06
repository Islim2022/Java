package com.HaneiIslim.loginregistration.controllers;
//.. don't forget to inlcude all your imports! ..

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HaneiIslim.loginregistration.models.LoginUser;
import com.HaneiIslim.loginregistration.models.User;
import com.HaneiIslim.loginregistration.services.UserService;

@Controller
public class MainController {
 
 // Add once service is implemented:
  @Autowired
  private UserService userServ;
 
 @GetMapping("/")
 public String index(Model model, HttpSession session) {
 
	 if(session.getAttribute("userId") != null) {
		 return "redirect:/home";
	 } else {
     model.addAttribute("newUser", new User());
     model.addAttribute("newLogin", new LoginUser());
     return "Index.jsp";
	 }
 }
 
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
     
	 User registeredUser = userServ.registerUser(newUser, result);
     
     if(result.hasErrors()) {
       // model.addAttribute("newLogin", new LoginUser());
         return "Index.jsp";
     } else {
    	 session.setAttribute("userId", registeredUser.getId());
    	 return "redirect:/home";
     }
 }
 
 @PostMapping("/login")
 public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {

     User user = userServ.loginUser(newLogin, result);
 
     if(result.hasErrors()) {
         model.addAttribute("newUser", new User());
         return "Index.jsp";
     } else {
    	 session.setAttribute("userId", user.getId());
    	 return "redirect:/home";
     }
 }
 @GetMapping("/home")
 public String home(HttpSession session, Model model) {
	 // Getting the user from the session.
	 if (session.getAttribute("userId") != null) {
		 Long userId = (Long) session.getAttribute("userId");
		 User currentUser = userServ.getUserById(userId);
		 model.addAttribute("currentUser", currentUser);
		 return "Home.jsp";
	 } else {
		 return "redirect:/";
	 }
 }
 
 @GetMapping("/logout")
 public String logout(HttpSession session) {
	 session.invalidate();
	 return "redirect:/";
 }
 
}

