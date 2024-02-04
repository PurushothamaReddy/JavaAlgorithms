package com.passion.coding.miscellaneous;

import java.io.Serializable;

public class DoubleCheckedLockingSingleton implements Serializable, Cloneable {


    private static volatile DoubleCheckedLockingSingleton instance = null;

    private DoubleCheckedLockingSingleton() {
        if (instance == null) {
            System.out.println("Instance is null");
        } else {
            new InstantiationException("Instance already created exception");
        }
    }

    public static DoubleCheckedLockingSingleton getInstance1() {
        if (instance == null) {
            instance = new DoubleCheckedLockingSingleton();
        }
        return instance;
    }

    public static synchronized DoubleCheckedLockingSingleton getInstance2() {
        if (instance == null) {
            instance = new DoubleCheckedLockingSingleton();
        }
        return instance;
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }


// TO ensure same object is used during deserialization
    protected Object readResolve() {
        return instance;
    }
}
