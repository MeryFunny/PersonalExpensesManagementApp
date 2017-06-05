package handler;

import com.mariazgoba.handler.impl.AddHandler;
import com.mariazgoba.model.Expense;
import org.junit.Test;
import stub.dao.ExpenseDaoTestImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class AddHandlerTest {

    @Test
    public void testHandleRequest() throws Exception {
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(1, "2017-06-03", 13.15, "PLN", "Pens"));
        expenses.add(new Expense(2, "2017-06-03", 2, "EUR", "Pepsi"));
        expenses.add(new Expense(3, "2017-06-04", 700, "CZK", "Dress"));

        AddHandler addHandler = new AddHandler();
        Expense expense = new Expense("2017-06-04", 15, "EUR", "drinks");
        Field expenseDaoField = addHandler.getClass().getDeclaredField("expenseDao");
        if (Objects.nonNull(expenseDaoField)) {
            expenseDaoField.setAccessible(true);
            expenseDaoField.set(addHandler, new ExpenseDaoTestImpl(expenses));
        }
        addHandler.handleRequest("add 2017-06-04 15 EUR drinks");

        Field expenseField = addHandler.getClass().getDeclaredField("expense");
        if (Objects.nonNull(expenseField)) {
            expenseField.setAccessible(true);
            Expense result = (Expense) expenseField.get(addHandler);
            assertEquals(expense.toString(), result.toString());
        }
    }
}
