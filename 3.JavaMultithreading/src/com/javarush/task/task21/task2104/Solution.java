package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
	private final String first, last;
	
	public Solution(String first, String last) {
		this.first = first;
		this.last = last;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (this.getClass() != o.getClass()) {
			return false;
		}
		Solution sol = (Solution) o;
		if (!Objects.equals(first, sol.first)) return false;
		return Objects.equals(last, sol.last);
	}
	
	@Override
	public int hashCode() {
		int result = first == null ? 0 : first.hashCode();
		result = 31 * result + (last == null ? 0 : last.hashCode());
		return result;
	}
	
	public static void main(String[] args) {
		Set<Solution> s = new HashSet<>();
		s.add(new Solution("Donald", "Duck"));
		System.out.println(s.contains(new Solution("Donald", "Duck")));
	}
}
