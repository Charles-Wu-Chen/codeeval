package com.codeeval.sumofprimes;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
				System.out.println(getPrint());

		
	}

	private static int getPrint() {
		int result = 2;
		int count = 1;
		int testNumber = 3;
		while  (count <1000){
			if (isPrime(testNumber) == true){
				result += testNumber;
				count++;
			}
			testNumber+=2;
		}
		return result;
	}

	private static boolean isPrime(int test){
		if (test%2 == 0) return false;
		for (int i=3; test >= i*i; i+=2){
			if (test%i == 0) return false;
		}
		return true;
	}

	private static String removeLast(String input, String lastChar){
		String result = input;
		if (input.contains(lastChar)){
			result = input.substring(0,input.lastIndexOf(lastChar));
		}
		return result;
	}
	
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader buffer = null;
//		File file = null;
//		try {
//			file = new File("racingcharinput.txt");
//			buffer = new BufferedReader(new FileReader(file));
//			String line;
//
//			while ((line = buffer.readLine()) != null) {
//				line = line.trim();
//				System.out.println(getUnique(line));
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			buffer.close();
//		}
//
//	}
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		System.out.println(getPrint("19"));
//		System.out.println(getPrint("0"));
//
//	}
}
