package com.mariazgoba.handler.impl;

import com.mariazgoba.dao.ExpenseDao;
import com.mariazgoba.dao.impl.ExpenseDaoImpl;
import com.mariazgoba.enums.CommandEnums;
import com.mariazgoba.handler.CommandsHandler;
import com.mariazgoba.model.Expense;

public class ClearHandler extends CommandsHandler {
    private ExpenseDao expenseDao;
    private int size;

    public ClearHandler() {
        this.expenseDao = new ExpenseDaoImpl();
    }

    public void handleRequest(String inputs) {

        if (inputs.startsWith(CommandEnums.CLEAR.getCommand())) {
            //[0]command [1]date
            String[] data = inputs.split(" ", 2);
            size = expenseDao.getExpensesByDate(data[1]).size();

            expenseDao.deleteByDate(data[1]);
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
