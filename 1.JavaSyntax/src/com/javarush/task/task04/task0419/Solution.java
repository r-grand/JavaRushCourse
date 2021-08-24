package com.javarush.task.task04.task0419;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Максимум четырех чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader min = new BufferedReader(new InputStreamReader(System.in));
        int iMax1 = Integer.parseInt(min.readLine());
        int iMax2 = Integer.parseInt(min.readLine());
        int iMax3 = Integer.parseInt(min.readLine());
        int iMax4 = Integer.parseInt(min.readLine());
        int x;
        int y;

        if (iMax1 >= iMax2)
            x = iMax1;
        else x = iMax2;
        if (iMax3 >= iMax4)
            y = iMax3;
        else y = iMax4;

        if (x > y)
            System.out.println(x);
        if (y > x)
            System.out.println(y);
        if (x == y)
            System.out.println(x);
    }
}
