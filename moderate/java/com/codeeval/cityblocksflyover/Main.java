package com.codeeval.cityblocksflyover;

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
		String[] inputArr = input.split("\\(|\\) \\(|\\)");
		String streetsStr = inputArr[1];
		String avenuesStr = inputArr[2];

		String[] xPointArr = streetsStr.split(",");
		String[] yPointArr = avenuesStr.split(",");

		int finalX = Integer.valueOf(xPointArr[xPointArr.length - 1]);

		int finalY = Integer.valueOf(yPointArr[yPointArr.length - 1]);

		double gradient = finalY / (double) finalX;

		int count = 1;
		for (int xLen = 0; xLen < xPointArr.length - 1; xLen++) {
			int xInt1 = Integer.valueOf(xPointArr[xLen]);
			int xInt2 = Integer.valueOf(xPointArr[xLen + 1]);

			for (int yLen = 0; yLen < yPointArr.length - 1; yLen++) {
				int yInt1 = Integer.valueOf(yPointArr[yLen]);
				int yInt2 = Integer.valueOf(yPointArr[yLen + 1]);

				double baseGradient = yInt1 / (double) xInt1;
				double xGradient = yInt1 / (double) xInt2;
				double yGradient = yInt2 / (double) xInt1;

				if (baseGradient == gradient
						|| (baseGradient < gradient && yGradient > gradient)
						|| (baseGradient > gradient && xGradient < gradient)) {
					count++;
				} else if (xGradient > gradient) {
					break;
				}
			}

		}

		return count;

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
	// public static void main(String[] args) throws IOException {
	// System.out.println(getPrint("(0,1,3,4,6) (0,1,2,4)")); //5
	// System.out.println(getPrint("(0,1,2,4) (0,1,3,4,5)")); //6
	// System.out.println(getPrint("(0,2,4,8,10,13,14,18,22,23,24,33,40,42,44,47,49,53,55,63,66,81,87,91) (0,147,220)"));
	// //24
	//
	// }

}
