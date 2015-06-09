package com.codeeval.mixedcontent;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

				System.out.println(separateMixed(line));

		}
	}

	private static String separateMixed(String line) {
		String [] inputs = line.split(",");
		LinkedList<String> stringList = new LinkedList<String>();
		LinkedList<String> numberList = new LinkedList<String>();
		
		for (String input : inputs){
			if (isDigitString(input)){
				numberList.add(input);
			}else {
				stringList.add(input);
			}
		}
		
		if (stringList.size() == 0  || numberList.size() == 0) {
			return line;
		}
		
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		for (String i : stringList){
			sb1.append(i+",");
		}
		
		for (String i : numberList){
			sb2.append(i+",");
		}
		
		return sb1.substring(0, sb1.length()-1) +"|"+sb2.substring(0, sb2.length()-1);
	}

	
	private static boolean isDigitString(String input){
//		return input.matches("-?\\d+");
		return input.matches("\\d+");
	}
	
//	
//	
//	public static void main(String[] args) throws IOException {
//		
//		System.out.println(isDigitString("86"));
//		System.out.println(isDigitString("a86"));
//		
//		System.out.println(separateMixed("86,2,3"));
//		System.out.println(separateMixed("8,33,21,0,16,50,37,0,melon,7,apricot,peach,pineapple,17,2124,13,14,43,41"));
//	}
}
