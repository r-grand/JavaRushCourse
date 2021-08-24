package com.javarush.task.task19.task1906;

import java.io.*;

/* 
Четные символы
*/

public class Solution {
	public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName1 = reader.readLine();
		String fileName2 = reader.readLine();
		reader.close();
		FileReader fr = new FileReader(fileName1);
		FileWriter fw = new FileWriter(fileName2);
		
		while (fr.ready()) {
			fr.read();
			int even = fr.read();
			fw.write(even);
		}
		
		fw.close();
        fr.close();
    }
}
