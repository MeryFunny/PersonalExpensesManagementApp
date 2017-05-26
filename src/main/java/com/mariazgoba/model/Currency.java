package com.mariazgoba.model;

import java.util.Date;
import java.util.HashMap;

public class Currency {
    String base;
    Date date;
    HashMap<String, Double> rates;

    public Currency() {
    }

    public Currency(String base, Date date, HashMap<String, Double> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HashMap<String, Double> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Currency [base=" + base + ", date=" + date + ", rates=" + rates + "]";
    }

    public void addRate(String key, Double value) {
        rates.put(key, value);
    }
}
