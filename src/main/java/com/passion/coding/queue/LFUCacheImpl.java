package com.passion.coding.queue;

import java.util.HashMap;
import java.util.Map;

//https://algodaily.com/lessons/implement-an-lfu-cache/java
public class LFUCacheImpl {

    private Map<Integer, Integer> valueMap = new HashMap<>();
    private Map<Integer, Integer> countMap = new HashMap<>();
    private int capacity;

    public LFUCacheImpl(int capacity) {
        this.capacity = capacity;
    }

    public Integer get(int key) {

        if (!valueMap.containsKey(key)) {
            return -1;
        }
        countMap.put(key, countMap.get(key) + 1);
        return valueMap.get(key);
    }

    public void put(Integer key, Integer value) {
        if (valueMap.size() == capacity) {

            int min = Integer.MAX_VALUE;
            int lowestFreqKey = 0;
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() < min) {
                    min = entry.getValue();
                    lowestFreqKey = entry.getKey();
                }
            }

            valueMap.remove(lowestFreqKey);
            countMap.remove(lowestFreqKey);
        }

        if (valueMap.containsKey(key)) {
            countMap.put(key, countMap.get(key) + 1);
        } else {
            countMap.put(key, 1);
        }
        valueMap.put(key, value);
    }


    public void putLFU(Integer key, Integer value) {

        if (valueMap.size() >= capacity) {
            Integer minKey = countMap.entrySet().stream().min((e1, e2) -> e1.getValue().compareTo(e2.getValue())).get().getKey();
            valueMap.remove(minKey);
            countMap.remove(minKey);
        }
        if (valueMap.containsKey(key)) {
            countMap.put(key, countMap.get(key) + 1);
        } else {
            countMap.put(key, 1);
        }
        valueMap.put(key, value);
    }

    public Integer getLFU(Integer key) {
        if (!valueMap.containsKey(key)) {
            return -1;
        }
        countMap.put(key, countMap.get(key) + 1);
        return valueMap.get(key);
    }

}
