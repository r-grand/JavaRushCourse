package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
	public static void main(String[] args) {
		new Solution().recurse(132);
	}
	
	public void recurse(int n) {
		int count = 2;
		while (count <= n) {
			if (n % count == 0) {
				System.out.print(count + " ");
				if (n == count) break;
				recurse(n / count);
				break;
			} else {
				count++;
			}
		}
	}
}
