package com.passion.coding.vendingmachine;

import java.util.Arrays;
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
    public Bucket insertCoins(Coin... coins) throws NotFullyPaidException {
        List<Integer> totalList = Arrays.asList(coins).stream().map(c -> c.getValue()).collect(Collectors.toList());
        int totalValue = totalList.stream().reduce(Integer::sum).get();
        if (totalValue < currentItem.getItemPrice()) {
            throw new NotFullyPaidException();
        } else {
            return getItemAndDisplayChange(totalValue);
        }
    }

    @Override
    public Bucket getItemAndDisplayChange(int insertedValue) {
        this.addToCashInventory(insertedValue);
        this.setCurrentBalance();
//        int changedValue = this.getChanged(insertedValue, (int) this.currentItem.getItemPrice());
//        this.substractChangedFromInventory(changedValue);
//        this.currentBalance = this.currentBalance-changedValue;
//        this.removedItemFromInventory();
//        ArrayList<Coin> coins = new ArrayList<Coin>();
//         //https://medium.com/@mkbhuktar/design-vending-machine-in-java-c566f4820844
//
//        return new Bucket(this.currentItem, this.convertToCoin(new ArrayList<Coin>(),changedValue));

        return null;
    }

    private int putCoinAndIncreament(Coin coin, int insertedValue) {
        int remainder = insertedValue % coin.getValue();
        int numOfCoins = this.cashInventory.getInventory().get(coin);
        this.cashInventory.putInventory(coin, (numOfCoins + remainder));
        return (insertedValue - (remainder * coin.getValue()));
    }

    private void addToCashInventory(int insertedCoinValue){
        if(insertedCoinValue>=Coin.HUNDREDRUPEE.getValue()){
            int test = this.putCoinAndIncreament(Coin.HUNDREDRUPEE, insertedCoinValue);
            if(test!=0){
                addToCashInventory(test);
            }
        }else if(insertedCoinValue>=Coin.FIVERUPEE.getValue()){
            int test = this.putCoinAndIncreament(Coin.FIVERUPEE, insertedCoinValue);
            if(test!=0){
                addToCashInventory(test);
            }
        }else if(insertedCoinValue>=Coin.TENRUPEE.getValue()){
            int test = this.putCoinAndIncreament(Coin.TENRUPEE, insertedCoinValue);
            if(test!=0){
                addToCashInventory(test);
            }
        }else if(insertedCoinValue>=Coin.ONERUPEE.getValue()){
            int test = this.putCoinAndIncreament(Coin.ONERUPEE, insertedCoinValue);
            if(test!=0){
                addToCashInventory(test);
            }
        }
    }
}
