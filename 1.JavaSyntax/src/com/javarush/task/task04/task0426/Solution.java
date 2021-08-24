package com.javarush.task.task04.task0426;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Ярлыки и числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(bufferedReader.readLine());
        int x = i % 2;
        if (i < 0 && x == 0)
            System.out.println("отрицательное четное число");
        if (i < 0 && x != 0)
            System.out.println("отрицательное нечетное число");
        if (i == 0)
            System.out.println("ноль");
        if (i > 0 && x != 1)
            System.out.println("положительное четное число");
        if (i > 0 && x == 1)
            System.out.println("положительное нечетное число");
    }
}
