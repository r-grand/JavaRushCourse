package com.javarush.task.task13.task1318;

import java.io.*;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(reader.readLine());
        int i;
        
        while ((i = fin.read()) != -1) {
            System.out.print((char) i);
        }
    
        reader.close();
        fin.close();
    }
}