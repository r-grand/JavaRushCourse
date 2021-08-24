package com.javarush.task.task04.task0420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Сортировка трех чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int ch1 = Integer.parseInt(b.readLine());
        int ch2 = Integer.parseInt(b.readLine());
        int ch3 = Integer.parseInt(b.readLine());

        if (ch1 >= ch2 && ch2 >= ch3)
            System.out.println(ch1 + " " + ch2 + " " + ch3);
        else if (ch1 >= ch3 && ch3 >= ch2)
            System.out.println(ch1 + " " + ch3 + " " + ch2);
        else if (ch2 >= ch1 && ch1 >= ch3)
            System.out.println(ch2 + " " + ch1 + " " + ch3);
        else if (ch2 >= ch3 && ch3 >= ch1)
            System.out.println(ch2 + " " + ch3 + " " + ch1);
        else if (ch3 >= ch1 && ch1 >= ch2)
            System.out.println(ch3 + " " + ch1 + " " + ch2);
        else if (ch3 >= ch2 && ch2 >= ch1)
            System.out.println(ch3 + " " + ch2 + " " + ch1);
    }
}
