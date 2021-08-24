package com.javarush.task.task31.task3102;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Solution extends SimpleFileVisitor<Path> {
	List<String> absolutFileNames = new ArrayList<>();
	
	@Override
	public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
		absolutFileNames.add(path.toAbsolutePath().toString());
		return FileVisitResult.CONTINUE;
	}
	
	public static List<String> getFileTree(String root) throws IOException {
		Solution solution = new Solution();
		Files.walkFileTree(Paths.get(root), solution);
		return solution.absolutFileNames;
	}
	
	public static void main(String[] args) {
	
	}
}
