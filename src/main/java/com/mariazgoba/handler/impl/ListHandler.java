package com.mariazgoba.handler.impl;

import com.mariazgoba.dao.ExpenseDao;
import com.mariazgoba.dao.impl.ExpenseDaoImpl;
import com.mariazgoba.enums.CommandEnums;
import com.mariazgoba.handler.CommandsHandler;
import com.mariazgoba.model.Expense;

import java.util.Comparator;

public class ListHandler extends CommandsHandler {
    public void handleRequest(String inputs) {
        if (inputs.startsWith(CommandEnums.LIST.getCommand())) {
            ExpenseDao expenseDao = new ExpenseDaoImpl();
            Comparator<Expense> byDate = (e1, e2) -> e1.getDate().compareTo(e2.getDate());
            expenseDao.getAllExpenses()
                    .stream()
                    .sorted(byDate)
                    .forEach(e -> System.out.println(e));
        } else {
            if (getNext() != null) {
                getNext().handleRequest(inputs);
            }
        }
    }


}
