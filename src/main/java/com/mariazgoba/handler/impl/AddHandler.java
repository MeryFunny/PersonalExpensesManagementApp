package com.mariazgoba.handler.impl;

import com.mariazgoba.dao.ExpenseDao;
import com.mariazgoba.dao.impl.ExpenseDaoImpl;
import com.mariazgoba.enums.CommandEnums;
import com.mariazgoba.handler.CommandsHandler;
import com.mariazgoba.model.Expense;

public class AddHandler extends CommandsHandler {

    private ExpenseDao expenseDao;
    private Expense expense;

    public AddHandler() {
        this.expenseDao = new ExpenseDaoImpl();
    }

    public void handleRequest(String inputs) {
        if (inputs.startsWith(CommandEnums.ADD.getCommand())) {

            //[0]command [1]date, [2]price, [3]currency, [4]name
            String[] data = inputs.split(" ", 5);
            expense = new Expense(data[1], Double.parseDouble(data[2]), data[3], data[4]);
            expense = expenseDao.addExpense(expense);
            System.out.println(expense);
        } else {
            if (getNext() != null) {
                getNext().handleRequest(inputs);
            }
        }
    }
}
