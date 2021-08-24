package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(labels);
    }
    
    static {
        labels.put(0.1, "одна десятая");
        labels.put(1.2, "один и два");
        labels.put(2.3, "два и три");
        labels.put(3.4, "три и четыре");
        labels.put(-0.9, "минус девять десятых");
    }
}
