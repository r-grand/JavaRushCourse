package com.javarush.task.task19.task1909;

import java.io.*;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        
        while (reader.ready()) {
            int symbol = reader.read();
            if (symbol != 46) {
                writer.write(symbol);
            } else {
                writer.write(33);
            }
        }
        writer.close();
        reader.close();
    }
}
