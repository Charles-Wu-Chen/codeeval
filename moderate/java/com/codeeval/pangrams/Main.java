package com.codeeval.pangrams;

/* Sample code to read in test cases:*/

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

	private static String getPrint(String input) {
		char[] testArr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		List<Character> listC = new ArrayList<Character>();
		for (char c : testArr) {
			listC.add(c);
		}

		char[] inputArr = input.toCharArray();
		for (char test : inputArr) {
			if (listC.isEmpty()) {
				return "NULL";
			}
			if (listC.contains(Character.toLowerCase(test))) {
				listC.remove(new Character(Character.toLowerCase(test)));
			}
		}

		if (listC.isEmpty()) {
			return "NULL";
		}
		StringBuffer sb = new StringBuffer();
		for (char remain : listC) {
			sb.append(remain);
		}
		return sb.toString();

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
//
//	public static void main(String[] args) throws IOException {
//		System.out
//				.println(getPrint("A quick brown fox jumps over the lazy dog"));
//		System.out
//				.println(getPrint("A slow yellow fox crawls under the proactive dog"));
//		System.out
//		.println(getPrint("ABCDEDFHIGHLKLMOFPEHSQSTUVDWOXZ"));
//
//	}
}
