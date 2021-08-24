package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] peoplesInStreetHomes = new int[15];

        for (int i = 0; i < 15; i++) {
            peoplesInStreetHomes[i] = Integer.parseInt(reader.readLine());
        }

        int odd = peoplesInStreetHomes[1] + peoplesInStreetHomes[3] + peoplesInStreetHomes[5] + peoplesInStreetHomes[7] + peoplesInStreetHomes[9] + peoplesInStreetHomes[11] + peoplesInStreetHomes[13];
        int even = peoplesInStreetHomes[0] + peoplesInStreetHomes[2] + peoplesInStreetHomes[4] + peoplesInStreetHomes[6] + peoplesInStreetHomes[8] + peoplesInStreetHomes[10] + peoplesInStreetHomes[12] + peoplesInStreetHomes[14];

        if (odd > even)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        if (odd < even)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        if (odd == even)
            System.out.println("В домах с четными номерами и нечетными номерами проживает одинаковое число жителей.");
    }
}