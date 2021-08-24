package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[0]));
			 BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[1]))) {
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			String s = new String(buffer, "Windows-1251");
			buffer = s.getBytes(StandardCharsets.UTF_8);
			outputStream.write(buffer);
		}
	}
}
