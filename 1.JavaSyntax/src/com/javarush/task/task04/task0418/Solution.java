package com.javarush.task.task04.task0418;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Минимум двух чисел Ӏ Java Syntax: 4 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader min = new BufferedReader(new InputStreamReader(System.in));
        int iMin1 = Integer.parseInt(min.readLine());
        int iMin2 = Integer.parseInt(min.readLine());

        if (iMin1 < iMin2)
            System.out.println(iMin1);
        if (iMin2 < iMin1)
            System.out.println(iMin2);
        if (iMin1 == iMin2)
            System.out.println(iMin1);
    }
}