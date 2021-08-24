package com.javarush.task.task04.task0428;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bufferedReader.readLine());
        int y = Integer.parseInt(bufferedReader.readLine());
        int z = Integer.parseInt(bufferedReader.readLine());
        boolean a = (x > 0);
        boolean b = (y > 0);
        boolean c = (z > 0);
        if (a && b && c)
            System.out.println(3);
        if (a && !b && c)
            System.out.println(2);
        if (a && b && !c)
            System.out.println(2);
        if (!a && b && c)
            System.out.println(2);
        if (!a && !b && c)
            System.out.println(1);
        if (!a && b && !c)
            System.out.println(1);
        if (a && !b && !c)
            System.out.println(1);
        if (!a && !b && !c)
            System.out.println(0);
    }
}
