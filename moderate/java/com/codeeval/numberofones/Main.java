package com.codeeval.numberofones;

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

	private static int getPrint(String line) {
		String binInput = Integer.toBinaryString(Integer.parseInt(line));
		int result = 0;
		for (int i = 0; i < binInput.length(); i++){
			result+= Character.getNumericValue(binInput.charAt(i));
		}
		
		return result;
		
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
//		System.out.println(getPrint("10"));
//		System.out.println(getPrint("22"));
//		System.out.println(getPrint("56"));
//
//	}
}
