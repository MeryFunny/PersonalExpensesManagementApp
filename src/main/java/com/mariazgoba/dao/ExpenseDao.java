package com.mariazgoba.dao;

import com.mariazgoba.model.Expense;
import com.mariazgoba.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {

    private Connection connection;

    public ExpenseDao() {
        connection = DatabaseUtil.getConnection();
    }

    public void addExpense(Expense expense) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO expenses_management.expenses( Date, Price, Currency, Name) VALUES (?,?,?,?)");
            preparedStatement.setDate(1, Date.valueOf(expense.getDate()));
            preparedStatement.setDouble(2, expense.getPrice());
            preparedStatement.setString(3, expense.getCurrency());
            preparedStatement.setString(4, expense.getName());
            preparedStatement.executeUpdate();

            System.out.println(expense.toString());
        } catch (SQLException e) {
            System.out.println("ERROR! Data was not added.");
            e.printStackTrace();
        }
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM expenses_management.expenses");
            while (resultSet.next()) {
                Expense expense = new Expense();
                expense.setId(resultSet.getInt("Id"));
                expense.setDate(resultSet.getDate("Date").toString());
                expense.setPrice(resultSet.getDouble("Price"));
                expense.setCurrency(resultSet.getString("Currency"));
                expense.setName(resultSet.getString("Name"));
                expenses.add(expense);
            }

        } catch (SQLException e) {
            System.out.println("ERROR! Data was not selected.");
            e.printStackTrace();
        }
        return expenses;
    }

    public void deleteByDate(String expenseDate) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM expenses_management.expenses WHERE Date=?");
            preparedStatement.setDate(1, Date.valueOf(expenseDate));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR! Data was not deleted.");
        }
    }
}
