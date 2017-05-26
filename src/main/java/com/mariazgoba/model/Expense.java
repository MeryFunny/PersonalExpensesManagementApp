package com.mariazgoba.model;

public class Expense {
    private int id;
    private String date;
    private double price;
    private String currency;
    private String name;

    public Expense(int id, String date, double price, String currency, String name) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.currency = currency;
        this.name = name;
    }

    public Expense(String date, double price, String currency, String name) {
        this.date = date;
        this.price = price;
        this.currency = currency;
        this.name = name;
    }

    public Expense() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return date + "\n" + price + " " + currency + " " + name;
    }
}
