package com.dpk.common;

public class Hexadecimal {

    public static int convertToDecimal(String hex) {
        int number = 0;
        for(int i=0; i< hex.length(); i++) {
            char ch = hex.charAt(i);
            number = number * 16 + Character.digit(ch, 16);
        }

        return number;
    }

    public static void main(String[] args) {
        String hex1 = "1AB";
        String hex2 = "1A";
        int dec1 = convertToDecimal(hex1);
        int dec2 = convertToDecimal(hex2);
        System.out.println(hex1 + " in decimal is " + dec1);
        System.out.println(hex2 + " in decimal is " + dec2);
    }
}
