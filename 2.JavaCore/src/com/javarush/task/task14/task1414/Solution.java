package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String key;
		
		for (key = reader.readLine(); true;	key = reader.readLine()) {
			if (key.equals("soapOpera")) {
				System.out.println(MovieFactory.getMovie(key).getClass().getSimpleName());
			} else
			if (key.equals("cartoon")) {
				System.out.println(MovieFactory.getMovie(key).getClass().getSimpleName());
			} else
			if (key.equals("thriller")) {
				System.out.println(MovieFactory.getMovie(key).getClass().getSimpleName());
			} else {
				MovieFactory.getMovie(key);
				break;
			}
		}
		
	}
	
	static class MovieFactory {
		
		static Movie getMovie(String key) {
			Movie movie = null;
			
			if ("soapOpera".equals(key)) {
				movie = new SoapOpera();
			}
			if ("cartoon".equals(key)) {
				movie = new Cartoon();
			}
			if ("thriller".equals(key)) {
				movie = new Thriller();
			}
			
			return movie;
		}
	}
	
	static abstract class Movie {
	}
	
	static class SoapOpera extends Movie {
	}
	
	static class Cartoon extends Movie {
	}
	
	static class Thriller extends Movie {
	}
	
}
