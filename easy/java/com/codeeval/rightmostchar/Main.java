package com.codeeval.rightmostchar;

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

			System.out.println(rightmostChar(line));

		}
	}

	private static int rightmostChar(String line) {
		String[] inputs = line.split(",");

		if (inputs.length == 2) {
			String inputStr = inputs[0];
			String testStr = inputs[1];

			return inputStr.lastIndexOf(testStr);

		}
		return -1;
	}

//	public static void main(String[] args) throws IOException {
//
//		System.out.println(rightmostChar("Hello World,r"));
//		System.out.println(rightmostChar("Hello CodeEval,E"));
//		System.out.println(rightmostChar("Hello CodeEval,A"));
//		System.out
//				.println(rightmostChar("FQb5DdrQBx2rxGQ8rxJtKajMY3TNUoSNGLBV2Jxny0KU4XduL,"));
//	}
}
