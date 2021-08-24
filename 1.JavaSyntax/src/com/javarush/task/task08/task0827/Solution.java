package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        SimpleDateFormat countDayOfYear = new SimpleDateFormat("D", Locale.ENGLISH);
        String number = null;

        try {
            Date d = formatter.parse(date);
            number = (countDayOfYear.format(d));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        int iNumber = Integer.parseInt(number);

        boolean check;
        if (iNumber % 2 == 0)
            check = false;
        else check = true;

        return check;
    }
}
