package com.codeeval.emailvalidation;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			System.out.println(getPrint(line));

		}
	}
private static boolean getPrint(String input) {
		
		
		return Pattern.matches("^[\\w+-_]+[\\w\\.+-_]*@[\\w-]+\\.[\\w-]+[\\w-\\.]*", input);
		
	}




	private static String removeLast(String input, String lastChar) {
		String result = input;
		if (input.contains(lastChar)) {
			result = input.substring(0, input.lastIndexOf(lastChar));
		}
		return result;
	}

	// public static void main(String[] args) throws IOException {
	// BufferedReader buffer = null;
	// File file = null;
	// try {
	// file = new File("racingcharinput.txt");
	// buffer = new BufferedReader(new FileReader(file));
	// String line;
	//
	// while ((line = buffer.readLine()) != null) {
	// line = line.trim();
	// System.out.println(getUnique(line));
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// buffer.close();
	// }
	//
	// }

	
	
	
	
	
	
//	 public static void main(String[] args) throws IOException {
//	 System.out.println(getPrint("foo@bar.com"));
//	 System.out.println(getPrint("this is not an email id"));
//	 System.out.println(getPrint("admin#codeeval.com"));
//	 System.out.println(getPrint("good123@bad.com"));
//	 
//	}
}
