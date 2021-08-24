package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {
        try {                                           // 1
            float f = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                                           // 2
            String s = null;
            String test = "test";
            s.equals(test);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                                           // 3
            String test = "test";
            int i = Integer.parseInt(test);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                                           // 4
            int[] ints = new int[2];
            int i;
            for (int j = 0; j < 3; j++) {
                i = ints[j];
            }
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                                           // 5
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(5);
            int b;
            for (int i = 0; i < 2; i++) {
                b = integers.get(i);
            }
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                                           // 6
            Object object = new Object();
            object.notify();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                                           // 7
            new FileInputStream("D:\\tst.txt");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                                           // 8
            File file = new File("C:\\Windows\\System\\1.txt");
            file.createNewFile();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                                           // 9
            Object o = "o";
            int[] ints = (int[]) o;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                                           // 10
            Object[] x = new String[3];
            x[0] = new Integer(0);
        } catch (Exception e) {
            exceptions.add(e);
        }

    }
}
