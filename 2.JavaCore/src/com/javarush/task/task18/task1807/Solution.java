package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream((new Scanner(System.in)).nextLine());
        int count = 0;
        while (fis.available() > 0) {
            if (fis.read() == 44) count++;
        }
        fis.close();
        System.out.println(count);
    }
}
