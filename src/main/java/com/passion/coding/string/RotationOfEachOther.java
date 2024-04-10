package com.passion.coding.string;

public class RotationOfEachOther {

    private static boolean isRotationOfEachOther(final String original, final String rotation) {
        if(original.length() != rotation.length()){
            return false;
        }
        String temp = original + original;
        if (temp.indexOf(rotation) != -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRotationOfEachOther("IndiaVsEngland", "EnglandIndiaVs"));
    }
}
