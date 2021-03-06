package com.HaneiIslim.SaveTravels.controllers;

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

import com.HaneiIslim.SaveTravels.models.Expense;
import com.HaneiIslim.SaveTravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
    private final ExpenseService ExpenseService;
    public ExpenseController(ExpenseService ExpenseService){
        this.ExpenseService = ExpenseService;
    }
    
    
    @GetMapping("/expenses")
    public String allExpenses(@ModelAttribute("expense") Expense expense, Model model) {
        List<Expense>expenses = ExpenseService.allExpenses();
        model.addAttribute("expenses", expenses);
    return "Index.jsp";
    }
    
    @PostMapping("/addExpenses")
    public String createExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "Index.jsp";
        } else {
            ExpenseService.createExpense(expense);
            return "redirect:/expenses";
        }
    }

}