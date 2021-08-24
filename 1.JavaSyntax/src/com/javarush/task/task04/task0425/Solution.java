package com.javarush.task.task04.task0425;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaGrammar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Цель установлена!
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        if (a > 0 && b > 0)
            System.out.println(1);
        if (a < 0 && b > 0)
            System.out.println(2);
        if (a < 0 && b < 0)
            System.out.println(3);
        if (a > 0 && b < 0)
            System.out.println(4);
    }
}