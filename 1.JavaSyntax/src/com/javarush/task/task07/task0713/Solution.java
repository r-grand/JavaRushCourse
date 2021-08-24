package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> generalList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            generalList.add(Integer.parseInt(reader.readLine()));
        }

        ArrayList<Integer> multiple3 = new ArrayList<>();
        for (int x3 : generalList) {
            if (x3 % 3 == 0)
            multiple3.add(x3);
        }
        printList(multiple3);

        ArrayList<Integer> multiple2 = new ArrayList<>();
        for (int x2 : generalList) {
            if (x2 % 2 == 0)
            multiple2.add(x2);
        }
        printList(multiple2);

        ArrayList<Integer> notMultiple2and3 = new ArrayList<>();
        for (int x2x3 : generalList) {
            if (x2x3 % 2 != 0 && x2x3 % 3 != 0)
            notMultiple2and3.add(x2x3);
        }
        printList(notMultiple2and3);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int print : list) {
            System.out.println(print);
        }
    }
}
