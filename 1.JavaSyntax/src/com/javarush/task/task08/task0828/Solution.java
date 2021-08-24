package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        List<String> calendar = new ArrayList<>();
        calendar.add("January");
        calendar.add("February");
        calendar.add("March");
        calendar.add("April");
        calendar.add("May");
        calendar.add("June");
        calendar.add("July");
        calendar.add("August");
        calendar.add("September");
        calendar.add("October");
        calendar.add("November");
        calendar.add("December");

        for (int i = 0; i < calendar.size(); i++) {
            if (calendar.get(i).equals(month))
                System.out.println(month + " is the " + (i + 1) + " month");
        }
    }
}
