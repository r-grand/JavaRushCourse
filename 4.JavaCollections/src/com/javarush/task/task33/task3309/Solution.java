package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, IOException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);
		BufferedReader reader = new BufferedReader(new StringReader(writer.toString()));
		ArrayList<String> strings = new ArrayList<>();
		String s;
		while ((s = reader.readLine()) != null) {
			strings.add(s);
		}
		ArrayList<String> copy = new ArrayList<>();
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).contains("<" + tagName)) {
				copy.add("<!--" + comment + "-->");
			}
			copy.add(strings.get(i));
		}
		StringBuilder sb = new StringBuilder();
		for (String str : copy) {
		    sb.append(str + "\n");
		}
        return sb.toString();
    }

    public static void main(String[] args) throws JAXBException, IOException {
    	Test test = new Test("first", 1);
    	test.list.add("string1");
    	test.list.add("string2");
    	test.list.add("");
    	test.list.add("string4");
    	test.list.add("string5");
		String xmlWithComment = toXmlWithComment(test, "list", "it's a comment");
		System.out.println(xmlWithComment);
    }
}

@XmlType(name = "test")
@XmlRootElement
class Test {
	@XmlElement
	public String number;
	@XmlElement
	public int age;
	@XmlElement
	public List<String> list = new ArrayList<>();
	
	public Test(String number, int age) {
		this.number = number;
		this.age = age;
	}
	
	public Test() {
	}
}
