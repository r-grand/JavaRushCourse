package com.javarush.task.task10.task1012;

/*
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Integer a = 5;
        Integer b = 5;
        Integer c = null;
        try {
            c = new Integer(null);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Integer y = 5;


        System.out.println(a == b);
        System.out.println(c.equals(null));
        System.out.println(c == y);
    }
}
