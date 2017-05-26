package com.mariazgoba.handler.impl;

import com.mariazgoba.dao.ExpenseDao;
import com.mariazgoba.enums.CommandEnums;
import com.mariazgoba.handler.CommandsHandler;
import com.mariazgoba.model.Expense;

import java.util.List;

public class ListHandler extends CommandsHandler {
    public void handleRequest(String inputs) {
        if (inputs.startsWith(CommandEnums.LIST.getCommand())) {
            ExpenseDao expenseDao = new ExpenseDao();
            for (Expense iter : expenseDao.getAllExpenses()) {
                System.out.println(iter);
            }
        } else {
            if (getNext() != null) {
                getNext().handleRequest(inputs);
            }
        }
    }
}
