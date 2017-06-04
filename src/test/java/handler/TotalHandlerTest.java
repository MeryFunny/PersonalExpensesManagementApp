package handler;

import com.mariazgoba.handler.impl.TotalHandler;
import com.mariazgoba.services.ExchangeService;
import org.junit.Test;
import stub.dao.ExpenseDaoTestImpl;
import stub.rest.RestTemplateTestImpl;

import java.lang.reflect.Field;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class TotalHandlerTest {

    @Test
    public void testHandleRequest() throws Exception {
        TotalHandler totalHandler = new TotalHandler();
        Field expenseDaoField = totalHandler.getClass().getDeclaredField("expenseDao");
        if (Objects.nonNull(expenseDaoField)) {
            expenseDaoField.setAccessible(true);
            expenseDaoField.set(totalHandler, new ExpenseDaoTestImpl());
        }
        Field exchangeServiceField = totalHandler.getClass().getDeclaredField("exchangeService");
        if (Objects.nonNull(exchangeServiceField)) {
            exchangeServiceField.setAccessible(true);
            ExchangeService exchangeService = new ExchangeService();

            Field restTemplateField = exchangeService.getClass().getDeclaredField("restTemplate");
            if (Objects.nonNull(restTemplateField)) {
                restTemplateField.setAccessible(true);
                restTemplateField.set(exchangeService, new RestTemplateTestImpl());
            }
            exchangeServiceField.set(totalHandler, exchangeService);
        }
        totalHandler.handleRequest("total EUR");

        Field resultField = totalHandler.getClass().getDeclaredField("result");
        if (Objects.nonNull(resultField)) {
            resultField.setAccessible(true);
            String result = (String) resultField.get(totalHandler);
            assertEquals("31,69", result);
        }
    }
}
