package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        FileInputStream fis = new FileInputStream(fileName);
        int result = Integer.MIN_VALUE;
        while (fis.available() > 0) {
            int read = fis.read();
            if (read > result) {
                result = read;
            }
        }
        fis.close();
        System.out.println(result);
    }
}
