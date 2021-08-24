package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String subString;
        try {
            int firstTab = string.indexOf("\t");
            int secondTab = string.indexOf("\t", firstTab + 1);
            subString = string.substring(firstTab + 1, secondTab);
        } catch (Exception e) {
            throw new TooShortStringException();
        }
        return subString;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
