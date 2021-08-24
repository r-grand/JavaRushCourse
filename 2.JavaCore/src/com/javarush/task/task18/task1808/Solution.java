package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //кладем данные в строку
        StringBuilder sb = new StringBuilder();
        sb.append("Lena").append('\n').append("Olya").append('\n').append("Anya").append('\n');
        String data = sb.toString();
        System.out.println(data);
        
        //Оборачиваем строку в класс ByteArrayInputStream
        InputStream is = new ByteArrayInputStream(data.getBytes());
        
        //подменяем in
        System.setIn(is);
        
        //вызываем обычный метод, который не подозревает о наших манипуляциях
        readAndPrintLine();
    }
    
    public static void readAndPrintLine() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        
        while (true)
        {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        reader.close();
        isr.close();
    }
}
