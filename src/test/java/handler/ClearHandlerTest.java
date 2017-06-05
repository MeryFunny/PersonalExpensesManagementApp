package handler;

import com.mariazgoba.handler.impl.ClearHandler;
import com.mariazgoba.model.Expense;
import org.junit.Test;
import stub.dao.ExpenseDaoTestImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class ClearHandlerTest {

    @Test
    public void testHandleRequest() throws Exception {
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(1, "2017-06-03", 13.15, "PLN", "Pens"));
        expenses.add(new Expense(2, "2017-06-03", 2, "EUR", "Pepsi"));
        expenses.add(new Expense(3, "2017-06-04", 700, "CZK", "Dress"));

        ClearHandler clearHandler = new ClearHandler();
        Field expenseDaoField = clearHandler.getClass().getDeclaredField("expenseDao");
        if (Objects.nonNull(expenseDaoField)) {
            expenseDaoField.setAccessible(true);
            expenseDaoField.set(clearHandler, new ExpenseDaoTestImpl(expenses));
        }

        clearHandler.handleRequest("clear 2017-06-03");

        Field sizeField = clearHandler.getClass().getDeclaredField("size");
        if (Objects.nonNull(sizeField)) {
            sizeField.setAccessible(true);
            int size = (int) sizeField.get(clearHandler);

            assertEquals(2, size);
        }
    }
}
