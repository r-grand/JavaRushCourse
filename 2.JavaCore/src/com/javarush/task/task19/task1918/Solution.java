package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;

/*
Знакомство с тегами
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		StringBuilder file = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			 BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()))) {
			while (fr.ready()) {
				file.append(fr.readLine());
			}
		}
		Elements elements = Jsoup.parse(file.toString(), "", Parser.xmlParser()).select(args[0]);
		System.out.println(elements);
	}
}