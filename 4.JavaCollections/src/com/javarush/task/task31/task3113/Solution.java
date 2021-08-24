package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static java.nio.file.Files.*;

/* 
Что внутри папки?
*/

public class Solution extends SimpleFileVisitor<Path> {
	private int countDirectories;
	private int countFiles;
	private long countBytes;
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (isRegularFile(file)) {
			countFiles++;
			countBytes += size(file);
		}
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		if (isDirectory(dir)) {
			countDirectories++;
		}
		return FileVisitResult.CONTINUE;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputPath = reader.readLine();
		reader.close();
		Path path = Paths.get(inputPath);
		if (!isDirectory(path)) {
			System.out.println(inputPath + " - не папка");
			return;
		}
		Solution solution = new Solution();
		Files.walkFileTree(path, solution);
		System.out.println("Всего папок - " + (solution.countDirectories - 1));
		System.out.println("Всего файлов - " + solution.countFiles);
		System.out.println("Общий размер - " + solution.countBytes);
	}
}
