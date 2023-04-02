package com.passion.coding.vendingmachine;

public enum Coin {
    ONERUPEE(1), FIVERUPEE(5), TENRUPEE(10), FIFTYRUPEE(50), HUNDREDRUPEE(100);


    private int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
