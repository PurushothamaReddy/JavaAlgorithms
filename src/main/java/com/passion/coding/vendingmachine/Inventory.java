package com.passion.coding.vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory<K, V> {
    private Map<K, V> map = new HashMap<>();

    public V getItem(K key) {
        return map.get(key);
    }
    public void putInventory(K key, V value) {
        map.put(key, value);
    }
    public Map<K, V> getInventory() {
        return map;
    }
    public boolean hasItem(K key) {
        return map.containsKey(key);
    }
}
