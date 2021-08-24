/*
package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

*/
/*
Обращенные слова
*//*


public class Solution {
	public static List<Pair> result = new LinkedList<>();
	
	public static void main(String[] args) {
		try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
			 FileReader fR = new FileReader(bR.readLine());
			 BufferedReader stringReader = new BufferedReader(fR)) {
			String line;
			ArrayList<String> list = new ArrayList<>();
			while ((line = stringReader.readLine()) != null) {
				String[] arr = line.split(" ");
				list.addAll(Arrays.asList(arr));
			}
			for (int i = 0; i < list.size(); i++) {
			    StringBuilder sB = new StringBuilder(list.get(i));
			    sB.reverse();
			    for (int j = i + 1; j < list.size(); j++) {
			        if (list.get(j).equals(sB.toString())) {
			        	Pair pair = new Pair();
			        	pair.first = list.get(i);
			        	pair.second = list.get(j);
			        	if (!result.contains(pair)) {
							result.add(pair);
						}
					}
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
	
	public static class Pair {
		String first;
		String second;
		
		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			
			Pair pair = (Pair) o;
			
			if (first != null ? !first.equals(pair.first) : pair.first != null) {
				return false;
			}
			return second != null ? second.equals(pair.second) : pair.second == null;
			
		}
		
		@Override
		public int hashCode() {
			int result = first != null ? first.hashCode() : 0;
			result = 31 * result + (second != null ? second.hashCode() : 0);
			return result;
		}
		
		@Override
		public String toString() {
			return first == null && second == null ? "" :
					first == null ? second :
							second == null ? first :
									first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
			
		}
	}
	
}
*/
package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Обращенные слова
*/

public class Solution {
	public static List<Pair> result = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		List<String> words = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
		bufferedReader.close();
		while (fileReader.ready()) {
			words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
		}
		fileReader.close();
		
		for (int i = 0; i < words.size(); i++) {
			for (int j = 0; j < words.size(); ) {
				if (i >= words.size()) {
					break;
				}
				if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && j != i) {
					Pair pair = new Pair();
					pair.first = words.get(j);
					pair.second = words.get(i);
					result.add(pair);
					words.remove(j);
					words.remove(i);
					j = 0;
				} else
					j++;
			}
		}
	}
	
	public static class Pair {
		String first;
		String second;
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			
			Pair pair = (Pair) o;
			
			if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
			return second != null ? second.equals(pair.second) : pair.second == null;
			
		}
		
		@Override
		public int hashCode() {
			int result = first != null ? first.hashCode() : 0;
			result = 31 * result + (second != null ? second.hashCode() : 0);
			return result;
		}
		
		@Override
		public String toString() {
			return first == null && second == null ? "" :
					first == null ? second :
							second == null ? first :
									first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
			
		}
	}
	
}
