package com.javarush.task.task04.task0429;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительные и отрицательные числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bufferedReader.readLine());
        int y = Integer.parseInt(bufferedReader.readLine());
        int z = Integer.parseInt(bufferedReader.readLine());
        int countPlus = 0;
        int countMinus = 0;
        if (x > 0)
            countPlus++;
        else if (x < 0)
            countMinus++;
        if (y > 0)
            countPlus++;
        else if (y < 0)
            countMinus++;
        if (z > 0)
            countPlus++;
        else if (z < 0)
            countMinus++;
        System.out.println("количество отрицательных чисел: " + countMinus + ", количество положительных чисел: " + countPlus);
    }
}
