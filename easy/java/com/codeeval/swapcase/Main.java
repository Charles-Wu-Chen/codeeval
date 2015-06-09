package com.codeeval.swapcase;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();


				System.out.println(swapcase(line));

			

		}
	}

	private static String swapcase(String line) {
		StringBuffer sb = new StringBuffer();
		for (char ch : line.toCharArray()){
			if (Character.isUpperCase(ch)){
				ch = Character.toLowerCase(ch);
			}else if 
			(Character.isLowerCase(ch)){
				ch = Character.toUpperCase(ch);
			}
			sb.append(ch);
		}
		return sb.toString();

	}

	
//	public static void main(String[] args) throws IOException {
//		System.out.println(swapcase("Hello world!"));
//		System.out.println(swapcase("JavaScript language 1.8"));
//		System.out.println(swapcase("A letter"));
//
//	}
}
