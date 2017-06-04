package stub.rest;

import com.mariazgoba.model.Currency;
import com.mariazgoba.rest.RestTemplate;

import java.util.HashMap;

public class RestTemplateTestImpl extends org.springframework.web.client.RestTemplate implements RestTemplate {
    @Override
    public Currency getCurrency(String url) {
        Currency currency = new Currency();
        currency.setBase("EUR");
        currency.setRates(rates());
        return currency;
    }

    private HashMap<String, Double> rates() {
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("CHF", 1.0893);
        rates.put("HRK", 7.4113);
        rates.put("MXN", 20.898);
        rates.put("ZAR", 14.437);
        rates.put("INR", 72.28);
        rates.put("CNY", 7.6507);
        rates.put("THB", 38.306);
        rates.put("AUD", 1.5173);
        rates.put("ILS", 3.9938);
        rates.put("KRW", 1260.0);
        rates.put("JPY", 125.02);
        rates.put("PLN", 4.1925);
        rates.put("GBP", 0.87268);
        rates.put("IDR", 14931.0);
        rates.put("HUF", 308.45);
        rates.put("PHP", 55.553);
        rates.put("TRY", 3.9601);
        rates.put("RUB", 63.462);
        rates.put("HKD", 8.7413);
        rates.put("DKK", 7.4392);
        rates.put("CAD", 1.5169);
        rates.put("MYR", 4.8014);
        rates.put("USD", 1.1217);
        rates.put("BGN", 1.9558);
        rates.put("NOK", 9.4918);
        rates.put("RON", 4.5653);
        rates.put("SGD", 1.5552);
        rates.put("CZK", 26.36);
        rates.put("SEK", 9.7433);
        rates.put("NZD", 1.5811);
        rates.put("BRL", 3.6308);
        return rates;
    }
}
