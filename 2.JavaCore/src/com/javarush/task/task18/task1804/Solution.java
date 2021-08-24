package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		FileInputStream fis = new FileInputStream(scanner.nextLine());
		scanner.close();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 128; i++) {
			list.add(0);
		}
		
		while (fis.available() > 0) {
			int count = fis.read();
			list.set(count, (list.get(count) + 1));
		}
		fis.close();
		
		List<Integer> copy = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			copy.add(list.get(i));
		}
		
		Collections.sort(copy);
		
		int temp = 0;
		for (int check : copy) {
		    if (check > temp) {
		    	temp = check;
		    	break;
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (temp == list.get(i)) {
				System.out.print((i) + " ");
			}
		}
	}
}

