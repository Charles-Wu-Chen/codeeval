package com.codeeval.magicnumbers;

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
		// skip even number
		// skip duplicate digit number
		// for (length)
		// move
		// and remove number
		//
		// in the end, stop leftmost and string removed to 0
		//

		// return maxCount;

		StringBuffer sb = new StringBuffer();

		int min = Integer.parseInt(input.split(" ")[0]);
		int max = Integer.parseInt(input.split(" ")[1]);

		for (int test = min; test <= max; test++) {
			// if ((test & 1) == 0){
			// continue;
			// }
			 if (hasDuplicate (test)){
			//if (hasRepeat(test)) {
				continue;
			}

			// start rolling and check result at end

			String testString = test + "";
			StringBuffer holder = new StringBuffer(test + "");

			int testDigit = Character.getNumericValue(testString.charAt(0));

			for (int i = 0; i < testString.length(); i++) {
				int testIndex = holder.indexOf(testDigit + "");
				if (testIndex < 0)
					continue;

				holder.deleteCharAt(testIndex);
				testDigit = getNextDigit(testDigit, testString);

			}

			if (holder.toString().equals("")
					&& testDigit == Character.getNumericValue(testString
							.charAt(0))) {
				sb.append(test + " ");
			}

		}

		if (sb.length() == 0) {
			return "-1";
		}
		return sb.toString().trim();
	}

	private static boolean hasRepeat(int test) {
		if (test < 10)
			return false;

		String input = test + "";

		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i)==input.charAt(i+1)) {
				return true;
			}
		}
		return false;
	}

	private static int getNextDigit(int testDigit, String testString) {
		return Character.getNumericValue(testString.charAt((testString
				.indexOf(testDigit + "") + testDigit) % testString.length()));
	}

	private static boolean hasDuplicate(int test) {
		if (test < 10)
			return false;

		String input = test + "";

		for (int i = 0; i < input.length() - 1; i++) {
			if (input.substring(i + 1).indexOf((input.charAt(i))) >= 0) {
				return true;
			}
		}
		return false;
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
//		System.out.println(getPrint("1 3737"));
//		System.out.println(getPrint("8382 8841"));
//
//	}
}
