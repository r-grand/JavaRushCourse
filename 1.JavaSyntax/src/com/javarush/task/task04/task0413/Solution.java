package com.javarush.task.task04.task0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
День недели
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader day = new BufferedReader(new InputStreamReader(System.in));
        String sDay = day.readLine();
        int iDay = Integer.parseInt(sDay);
        if (iDay == 1)
            System.out.println("понедельник");
        if (iDay == 2)
            System.out.println("вторник");
        if (iDay == 3)
            System.out.println("среда");
        if (iDay == 4)
            System.out.println("четверг");
        if (iDay == 5)
            System.out.println("пятница");
        if (iDay == 6)
            System.out.println("суббота");
        if (iDay == 7)
            System.out.println("воскресенье");
        if (iDay < 1 || iDay > 8)
            System.out.println("такого дня недели не существует");
    }
}