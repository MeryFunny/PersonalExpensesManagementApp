package com.mariazgoba.rest.impl;

import com.mariazgoba.model.Currency;
import com.mariazgoba.rest.RestTemplate;

public class RestTemplateImpl extends org.springframework.web.client.RestTemplate implements RestTemplate<com.mariazgoba.model.Currency> {
    @Override
    public Currency getCurrency(String url) {
        return getForObject(url, Currency.class);
    }
}
