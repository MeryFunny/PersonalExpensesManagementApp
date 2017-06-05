package com.mariazgoba.services;

import com.mariazgoba.model.Currency;
import com.mariazgoba.model.Expense;
import com.mariazgoba.rest.impl.RestTemplateImpl;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

public class ExchangeService {


    private Currency json;
    private com.mariazgoba.rest.RestTemplate restTemplate;

    public ExchangeService() {
        restTemplate = new RestTemplateImpl();
    }

    private static double getCurrencyValue(String currency, Currency json) {
        return json.getRates().get(currency);
    }

    public void retrieveRate(String baseCurrency) {
        String url = "http://api.fixer.io/latest?base=" + baseCurrency;
        try {
            this.json = (Currency) restTemplate.getCurrency(url);
        } catch (HttpStatusCodeException e) {
            int statusCode = e.getStatusCode().value();
            System.out.println("ERROR! HTTP problem. Code: " + statusCode);
            e.getStackTrace();
        }
    }

    public List<Expense> exchangeToBaseCurrency(String baseCurrency, List<Expense> expenses) {
        retrieveRate(baseCurrency);
        for (int i = 0; i < expenses.size(); i++) {
            if (!baseCurrency.equals(expenses.get(i).getCurrency())) {
                expenses.get(i).setPrice((expenses.get(i).getPrice()) / (getCurrencyValue(expenses.get(i).getCurrency(), this.json)));
            } else continue;
        }
        return expenses;
    }
}
