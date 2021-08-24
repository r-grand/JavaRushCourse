package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
	public static Map<String, Integer> resultMap = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName;
		while (!("exit".equals(fileName = reader.readLine()))) {
			new ReadThread(fileName).start();
		}
		reader.close();
	}
	
	public static class ReadThread extends Thread {
		private String fileName;
		
		public ReadThread(String fileName){
			this.fileName = fileName;
		}
		
		@Override
		public void run() {
			try (FileInputStream fis = new FileInputStream(fileName)) {
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < 256; i++) {
					list.add(0);
				}
				while (fis.available() > 0) {
					int index = fis.read();
					list.set(index, (list.get(index) + 1));
				}
				int maxCount = list.get(0);
				for (int i = 1; i < list.size(); i++) {
					if (list.get(i) > maxCount) {
						maxCount = list.get(i);
					}
				}
				int maxFrequent = -1;
				for (int i = 0; i < list.size(); i++) {
					if (maxCount == list.get(i)) {
						maxFrequent = i;
						break;
					}
				}
				resultMap.put(fileName, maxFrequent);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
