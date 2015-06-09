package com.codeeval.happynumbers;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

				System.out.println(isHappy(line));

		}
	}

	private static int isHappy(String line) {
		
		int inputInt = Integer.parseInt(line);
		List<Integer> tempResult = new ArrayList<Integer>();
		
		while (true){
			int test = getSumSquare(inputInt);
			if (test == 1) return test;
			else {
				if (tempResult.contains(test)) return 0;
				tempResult.add(test);
				inputInt = test;
			}
		}
		
	}

	private static int getSumSquare(int inputInt) {
		String inputStr = inputInt + "";
		int sum = 0;
		for (int i = 0; i < inputStr.length() ; i ++){
			sum += Math.pow(Integer.parseInt(inputStr.substring(i, i+1)),2);
		}
		return sum;
	}

	
	
//	
//	
//	
//	public static void main(String[] args) throws IOException {
//		
//		
//		//System.out.println(isHappy("1"));
//		System.out.println(isHappy("7"));
//		//System.out.println(isHappy("22"));
//
//	}
}
