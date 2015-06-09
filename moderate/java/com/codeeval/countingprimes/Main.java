package com.codeeval.countingprimes;

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
		String [] inputArr = input.split(",");
		int min = Integer.parseInt(inputArr[0]);
		int max = Integer.parseInt(inputArr[1]);

		int test = min;
		int primeCount = 0;
		
		while (test<=max){
			if (test == 2) {
				primeCount ++;
				test += 1;
			}
			else if (test % 2 == 0){
				test += 1;
			}else {
				if (isPrime(test)==true){
					primeCount ++;
				}
				test += 2;
			}
			
		}
		return primeCount;
	}

	private static boolean isPrime(int test){
		if (test%2 == 0) return false;
		for (int i=3; test >= i*i; i+=2){
			if (test%i == 0) return false;
		}
		return true;
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
//	 System.out.println(getPrint("2,10"));
//	 System.out.println(getPrint("20,30"));
//	 
//	}
}
