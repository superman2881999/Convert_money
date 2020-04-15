package com.example.convert_money;

public class SpinnerModel1 {
     String symbol;
     double value;

    public SpinnerModel1(String symbol, double value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    public double getRate(SpinnerModel1 spinnerModel1){
        return this.value/spinnerModel1.value;
    }
}
