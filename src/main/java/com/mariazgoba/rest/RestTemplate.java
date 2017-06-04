package com.mariazgoba.rest;

import org.springframework.web.client.RestOperations;

public interface RestTemplate<T> extends RestOperations {
    T getCurrency(String url);
}
