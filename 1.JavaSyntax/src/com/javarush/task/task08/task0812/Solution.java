package com.javarush.task.task08.task0812;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Самая длинная последовательность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        int first;
        int clone;
        int sum1 = 1;
        int sum2 = 1;
        int sum3 = 1;
        for (int i = 0; i < list.size(); i++) {
            first = list.get(i);
            if (i + 1 < list.size()) {
                clone = list.get(i + 1);
                if (first == clone) {
                    sum1++;
                } else {
                    sum2 = sum1;
                    sum1 = 1;
                    if (sum2 > sum3)
                        sum3 = sum2;
                }
            }
        }
        List<Integer> ready = new ArrayList<>();
        ready.add(sum1);
        ready.add(sum2);
        ready.add(sum3);
        Collections.sort(ready);

        System.out.println(ready.get(2));
    }
}
