package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> fileNames = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!("end".equals(fileName = reader.readLine()))) {
            fileNames.add(fileName);
        }
        reader.close();
        Comparator part = new Part();
		Collections.sort(fileNames, part);
		String[] total = fileNames.get(0).split("\\.part");
		FileOutputStream fos = new FileOutputStream(total[0], true);
		BufferedInputStream bis;
        for (String result : fileNames) {
			bis = new BufferedInputStream(new FileInputStream(result));
			while (bis.available() > 0) {
				int buffer = bis.read();
				fos.write(buffer);
			}
			bis.close();
		}
		fos.close();
	}
    
    public static class Part implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			String[] arr1 = o1.split("part");
			String[] arr2 = o2.split("part");
			return Integer.parseInt(arr1[arr1.length - 1]) - Integer.parseInt(arr2[arr2.length - 1]);
		}
	}
}
