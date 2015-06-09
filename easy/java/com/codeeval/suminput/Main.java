package com.codeeval.suminput;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		int result = 0;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			result += Integer.parseInt(line);

		}
		System.out.println(result);
	}

	
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		System.out.println(bitposition("86,2,3"));
//		System.out.println(bitposition("125,1,2"));
//
//	}
}
