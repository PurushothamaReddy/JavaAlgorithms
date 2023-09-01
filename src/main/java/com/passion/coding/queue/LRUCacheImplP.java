package com.passion.coding.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCacheImplP {

    int capacity;
    Map<Integer, Integer> map;

    Queue<Integer> queue;

    public LRUCacheImplP(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
    }


    public void insert(Integer key,Integer value) {
        if(map.containsKey(key)) {
            queue.remove(key);
        }
        if(map.size() > capacity){
            map.remove(queue.poll());
        }
        queue.add(key);
        map.put(key, value);
    }

    public int get(int key) {
        return map.get(key);
    }
}
