package com.mariazgoba.handler.impl;

import com.mariazgoba.dao.ExpenseDao;
import com.mariazgoba.enums.CommandEnums;
import com.mariazgoba.handler.CommandsHandler;

import java.util.List;

public class ClearHandler extends CommandsHandler {
    public void handleRequest(String inputs) {
        if (inputs.startsWith(CommandEnums.CLEAR.getCommand())) {
            //[0]command [1]date
            String[] data = inputs.split(" ", 2);
            ExpenseDao expenseDao = new ExpenseDao();
            expenseDao.deleteByDate(data[1]);
        } else {
            if (getNext() != null) {
                getNext().handleRequest(inputs);
            }
        }
    }
}
