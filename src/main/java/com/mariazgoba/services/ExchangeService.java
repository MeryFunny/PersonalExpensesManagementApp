package com.mariazgoba.services;

import com.mariazgoba.model.Currency;
import com.mariazgoba.model.Expense;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ExchangeService {

    private static RestTemplate restTemplate = new RestTemplate();
    private Currency json;
    private String baseCurrency;

    public ExchangeService(String baseCurrency) {
        this.baseCurrency = baseCurrency;
        String url = "http://api.fixer.io/latest?base=" + baseCurrency;
        try {
            this.json = restTemplate.getForObject(url, Currency.class);
        }catch (HttpStatusCodeException e){
            int statusCode = e.getStatusCode().value();
            System.out.println("ERROR! HTTP problem. Code: "+ statusCode);
            e.getStackTrace();
        }
    }

    private static double getCurrencyValue(String currency, Currency json) {
        return json.getRates().get(currency);
    }

    public List<Expense> exchangeToBaseCurrency(List<Expense> expenses) {

        for (int i = 0; i < expenses.size(); i++) {
            if (!this.baseCurrency.equals(expenses.get(i).getCurrency())) {
                expenses.get(i).setPrice((expenses.get(i).getPrice()) / (getCurrencyValue(expenses.get(i).getCurrency(), this.json)));

            } else continue;
        }
        return expenses;
    }

}
