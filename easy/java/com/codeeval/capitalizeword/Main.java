package com.codeeval.capitalizeword;

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

				System.out.println(capitalizeWord(line));

		}
	}

	private static String capitalizeWord(String line) {
		String [] inputs = line.split(" ");

		StringBuffer sb = new StringBuffer();
		
		for (String input : inputs){
			sb.append( Character.toUpperCase(input.charAt(0))+input.substring(1)+" ");
		}
		
		return sb.toString().trim();
	}

	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		System.out.println(capitalizeWord("Hello world"));
//		System.out.println(capitalizeWord("javaScript language"));
//		System.out.println(capitalizeWord("a letter"));
//		System.out.println(capitalizeWord("1st thing"));
//		
//
//	}
}
