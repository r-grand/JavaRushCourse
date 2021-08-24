package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Проход по дереву файлов
*/

public class Solution extends SimpleFileVisitor<Path> {
	List<File> files = new ArrayList<>();
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		File f = file.toFile();
		if (f.length() < 51) {
			files.add(f);
		}
		return FileVisitResult.CONTINUE;
	}
	
	public static void main(String[] args) throws IOException {
		File startFile = new File(args[1]);
		File finishFile = new File(startFile.getParent() + "/allFilesContent.txt");
		if (FileUtils.isExist(startFile)) {
			FileUtils.renameFile(startFile, finishFile);
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(finishFile));
		
		Path path = Paths.get(args[0]);
		Solution solution = new Solution();
		Files.walkFileTree(path, solution);
		List<String> fileNames = new ArrayList<>();
		for (File f : solution.files) {
			fileNames.add(f.getName());
		}
		Collections.sort(fileNames);
		for (String s : fileNames) {
			for (File t : solution.files) {
				if (t.getName().equals(s)) {
					List<String> lines = Files.readAllLines(t.toPath());
					lines.add("\n");
					for (String temp : lines) {
					    writer.write(temp);
					}
					writer.flush();
					solution.files.remove(t);
					break;
				}
			}
		}
		writer.close();
	}
}
