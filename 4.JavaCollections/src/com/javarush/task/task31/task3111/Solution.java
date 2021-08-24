package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/* 
Продвинутый поиск файлов
*/

public class Solution {
	
	public static void main(String[] args) throws IOException {
		SearchFileVisitor searchFileVisitor = new SearchFileVisitor();
		
		searchFileVisitor.setPartOfName("amigo");
		searchFileVisitor.setPartOfContent("programmer");
		searchFileVisitor.setMinSize(500);
		searchFileVisitor.setMaxSize(10000);
		
		Files.walkFileTree(Paths.get("D:/idea/collects"), searchFileVisitor);
		
		List<Path> foundFiles = searchFileVisitor.getFoundFiles();
		for (Path file : foundFiles) {
			System.out.println(file);
		}
		InputStream inputStream = new URL("https://www.google.com.ua/images/srpr/logo11w.png").openStream();
	}
	
}
