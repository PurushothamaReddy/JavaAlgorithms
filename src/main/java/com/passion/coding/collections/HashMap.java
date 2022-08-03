package com.passion.coding.collections;

import java.util.Objects;

public class HashMap<K, V> {

    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4; // 16
    int size = 0;

    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    public HashMap(int capacity) {
        this.buckets = new Entry[capacity];
    }

    static class Entry<K, V> {
        K key;
        V value;
        int hash;// can be used during resize instead of recalculating hash
        Entry<K, V> next;

        public Entry(K key, V value, int hash, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return key.equals(entry.key) && value.equals(entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, key.hashCode(), null);
        int bucketIndex = key.hashCode() % bucketSize();
        Entry<K, V> existing = buckets[bucketIndex];
        if (existing == null) {
            buckets[bucketIndex] = entry;
            size++;
        } else {
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }
            existing.next = entry;
            size++;
        }


    }

    public V get(K key) {
        int bucketIndex = key.hashCode() % bucketSize();
        Entry<K, V> entry = buckets[bucketIndex];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public int bucketSize() {
        return buckets.length;
    }

    public int size() {
        return size;
    }
}
