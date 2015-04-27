package com.codeeval.decodenumbers;

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

	private static int getPrint(String input) {
		String testString = input;
		List<String> decodeList = new ArrayList<String>();
		getCombination(decodeList, "", testString);

		// System.out.println(decodeList);
		return decodeList.size();
	}

	private static void getCombination(List<String> decodeList,
			String decodeString, String testString) {
		if (testString.startsWith("0")) {
			testString = testString.substring(1);
		}
		if (testString.isEmpty() || testString.length() == 0
				|| testString.equals("")) {
			return;
		}
		if (testString.length() == 1) {
			decodeString = decodeString + "," + testString;
			decodeList.add(decodeString);
		} else if (10 <= Integer.parseInt(testString)
				&& Integer.parseInt(testString) <= 26) {
			String addString = decodeString + "," + testString;
			decodeList.add(addString);
			getCombination(decodeList,
					decodeString + "," + testString.substring(0, 1),
					testString.substring(1));
		} else {
			getCombination(decodeList,
					decodeString + "," + testString.substring(0, 1),
					testString.substring(1));
			if ((Integer.parseInt(testString.substring(0, 2))) <= 26) {

				getCombination(decodeList,
						decodeString + "," + testString.substring(0, 2),
						testString.substring(2));
			}
		}

	}

	private static boolean isValidDecode(String line) {

		int test = Integer.parseInt(line);
		return test <= 26;

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

	// public static void main(String[] args) throws IOException {
	// // System.out.println(getPrint("1"));
	// // System.out.println(getPrint("10"));
	// // System.out.println(getPrint("11"));
	// // System.out.println(getPrint("26"));
	// // System.out.println(getPrint("27"));
	// System.out.println(getPrint("101"));
	// System.out.println(getPrint("123"));
	// // System.out.println(getPrint("programming first The language;3 2 1"));
	// //
	// System.out.println(getPrint("programs Manchester The written ran Mark 1952 1 in Autocode from;6 2 1 7 5 3 11 4 8 9"));

	// }
}
