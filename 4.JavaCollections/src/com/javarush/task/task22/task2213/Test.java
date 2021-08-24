package com.javarush.task.task22.task2213;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {
	public String name;
	@JsonDeserialize(as = LinkedList.class)
	public List<Integer> digits;
	
	public static void main(String[] args) throws IOException {
		Test test = new Test();
		test.name = "test";
		test.digits = new ArrayList<>();
		test.digits.add(5);
		test.digits.add(7);
		test.digits.add(6);
		test.digits.add(89);
		
		StringWriter writer = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(writer, test);
		String result = writer.toString();
		
		System.out.println(result);
		
		StringReader reader = new StringReader(result);
		ObjectMapper mapper1 = new ObjectMapper();
		Test test1 = mapper1.readValue(reader, Test.class);
		
		Collections.sort(test1.digits);
		
		System.out.println(test1.name);
		for (int i = 0; i < test1.digits.size(); i++) {
			System.out.println(test1.digits.get(i));
		}
	}
}
