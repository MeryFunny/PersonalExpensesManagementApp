package stub.dao;

import com.mariazgoba.dao.ExpenseDao;
import com.mariazgoba.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseDaoTestImpl implements ExpenseDao {

    public ExpenseDaoTestImpl() {

    }

    public void addExpense(Expense expense) {

    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();

        expenses.add(new Expense(1, "2017-06-03", 13.15, "PLN", "Pens"));
        expenses.add(new Expense(2, "2017-06-03", 2, "EUR", "Pepsi"));
        expenses.add(new Expense(3, "2017-06-04", 700, "CZK", "Dress"));
        return expenses;
    }

    public void deleteByDate(String expenseDate) {
    }
}
