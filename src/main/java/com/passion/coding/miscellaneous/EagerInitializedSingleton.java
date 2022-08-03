package com.passion.coding.miscellaneous;

public class EagerInitializedSingleton {
    
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
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