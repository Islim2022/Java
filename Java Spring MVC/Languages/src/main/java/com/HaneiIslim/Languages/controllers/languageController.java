package com.HaneiIslim.Languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HaneiIslim.Languages.models.language;
import com.HaneiIslim.Languages.services.languageService;

@Controller
public class languageController {
	
    private final languageService languageService;
    public languageController(languageService languageService){
        this.languageService = languageService;
    }
    
    
    @GetMapping("/languages")
    public String allLanguages(@ModelAttribute("language") language language, Model model) {
        List<language>languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
    return "Index.jsp";
    }
    
    @PostMapping("/languages")
    public String createLanguage(@Valid @ModelAttribute("language") language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @GetMapping("/languages/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
    	language language = languageService.findLanguage(id);
    	model.addAttribute("language", language);
    	return "Edit.jsp";
    }
    
    @GetMapping("/languages/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
    	return "redirect:/languages";
    }
    
    @GetMapping("/langiages/{id}")
    public String viewLanguage(@PathVariable("id")Long id, Model model) {
    	language language = languageService.findLanguage(id);
    	model.addAttribute("language", language);
    	return "View.jsp";
    }
    
    @RequestMapping("/languages/{id}")
    public String updateLanguage(@Valid @ModelAttribute("language") language language, BindingResult result) {
        if (result.hasErrors()) {
            return "Index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
}

