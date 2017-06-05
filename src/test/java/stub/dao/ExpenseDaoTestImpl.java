package stub.dao;

import com.mariazgoba.dao.ExpenseDao;
import com.mariazgoba.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseDaoTestImpl implements ExpenseDao {
    private List<Expense> expenses;

    public ExpenseDaoTestImpl(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public Expense addExpense(Expense expense) {
        expenses = new ArrayList<>();
        expenses.add(expense);
        return expense;
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public void deleteByDate(String expenseDate) {

        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getDate().equals(expenseDate)) {
                expenses.remove(i);
            }
        }
    }

    public List<Expense> getExpensesByDate(String expenseDate) {

        List<Expense> result = new ArrayList<>();
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getDate().equals(expenseDate)) {
                result.add(expenses.get(i));
            }
        }
        return result;
    }
}
