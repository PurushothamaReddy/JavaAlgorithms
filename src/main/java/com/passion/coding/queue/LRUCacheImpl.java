package com.passion.coding.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCacheImpl {
    int capacity;
    Queue<Integer> queue;
    Map<Integer,Integer> map;

    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
        map = new HashMap<>();
    }

    public Integer get(Integer key){
        return map.get(key);
    }

    public void insert(Integer key, Integer value) {
        if(map.containsKey(key)){
            queue.remove(key);
        }
        if(map.size()> capacity){
            int extraKey= queue.poll();
            map.remove(extraKey);
        }
        queue.add(key);
        map.put(key,value);
    }
}
