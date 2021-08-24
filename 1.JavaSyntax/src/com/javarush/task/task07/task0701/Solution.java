package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrayTemp = new int[20];
        for (int i = 0; i < 20; i++) {
            arrayTemp[i] = Integer.parseInt(reader.readLine());
        }
        return arrayTemp;
    }

    public static int max(int[] array) {
        int maxTemp = Integer.MIN_VALUE;
        for (int i = 0; i < 20; i++) {
            if (array[i] > maxTemp)
                maxTemp = array[i];
        }
        return maxTemp;
    }
}
