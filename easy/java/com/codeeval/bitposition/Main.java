package com.codeeval.bitposition;

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

				System.out.println(isArmstrongNumber(line));

		}
	}

	private static String isArmstrongNumber(String line) {
		int inputlen = line.length();
		int sum = 0;
		
		for (int i=0; i<inputlen; i++){
			sum = sum+ (int)Math.pow(Integer.parseInt(line.substring(i,i+1)), inputlen);
		}
		if ( sum == Integer.parseInt(line)) return "True";
		else return "False";
	}

	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		System.out.println(isArmstrongNumber("3"));
//		System.out.println(isArmstrongNumber("6"));
//		System.out.println(isArmstrongNumber("153"));
//		System.out.println(isArmstrongNumber("351"));
//		System.out.println(isArmstrongNumber("371"));
//	}
}
