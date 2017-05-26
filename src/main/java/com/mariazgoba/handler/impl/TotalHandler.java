package com.mariazgoba.handler.impl;

import com.mariazgoba.dao.ExpenseDao;
import com.mariazgoba.enums.CommandEnums;
import com.mariazgoba.model.Expense;
import com.mariazgoba.services.ExchangeService;

import java.text.DecimalFormat;
import java.util.List;

public class TotalHandler extends ClearHandler {
    public void handleRequest(String inputs) {
        if (inputs.startsWith(CommandEnums.TOTAL.getCommand())) {
            //[0]command [1]date
            String[] data = inputs.split(" ", 2);
            ExpenseDao expenseDao = new ExpenseDao();
            ExchangeService exchangeService = new ExchangeService(data[1]);
            double total= calculateSum(exchangeService.exchangeToBaseCurrency( expenseDao.getAllExpenses()));
            System.out.println(new DecimalFormat("#0.00").format(total) + " "+ data[1]);

        } else {
            if (getNext() != null) {
                getNext().handleRequest(inputs);
            }
        }
    }

    private static double calculateSum(List<Expense> expenses) {
        double sum = 0;
        for (int i = 0; i < expenses.size(); i++) {
            sum += expenses.get(i).getPrice();
        }
        return sum;
    }
}
