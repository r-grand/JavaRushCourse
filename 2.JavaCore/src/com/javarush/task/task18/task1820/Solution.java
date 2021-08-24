package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine()));
		FileWriter fw = new FileWriter((new BufferedReader(new InputStreamReader(System.in))).readLine(), true);
		while (scanner.hasNext()) {
			fw.write(Math.round(Double.parseDouble(scanner.next())) + " ");
		}
		fw.close();
		scanner.close();
	}
}
