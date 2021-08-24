package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flagStop = false;
        String fileName;
        do {
            fileName = reader.readLine();
            try (FileReader fr = new FileReader(fileName)) {
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                flagStop = true;
            }
        }
        while (!flagStop);
        reader.close();
    }
}
