/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.potis.hashmap;

import java.util.Random;

/**
 *
 * @author Potis
 */
public class HashFunction<K> {

    private int[][] arrayRandomBits;
    private int[] bitArrayKey;
    private final int u = 32;
    private int b;

    public HashFunction(int b) {
        // b must be a power of 2
        if (!isPowerOfTwo(b)) {
            throw new IllegalArgumentException("b must be a power of 2");
        }
        this.b = b;
        // Create an array of random bits with the size of b*u
        arrayRandomBits = new int[this.b*this.u][this.u];
        bitArrayKey = new int[this.u];
        // Fill the array with random 0 or 1
        for (int i = 0; i < this.b; i++) {
            for (int j = 0; j < this.u; j++) {
                arrayRandomBits[i][j] = new Random().nextInt(2);
            }
        }
    }

    public int hash(K key) {
        bitArrayKey = transformKeyToBits(key);
        int[][] result = new int[b][u];
        int newKey = 0;
        // Perform the dot product between the array of random bits and the array of bits of the key
        // and calculate the new hash
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < u; j++) {
                result[i][j] += arrayRandomBits[i][j] * bitArrayKey[j];
                result[i][j] = result[i][j] %2;
                newKey =(int) (newKey + result[i][j] * Math.pow( 2, i )) % b;
            }
        }      
        return newKey;
    }
    
    public void updateTableSize(int newSize) {
        // newSize must be a power of 2
        if (!isPowerOfTwo(newSize)) {
            throw new IllegalArgumentException("newSize must be a power of 2");
        }
        this.b = newSize;
        arrayRandomBits = new int[this.b][this.u];
        // Fill the array with random 0 or 1
        for (int i = 0; i < this.b; i++) {
            for (int j = 0; j < this.u; j++) {
                arrayRandomBits[i][j] = new Random().nextInt(2);
            }
        }
    }

    private int[] transformKeyToBits(K key) {
        int numBits = Integer.numberOfLeadingZeros(key.hashCode());
        int[] bits = new int[this.u];
        int tmpKey = key.hashCode();
        // Transform the key to an array of bits
        for (int i = this.u - 1; i >= 0; i--) {
            if (i >= this.u - numBits) {
                bits[i] = 0;
            } else {
                bits[i] = tmpKey & 1;
                tmpKey = tmpKey >> 1;
            }
        }
        return bits;
    }

    private boolean isPowerOfTwo(int number) {
        // Check if a number is a powerof 2
        return (number & (number - 1)) == 0;
    }
}