package com.codeeval.armstrong;

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

				System.out.println(bitposition(line));

		}
	}

	private static boolean bitposition(String line) {
		String [] inputs = line.split(",");
		int inputInt = Integer.parseInt(inputs[0]);
		int test1 = Integer.parseInt(inputs[1]);
		int test2 = Integer.parseInt(inputs[2]);
		
		String binaryStr = Integer.toBinaryString(inputInt);
		return binaryStr.charAt(binaryStr.length()-test1)==binaryStr.charAt(binaryStr.length()-test2);
	}

	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		System.out.println(bitposition("86,2,3"));
//		System.out.println(bitposition("125,1,2"));
//
//	}
}
