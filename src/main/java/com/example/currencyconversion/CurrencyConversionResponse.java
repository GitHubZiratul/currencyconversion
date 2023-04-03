package com.example.currencyconversion;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyConversionResponse {
    private double result;

    public CurrencyConversionResponse(@JsonProperty("result") double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
