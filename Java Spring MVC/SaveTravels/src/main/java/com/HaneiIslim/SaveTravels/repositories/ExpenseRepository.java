package com.HaneiIslim.SaveTravels.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HaneiIslim.SaveTravels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    List<Expense> findAll();

    List<Expense> findByDescriptionContaining(String search);

}
