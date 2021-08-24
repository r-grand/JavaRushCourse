package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        int minn = -1;
        int maxx = -1;

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() < min) {
                min = strings.get(i).length();
                minn = i;
            }
        }
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() > max) {
                max = strings.get(i).length();
                maxx = i;
            }
        }

        if (minn < maxx)
            System.out.println(strings.get(minn));
        if (maxx < minn)
            System.out.println(strings.get(maxx));
    }
}
