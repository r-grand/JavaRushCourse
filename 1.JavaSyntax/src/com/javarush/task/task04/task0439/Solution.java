package com.javarush.task.task04.task0439;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Письмо счастья
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int i = 0;
        for (String text = " любит меня."; i < 10; i++) {
            System.out.println(s + text);
        }
    }
}
