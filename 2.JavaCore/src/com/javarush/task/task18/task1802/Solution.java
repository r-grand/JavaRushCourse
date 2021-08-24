package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        FileInputStream fis = new FileInputStream(fileName);
        int result = Integer.MAX_VALUE;
        while (fis.available() > 0) {
            int read = fis.read();
            if (read < result) {
                result = read;
            }
        }
        fis.close();
        System.out.println(result);
    }
}
