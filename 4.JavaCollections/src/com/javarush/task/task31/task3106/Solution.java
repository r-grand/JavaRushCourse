package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		Set<String> fileParts = new TreeSet<>(Arrays.asList(args).subList(1, args.length));
		Vector<InputStream> vector = new Vector<>();
		for (String s : fileParts) {
			vector.addElement(Files.newInputStream(Paths.get(s)));
		}
		try (FileOutputStream fos = new FileOutputStream(args[0]);
			 ZipInputStream zis = new ZipInputStream(new SequenceInputStream(vector.elements()))) {
			while (zis.getNextEntry() != null) {
				byte[] bytes = new byte[4096];
				int read;
				while ((read = zis.read(bytes)) != -1) {
					fos.write(bytes, 0, read);
				}
			}
		}
	}
}
