package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newFormatter = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);

        Date date = formatter.parse(s);
        String newFormatDate = newFormatter.format(date).toUpperCase(Locale.ROOT);
        System.out.println(newFormatDate);
    }
}
