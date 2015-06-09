package com.codeeval.penultimate;

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
				System.out.println(getSecondLastString(line));
		}
	}

	private static String getSecondLastString(String line) {
				
		String [] inputList = line.split(" ");
		return inputList[inputList.length-2];
				
	}

	
	
	
//	public static void main(String[] args) throws IOException {
//		System.out.println(getSecondLastString("some line with text"));
//		System.out.println(getSecondLastString("another line"));
//
//	}
}
