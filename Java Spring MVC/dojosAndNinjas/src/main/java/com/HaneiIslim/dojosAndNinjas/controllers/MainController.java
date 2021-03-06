package com.HaneiIslim.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.HaneiIslim.dojosAndNinjas.models.Dojos;
import com.HaneiIslim.dojosAndNinjas.models.Ninjas;
import com.HaneiIslim.dojosAndNinjas.services.dojosAndNinjasService;

@Controller
public class MainController {
	
    private final dojosAndNinjasService dojosAndNinjasService;
    public MainController(dojosAndNinjasService dojosAndNinjasService){
        this.dojosAndNinjasService = dojosAndNinjasService;
    }
    
    @GetMapping("/")
    public String index() {
    	return "redirect:/dojos";
    }
    
    @GetMapping("/dojos")
    public String dojos(@ModelAttribute("dojo") Dojos Dojo, Model model) {
    	List<Dojos> Dojos = dojosAndNinjasService.allDojos();
    	
    	model.addAttribute("Dojos", Dojos);
    	return "Dojo.jsp";
    }
    
    @GetMapping("/ninjas")
    public String ninjas(@ModelAttribute("ninja") Ninjas Ninja, Model model) {
    	List<Dojos> Dojos = dojosAndNinjasService.allDojos();
    
    	model.addAttribute("Dojos", Dojos);
    	return "Ninja.jsp";
    }
    
    @GetMapping("/dojos/{id}")
    public String viewDojo(@PathVariable("id") Long id, Model model) {
    	List<Ninjas> Ninja = dojosAndNinjasService.allNinjas();
    	Dojos dojo = dojosAndNinjasService.findDojo(id);
    	
    	model.addAttribute("Ninja", Ninja);
    	model.addAttribute("Dojo", dojo);
    	
    	return "Show.jsp";
    }
    
    @PostMapping("/dojos/new")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojos Dojo, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		return "Dojo.jsp";
    	} else {
	    	dojosAndNinjasService.createDojo(Dojo);
	    	model.addAttribute(Dojo);
	    	return "redirect:/ninjas/new";
    	}
    }
    
    @PostMapping("/ninjas/new")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninjas Ninja, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		return "Ninja.jsp";
    	} else {
	    	dojosAndNinjasService.createNinja(Ninja);
	    	model.addAttribute(Ninja);
	    	return "redirect:/dojos/" + Ninja.getDojo().getId();
    	}
    }

}
