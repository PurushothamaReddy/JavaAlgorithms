package com.passion.coding.miscellaneous;

public class EagerInitializedSingleton {
    
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    //https://www.geeksforgeeks.org/java-program-to-demonstrate-the-double-check-locking-for-singleton-class/
    // Double-checked locking singleton impl
    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){
        if(instance == null){
            System.out.println("Instance is null");
        } else {
            System.out.println("instance is not null");
        }
    }

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {

    }
}