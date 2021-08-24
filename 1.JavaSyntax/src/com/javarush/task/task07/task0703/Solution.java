package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String[10];
        for (int i = 0; i < 10; i++) {
            strings[i] = reader.readLine();
        }
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = strings[i].length();
            System.out.println(ints[i]);
        }
    }
}
