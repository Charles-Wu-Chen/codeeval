package com.codeeval.splitnumber;

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

				System.out.println(splitnumber(line));

		}
	}

	private static int splitnumber(String line) {
		String [] inputs = line.split(" ");
		String inputStr =  inputs[0];
		String inputRule = inputs[1];
		
		if (inputRule.contains("+")){
			String [] numberFormats = inputRule.split("\\+");
			int first = Integer.parseInt(inputStr.substring(0, numberFormats[0].length()));
			int second = Integer.parseInt(inputStr.substring(numberFormats[0].length(), numberFormats[0].length()+numberFormats[1].length() ));
			return first + second;
		
		}
		else {
			String [] numberFormats = inputRule.split("-");
			int first = Integer.parseInt(inputStr.substring(0, numberFormats[0].length()));
			int second = Integer.parseInt(inputStr.substring(numberFormats[0].length(), numberFormats[0].length()+numberFormats[1].length() ));
			return first - second;
		}
		

	}
	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		
//		System.out.println(splitnumber("3413289830 a-bcdefghij"));
//		System.out.println(splitnumber("776 a+bc"));
//		System.out.println(splitnumber("12345 a+bcde"));
//		System.out.println(splitnumber("1232 ab+cd"));
//		System.out.println(splitnumber("90602 a+bcde"));
//
//
//	}
}
