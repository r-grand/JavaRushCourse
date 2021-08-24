package com.javarush.task.task04.task0412;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительное и отрицательное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader i = new BufferedReader(new InputStreamReader(System.in));
        String sInt = i.readLine();
        int nInt = Integer.parseInt(sInt);
        if (nInt > 0)
            System.out.println(nInt * 2);
        if (nInt < 0)
            System.out.println(nInt + 1);
        if (nInt == 0)
            System.out.println(0);
    }

}