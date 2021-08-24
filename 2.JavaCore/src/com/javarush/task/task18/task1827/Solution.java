package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы
*/

public class Solution {
	public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        
        int newId = getMaxId(fileName) + 1;
		String id = idReady(newId);
		String productName = productNameReady(args[1]);
		String price = priceReady(args[2]);
		String quantity = quantityReady(args[3]);
		
		if ("-c".equals(args[0])) {
			FileWriter fr = new FileWriter(fileName, true);
			fr.write("\n");
			fr.write(id);
			fr.write(productName);
			fr.write(price);
			fr.write(quantity);
			fr.flush();
			fr.close();
		}
	}
	
	public static int getMaxId(String fileName) throws IOException {
		Scanner scanner = new Scanner(new FileReader(fileName));
		int id = 0;
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			char[] idChars = {
					line.toCharArray()[0], line.toCharArray()[1],
					line.toCharArray()[2], line.toCharArray()[3],
					line.toCharArray()[4], line.toCharArray()[5],
					line.toCharArray()[6], line.toCharArray()[7]
			};
			List<Character> list = new ArrayList<>();
			for (char c : idChars) {
				if (c != ' ') {
					list.add(c);
				}
			}
			char[] result = new char[list.size()];
			for (int i = 0; i < list.size(); i++) {
				result[i] = list.get(i);
			}
			String temp = new String(result);
			int idCheck = Integer.parseInt(temp);
			if (idCheck > id) {
				id = idCheck;
			}
		}
		scanner.close();
		return id;
	}
	
	private static String idReady(int newId) {
		char[] ids = (String.valueOf(newId)).toCharArray();
		String frameIds = "        ";
		char[] frameId = frameIds.toCharArray();
		for (int i = 0; i < ids.length; i++) {
			frameId[i] = ids[i];
		}
		String idReady = new String(frameId);
		return idReady;
	}
	
	private static String productNameReady(String name) {
		char[] productName = name.toCharArray();
		String frameProductNames = "                              ";
		char[] frameProductName = frameProductNames.toCharArray();
		int size = productName.length < frameProductName.length ? productName.length : frameProductName.length;
		for (int i = 0; i < size; i++) {
			frameProductName[i] = productName[i];
		}
		String productNameReady = new String(frameProductName);
		return productNameReady;
	}
	
	private static String priceReady(String p) {
		char[] price = p.toCharArray();
		String framePrices = "        ";
		char[] framePrice = framePrices.toCharArray();
		int size = price.length < framePrice.length ? price.length : framePrice.length;
		for (int i = 0; i < size; i++) {
			framePrice[i] = price[i];
		}
		String priceReady = new String(framePrice);
		return priceReady;
	}
	
	private static String quantityReady(String q) {
		char[] quantity = q.toCharArray();
		String frameQuantities = "    ";
		char[] frameQuantity = frameQuantities.toCharArray();
		int size = quantity.length < frameQuantity.length ? quantity.length : frameQuantity.length;
		for (int i = 0; i < size; i++) {
			frameQuantity[i] = quantity[i];
		}
		String quantityReady = new String(frameQuantity);
		return quantityReady;
	}
}
