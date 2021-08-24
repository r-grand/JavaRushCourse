package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Транзакционность
*/

public class Solution {
	public static List<String> allLines = new ArrayList<>();
	public static List<String> forRemoveLines = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileAndPathName1 = reader.readLine();
		String fileAndPathName2 = reader.readLine();
		reader.close();
		FileReader fr = new FileReader(fileAndPathName1);
		FileReader fr2 = new FileReader(fileAndPathName2);
		Scanner scanner1 = new Scanner(fr);
		Scanner scanner2 = new Scanner(fr2);
		
		while (scanner1.hasNext()) {
			allLines.add(scanner1.nextLine());
		}
		scanner1.close();
		while (scanner2.hasNext()) {
			forRemoveLines.add(scanner2.nextLine());
		}
		scanner2.close();
		
		Solution solution = new Solution();
		solution.joinData();
	}
	
	public void joinData() throws CorruptedDataException {
		for (String check : forRemoveLines) {
			if (!allLines.contains(check)) {
				allLines = new ArrayList<>();
				throw new CorruptedDataException();
			}
		}
		allLines.removeAll(forRemoveLines);
	}
}
