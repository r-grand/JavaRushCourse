package com.javarush.task.task04.task0427;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Описываем числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String sInt = bufferedReader.readLine();
        int i = Integer.parseInt(sInt);
        int x = i % 2;
        int y = sInt.length();
        if (i > 0 && i < 1000 && x == 0 && y == 1)
            System.out.println("четное однозначное число");
        if (i > 0 && i < 1000 && x == 1 && y == 1)
            System.out.println("нечетное однозначное число");
        if (i > 0 && i < 1000 && x == 0 && y == 2)
            System.out.println("четное двузначное число");
        if (i > 0 && i < 1000 && x == 1 && y == 2)
            System.out.println("нечетное двузначное число");
        if (i > 0 && i < 1000 && x == 0 && y == 3)
            System.out.println("четное трехзначное число");
        if (i > 0 && i < 1000 && x == 1 && y == 3)
            System.out.println("нечетное трехзначное число");
    }
}
