package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
	private static FileInputStream fis;
	private static FileOutputStream fos;
	
	public static void main(String[] args) throws IOException {
		fis = new FileInputStream(args[1]);
		fos = new FileOutputStream(args[2]);
		
		if ("-e".equals(args[0])) {
			encrypt();
		}
		if ("-d".equals(args[0])) {
			decrypt();
		}
	}
	
	private static void encrypt() throws IOException {
		while (fis.available() > 0) {
			int e = fis.read() + 32;
			fos.write(e);
		}
		fos.close();
		fis.close();
	}
	
	private static void decrypt() throws IOException {
		while (fis.available() > 0) {
			int e = fis.read() - 32;
			fos.write(e);
		}
		fos.close();
		fis.close();
	}
}
