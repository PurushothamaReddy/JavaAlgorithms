package com.passion.coding.vendingmachine;

public interface VendingMachine {
    public abstract int selectItemAndGetPrice(Product product) throws ProductNotFoundException;
    public abstract void insertCoins(Coin... coins) throws NotFullyPaidException;

    public abstract Bucket getItemAndDisplayChange(int coinValue);

}
