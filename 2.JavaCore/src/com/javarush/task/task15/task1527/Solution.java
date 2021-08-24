package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] subStrings = url.split("\\?", 2);
        String parameters = subStrings[1];
        String[] subParameters = parameters.split("&");
        String check = null;
        for (String strings : subParameters) {
            String[] keyValue = strings.split("=");
            System.out.print(keyValue[0] + " ");
            if (keyValue[0].equals("obj"))
                check = keyValue[1];
        }
        if (check != null) {
            System.out.println();
            try {
                double value = Double.parseDouble(check);
                alert(value);
            } catch (NumberFormatException e) {
                alert(check);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
