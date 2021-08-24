package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a1 = Integer.parseInt(reader.readLine());
        int a2 = Integer.parseInt(reader.readLine());
        int a3 = Integer.parseInt(reader.readLine());
        int a4 = Integer.parseInt(reader.readLine());
        int a5 = Integer.parseInt(reader.readLine());
        int[] firstArray = {a1, a2, a3, a4, a5};
        Arrays.sort(firstArray, 0, 5);
        System.out.println(firstArray[0]);
        System.out.println(firstArray[1]);
        System.out.println(firstArray[2]);
        System.out.println(firstArray[3]);
        System.out.println(firstArray[4]);
    }
}
