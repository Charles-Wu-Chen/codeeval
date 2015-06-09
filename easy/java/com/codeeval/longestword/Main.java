package com.codeeval.longestword;

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


				System.out.println(longestWord(line));

			

		}
	}

	private static String longestWord(String line) {
		String longest = "";
		String [] inputs = line.split(" ");
		for (String in : inputs){
			if (in.length()>longest.length()){
				longest = in;
			}
		}
		
		return longest;
	}

	
	
	
//	public static void main(String[] args) throws IOException {
//		System.out.println(longestWord("some line with text"));
//		System.out.println(longestWord("another line"));
//		
//
//	}
}
