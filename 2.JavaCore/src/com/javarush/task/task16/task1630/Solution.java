package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

/* 
Последовательный вывод файлов
*/

public class Solution {
	public static String firstFileName;
	public static String secondFileName;
	
	static {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			firstFileName = reader.readLine();
			secondFileName = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		systemOutPrintln(firstFileName);
		systemOutPrintln(secondFileName);
	}
	
	public static void systemOutPrintln(String fileName) throws InterruptedException {
		ReadFileInterface f = new ReadFileThread();
		f.setFileName(fileName);
		f.start();
		f.join();
		System.out.println(f.getFileContent());
	}
	
	public interface ReadFileInterface {
		
		void setFileName(String fullFileName);
		
		String getFileContent();
		
		void join() throws InterruptedException;
		
		void start();
	}
	
	public static class ReadFileThread extends Thread implements ReadFileInterface {
		private String fileName;
		private FileReader fileReader;
		private Scanner scanner;
		private String result = "";
		
		@Override
		public void setFileName(String fullFileName) {
			this.fileName = fullFileName;
		}
		
		@Override
		public String getFileContent() {
			return result;
		}
		
		@Override
		public void run() {
			try {
				fileReader = new FileReader(fileName);
				scanner = new Scanner(fileReader);
			} catch (FileNotFoundException e) {
				System.out.println("file not found");
			}
			while (scanner.hasNext()) {
					result += scanner.nextLine() + "\n";
			}
			scanner.close();
		}
	}
}
