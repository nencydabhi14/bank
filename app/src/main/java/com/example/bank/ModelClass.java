package com.example.bank;

public class ModelClass {

        String amount;
        String data;
        String income;

    public ModelClass(String amount, String data, String incom) {
        this.amount = amount;
        this.data = data;
        this.income = incom;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
