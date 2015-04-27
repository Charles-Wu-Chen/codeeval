package com.codeeval.pointincircle;

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
// input sample : Center: (2.12, -3.48); Radius: 17.22; Point: (16.21, -5)
	private static boolean getPrint(String input) {
		String [] inputArr = input.split(";");
		double centerX = Double.parseDouble(inputArr[0].substring(
				inputArr[0].indexOf("(")+1,
				inputArr[0].indexOf(",")
				).trim()
				);
		double centerY = Double.parseDouble(inputArr[0].substring(
				inputArr[0].indexOf(",")+1,
				inputArr[0].indexOf(")")
				).trim()
				);
		
		double radius = Double.parseDouble(inputArr[1].substring(
				inputArr[1].indexOf(":")+1
				).trim()
				);
		
		double pointX = Double.parseDouble(inputArr[2].substring(
				inputArr[2].indexOf("(")+1,
				inputArr[2].indexOf(",")
				).trim()
				);
		double pointY = Double.parseDouble(inputArr[2].substring(
				inputArr[2].indexOf(",")+1,
				inputArr[2].indexOf(")")
				).trim()
				);
		
		return Math.sqrt(
				(Math.pow(centerX - pointX, 2.0) + Math.pow(centerY - pointY, 2.0) )
				) <= radius;
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
//	 System.out.println(getPrint("Center: (2.12, -3.48); Radius: 17.22; Point: (16.21, -5)"));
//	 System.out.println(getPrint("Center: (5.05, -11); Radius: 21.2; Point: (-31, -45)"));
//	 System.out.println(getPrint("Center: (-9.86, 1.95); Radius: 47.28; Point: (6.03, -6.42)"));
//
//	}
}
