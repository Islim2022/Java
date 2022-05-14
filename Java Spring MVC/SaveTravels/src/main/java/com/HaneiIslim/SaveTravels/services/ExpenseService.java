package com.HaneiIslim.SaveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HaneiIslim.SaveTravels.models.Expense;
import com.HaneiIslim.SaveTravels.repositories.ExpenseRepository;

@Service 
public class ExpenseService {
    // adding the expense repository as a dependency
    private final ExpenseRepository expenseRepo;
    
    public ExpenseService(ExpenseRepository expenseRepo) {
        this.expenseRepo = expenseRepo;
    }
    
    // returns all the expenses
    public List<Expense> allExpenses() {
        return expenseRepo.findAll();
    }
    // creates an expense
    public Expense createExpense(Expense e) {
        return expenseRepo.save(e);
    }
    // retrieves an expense
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepo.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    
    public Expense updateExpense(Long id, String exp, String description, String vendor, double price) {
    	Optional<Expense> optionalExpense = expenseRepo.findById(id);
        if(optionalExpense.isPresent()) {
            Expense expense = optionalExpense.get();
            expense.setExpense(exp);
            expense.setDescription(description);
            expense.setVendor(vendor);
            expense.setAmount(price);
            expenseRepo.save(expense);
            return expense;
        } else {
            return null;
        }
    }
    
    public void deleteExpense(Long id) {
    	expenseRepo.deleteById(id);
    }

}
