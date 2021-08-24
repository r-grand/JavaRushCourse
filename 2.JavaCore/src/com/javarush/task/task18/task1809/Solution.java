package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Реверс файла
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(new Scanner(System.in).nextLine());
		FileOutputStream fos = new FileOutputStream(new Scanner(System.in).nextLine());
		List<Integer> list = new ArrayList<>();
		while (fis.available() > 0) {
		    list.add(fis.read());
        }
		Collections.reverse(list);
		for (int temp : list) {
		    fos.write(temp);
		}
		fis.close();
		fos.close();
	}
}
