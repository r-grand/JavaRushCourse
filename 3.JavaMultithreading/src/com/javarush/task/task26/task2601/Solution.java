package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {
	
	public static void main(String[] args) {
/* it's test
		Integer[] arr = new Integer[]{23, 7, -6, 72, -3, 16, 4, 80, 18, 63, 15, 8, 5, 17};
		for (int i : arr) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
		sort(arr);
		for (int i : arr) {
			System.out.print(i);
			System.out.print(" ");
		}
*/
	}
	
	public static Integer[] sort(Integer[] array) {
		Arrays.sort(array);
		int median;
		if (array.length % 2 == 0) {
			median = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
		} else {
			median = array[array.length / 2];
		}
		Comparator<Integer> toMedian = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return (o1 - median) + (o2 - median);
			}
		};
		Arrays.sort(array, toMedian);
		return array;
	}
}
