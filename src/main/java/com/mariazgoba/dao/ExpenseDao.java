package com.mariazgoba.dao;

import com.mariazgoba.model.Expense;

import java.util.List;

public interface ExpenseDao {

    Expense addExpense(Expense expense);

    List<Expense> getAllExpenses();

    void deleteByDate(String expenseDate);

    List<Expense> getExpensesByDate(String expenseDate);
}
