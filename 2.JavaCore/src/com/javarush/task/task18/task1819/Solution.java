package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
*/

public class Solution {
	public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String fileName1 = reader.readLine();
	    String fileName2 = reader.readLine();
	    reader.close();
        List<Integer> buffer = new ArrayList<>();
        FileInputStream fis = new FileInputStream(fileName1);
        while (fis.available() > 0) {
        	buffer.add(fis.read());
		}
		fis.close();
		fis = new FileInputStream(fileName2);
        FileOutputStream fos = new FileOutputStream(fileName1);
        int buf;
        while (fis.available() > 0 ) {
        	buf = fis.read();
        	fos.write(buf);
		}
        fis.close();
        for (int temp : buffer) {
            fos.write(temp);
        }
        fos.close();
	}
}
