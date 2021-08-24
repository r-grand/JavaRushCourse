package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {
	
	public static void main(String[] args) throws IOException {
		Path passwords = downloadFile("https://www.kazedu.kz/get_ref/74203", Paths.get("D:/IDEA"));
		
		for (String line : Files.readAllLines(passwords)) {
			System.out.println(line);
		}
	}
	
	public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
		InputStream inputStream = new URL(urlString).openStream();
		String fileName = urlString.substring(urlString.lastIndexOf('/') + 1);
		Path tempFile = Files.createTempFile("temp", null);
		Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
		inputStream.close();
		Path finalFile = Files.createFile(Paths.get(downloadDirectory.toString() + "/123456"));
		return Files.move(tempFile, finalFile, StandardCopyOption.REPLACE_EXISTING);
	}
}
