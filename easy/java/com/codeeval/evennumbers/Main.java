package com.codeeval.evennumbers;

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

				System.out.println(isEven(line));

		}
	}

	private static int isEven(String line) {
		int input = Integer.parseInt(line);
		return (input+1)%2;
	}

	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		System.out.println(isEven("86"));
//		System.out.println(isEven("125"));
//
//	}
}
