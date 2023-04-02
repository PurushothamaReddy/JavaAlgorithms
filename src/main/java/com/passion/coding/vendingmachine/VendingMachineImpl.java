package com.passion.coding.vendingmachine;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VendingMachineImpl implements VendingMachine {
    private Inventory<Product, Integer> productInventory = new Inventory<>();
    private Inventory<Coin, Integer> cashInventory = new Inventory<>();
    private Product currentItem;
    private int currentBalance;

    public VendingMachineImpl() {
        initialise();
    }

    private void initialise() {
        this.productInventory.putInventory(new Product("COKE", 15), 10);
        this.productInventory.putInventory(new Product("PEPSI", 17), 20);
        this.productInventory.putInventory(new Product("LAYS", 10), 30);
        this.cashInventory.putInventory(Coin.ONERUPEE, 5);
        this.cashInventory.putInventory(Coin.FIVERUPEE, 10);
        this.cashInventory.putInventory(Coin.TENRUPEE, 20);
        this.cashInventory.putInventory(Coin.FIFTYRUPEE, 10);
        this.cashInventory.putInventory(Coin.HUNDREDRUPEE, 10);
        setCurrentBalance();
    }

    private void setCurrentBalance() {
        if (this.cashInventory.getInventory().size() > 0) {
            List<Integer> coinList = this.cashInventory.getInventory().entrySet().stream().map(e -> (e.getKey().getValue()) * e.getValue()).collect(Collectors.toList());
            this.currentBalance = coinList.stream().reduce(Integer::sum).get();
        }
    }

    @Override
    public int selectItemAndGetPrice(Product product) throws ProductNotFoundException {
        List<Map.Entry<Product, Integer>> productPrice = productInventory.getInventory().entrySet().stream().filter(e -> e.getKey().getItemName().equals(product.getItemName())).collect(Collectors.toList());
        if (productPrice.isEmpty()) {
            Product p1 = productPrice.get(0).getKey();
            this.currentItem = product;
            return p1.getItemPrice();
        } else {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public void insertCoins(Coin... coins) throws NotFullyPaidException {


    }

    @Override
    public Bucket getItemAndDisplayChange(int coinValue) {
        return null;
    }
}
