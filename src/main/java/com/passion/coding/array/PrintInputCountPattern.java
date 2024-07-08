package com.passion.coding.array;

public class PrintInputCountPattern {

    private static void print(String str) {
        int zeroCounter = 0;
        int spaceCounter = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == '0') {
                zeroCounter++;
                if (spaceCounter > 0) {
                    sb.append("%" + spaceCounter + "s");
                    spaceCounter = 0;
                }
            } else {
                spaceCounter++;
                if (zeroCounter > 0) {
                    sb.append("%" + (zeroCounter > 9 ? zeroCounter : "0" + zeroCounter) + "d");
                    zeroCounter = 0;
                }
            }
        }

        if (spaceCounter > 0) {
            sb.append("%" + spaceCounter + "s");
        }
        if (zeroCounter > 0) {
            sb.append("%" + (zeroCounter > 9 ? zeroCounter : "0" + zeroCounter) + "d");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String str = "00  00     00 ";
        //%02d%2s%02d%5s%02d%1s

        String str2 = "000000000000              000    0    0000";
        //%12d%14s%03d%4s%01d%4s%04d

                print(str2);

    }
}
