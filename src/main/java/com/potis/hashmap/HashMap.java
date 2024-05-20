/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.potis.hashmap;

import java.util.Iterator;

/**
 *
 * @author Potis
 */
public class HashMap<K, V> implements Dictionary<K, V> {
    // Array to store the key-value pairs
    private Entry<K, V>[] table;
    // Constant for empty or deleted cells in the table
    private final Entry<K, V> DEFUNCT = new Entry<>(null, null);
    // Object of the hash function class
    private HashFunction<K> hashFunction;
    // Size of the table
    private int size;

    public HashMap(int size) {
        this.size = size;
        table = new Entry[size];
        hashFunction = new HashFunction<>(size);
    }
    
    // Count of elements in the table
    private int elementCount;
    
    // Add a key-value pair to the table
    @Override
    public void put(K key, V value) {
        checkResize();
        int hash = hashFunction.hash(key);
        int index;
        index = hash % size;
        int collisions = 0;
        // Iterate through the table until an empty cell is found
    while (table[index] != null && table[index] != DEFUNCT) {
        // If the table is full, throw an exception
        if (collisions >= size) {
            throw new IllegalStateException("Table is full");
        }
        // If the key already exists in the table, update its value
        if(table[index].getKey().equals(key)){
            table[index] = new Entry<>(key, value);
            return;
        }
        // Move to the next cell using linear probing
        index = (index + 1) % size;
        collisions++;
    }
    // Add the key-value pair to the table
    table[index] = new Entry<>(key, value);
    elementCount++;
}
    
    // Remove a key-value pair from the table
    @Override
    public V remove(K key) {
        checkResize();
        int hash = hashFunction.hash(key);
        int index = hash;
        int collisions = 0;
        // Iterate through the table until the key is found or an empty cell is reached
        while (table[index] != null) {
            if (table[index] != DEFUNCT && table[index].getKey().equals(key)) {
                V value = table[index].getValue();
                table[index] = DEFUNCT;
                elementCount--;
                return value;
            }
            if (collisions >= size) {
                return null;
            }
            index = (index + 1) % size;
            collisions++;
        }
        // If the key is not found, return null
        return null;
    }
    
    // Resize the table to the new size(bigger size)
     private void expandTable() {
        Entry<K, V>[] oldTable = table;
        size = size * 2;
        table = new Entry[size];
        hashFunction = new HashFunction<>(size);
        for (Entry<K, V> entry : oldTable) {
            if (entry != null && entry != DEFUNCT) {
                put(entry.key, entry.value);
            }
        }
    }

    // Resize the table to the new size(smaller size)
    private void contractTable() {
        Entry<K, V>[] oldTable = table;
        size = size / 2;
        table = new Entry[size];
        hashFunction = new HashFunction<>(size);
        for (Entry<K, V> entry : oldTable) {
            if (entry != null && entry != DEFUNCT) {
                put(entry.key, entry.value);
            }
        }
    }
    
    // Check if the table needs to be resized and resize if necessary
    private void checkResize() {
        if (elementCount >= size * 0.75) {
            expandTable();
        } else if (elementCount <= size * 0.25) {
            contractTable();
        }
    }
    
@Override
    public boolean contains(K key) {
        return get((String) key) != null;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if (table[i] != null && table[i] != DEFUNCT) {
                return false;
            }
        }
        return true;
    }
    
    // Get the number of elements in the table
    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (table[i] != null && table[i] != DEFUNCT) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            table[i] = null;
        }
    }
    
    @Override
    public Integer get(String word) {
        int hash = hashFunction.hash((K) word);
        int index = hash % size;
        int collisions = 0;
        while (table[index] != null && table[index] != DEFUNCT) {
            if (table[index].key.equals(word)) {
                return (Integer)table[index].value;
            }
            if (collisions >= size) {
                return null;
            }
            index = (index + 1) % size;
            collisions++;
        }
        return null;
    }
    
    

    @Override
    public void putW(String word, Integer curFreq) {
        put((K) word, (V) curFreq);
    }
    
    // Get the value associated with a key
    @Override
    public V getK(K key) {
        int hash = hashFunction.hash(key);
        int index = hash;
        int collisions = 0;
        // Iterate through the table until the key is found or an empty cell is reached
        while (table[index] != null && table[index] != DEFUNCT) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            if (collisions >= size) {
                return null;
            }
            index = (index + 1) % size;
            collisions++;
        }
        // If the key is not found, return null
        return null;
    }

    @Override
    public void put(String word, String curFreq) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @return
     */
    // Implement an iterator for the table
    @Override
    public Iterator<Dictionary.Entry<K, V>> iterator() {
        return new HashMapDictionaryLinearProbingIterator();
    }

    private class HashMapDictionaryLinearProbingIterator implements Iterator<Dictionary.Entry<K, V>> {
        int index = 0;
        
        public HashMapDictionaryLinearProbingIterator() {
            this.index = 0;
        }

        /*public HashMapDictionaryLinearProbingIterator() {
        }*/
        

        @Override
        public boolean hasNext() {
            while (index < size && (table[index] == null || table[index] == DEFUNCT)) {
                index++;
            }
            return index < size;
        }

        @Override
        public Entry<K, V> next() {
            return table[index++];
        }
    }

    private static class Entry<K, V> implements Dictionary.Entry<K, V> {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }
}
