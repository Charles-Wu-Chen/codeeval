package com.codeeval.trailingstring;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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


	 public static int getPrint(String input)
	    {
		 String [] inputs = input.split(",");
		 if (inputs[0].endsWith(inputs[1])){
			 return 1;
		 }
		 return 0;
					
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

	
	
	
	
//	public static void main(String[] args) throws IOException {
//		System.out.println(getPrint("Hello World,World"));
//		System.out.println(getPrint("Hello CodeEval,CodeEval"));
//		System.out.println(getPrint("San Francisco,San Jose"));
//	}
}
