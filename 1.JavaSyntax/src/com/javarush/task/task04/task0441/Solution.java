package com.javarush.task.task04.task0441;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Как-то средненько
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bufferedReader.readLine());
        int y = Integer.parseInt(bufferedReader.readLine());
        int z = Integer.parseInt(bufferedReader.readLine());
        if (x < y && y < z || x == y || x > y && y > z)
            System.out.println(y);
        else if (y < x && x < z || z == x || y > x && x > z)
            System.out.println(x);
        else if (y < z && z < x || y == z || y > z && z > x)
            System.out.println(z);
    }
}
