package com.javarush.task.task32.task3204;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println("Please press \"Enter\" to generate a new password");
        System.out.println("To exit the program, type \"exit\" and press \"Enter\"");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!"exit".equals(s = reader.readLine())) {
            long start = System.currentTimeMillis();
            System.err.println(getPassword());
            System.out.println("Password generated in " + (System.currentTimeMillis() - start) + " ms");
            System.out.println("\nPlease press \"Enter\" to generate a new password");
            System.out.println("To exit the program, type \"exit\" and press \"Enter\"");
        }
    }
    
    public static ByteArrayOutputStream getPassword() {
        byte[] array = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 0; i < 8; i++) {
            baos.write(array[(int) (Math.random() * 62)]);
        }
        int digit = 0;
        int upper = 0;
        int lower = 0;
        for (char c : baos.toString().toCharArray()) {
            if (Character.isDigit(c)) digit++;
            if (Character.isUpperCase(c)) upper++;
            if (Character.isLowerCase(c)) lower++;
        }
        if (digit > 0 && upper > 0 && lower > 0) {
            return baos;
        } else {
            return getPassword();
        }
    }
}
