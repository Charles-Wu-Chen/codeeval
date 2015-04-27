package com.codeeval.batschallenge;

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
		String [] inputArr = input.split(" ");
		int len = Integer.parseInt(inputArr[0]);
		int distance = Integer.parseInt(inputArr[1]);
		int existBat = Integer.parseInt(inputArr[2]);
		List <Integer> batList = new ArrayList<Integer>();
		for (int i=1; i<=existBat; i++){
			batList.add(new Integer(inputArr[2+i]));
		}
		int maxCount = 0;
		
		int startPos = 6;
		int endPos = len -6;
		
		if (existBat == 0){
			if ( (endPos - startPos) >=0){
				return (endPos - startPos)/distance + 1;
			} else return 0;
		}
		
		maxCount += ((batList.get(0) - startPos) / distance);
		startPos = batList.get(0);
		
		for (int t = 1; t<batList.size(); t++){
			maxCount += ((batList.get(t) - startPos) / distance -1);
			startPos = batList.get(t);
		}
		
		maxCount += ((endPos - startPos) / distance);
		
		return maxCount;
		
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
//	 System.out.println(getPrint("22 2 2 9 11"));
//	 System.out.println(getPrint("33 5 0"));
//	 System.out.println(getPrint("16 3 2 6 10"));
//	 System.out.println(getPrint("835 125 1 113"));
//	 System.out.println(getPrint("47 5 0"));
//	 
//	}
}
