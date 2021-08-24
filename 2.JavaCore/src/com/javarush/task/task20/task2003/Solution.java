package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/

public class Solution {
	
	public static Map<String, String> runtimeStorage = new HashMap<>();
	
	public static void save(OutputStream outputStream) throws Exception {
		Properties properties = new Properties();
		for (Map.Entry<String, String> pair : runtimeStorage.entrySet()) {
		    properties.setProperty(pair.getKey(), pair.getValue());
		}
		properties.store(outputStream, "");
	}
	
	public static void load(InputStream inputStream) throws IOException {
		Properties properties = new Properties();
		properties.load(inputStream);
		runtimeStorage = (Map<String, String>) properties.clone();
//		Set<String> set = properties.stringPropertyNames();
//		for (String key : set) {
//		    runtimeStorage.put(key, properties.getProperty(key));
//		}
	}
	
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			 FileInputStream fis = new FileInputStream(reader.readLine())) {
			load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Map.Entry<String, String> pair : runtimeStorage.entrySet()) {
			System.out.println(pair.getKey() + " : " + pair.getValue());
		}
		System.out.println();
		System.out.println(runtimeStorage);
	}
}
