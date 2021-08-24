package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        int[] crack = getInts();

        for (int i :
                crack) {
            if (i > maximum)
                maximum = i;
            if (i < minimum)
                minimum = i;
        }
        System.out.print(maximum + " " + minimum);
    }

    public static int[] getInts() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] temp = new int[20];
        for (int i = 0; i < 20; i++) {
            temp[i] = Integer.parseInt(reader.readLine());
        }
        return temp;
    }
}
