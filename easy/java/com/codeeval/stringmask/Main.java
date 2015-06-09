package com.codeeval.stringmask;

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

	private static String getPrint(String line) {
		String [] inputs = line.split(" ");
		String inputStr = inputs[0];
		String inputMask = inputs[1];
		
		StringBuffer sb = new StringBuffer();
		
		for (int idx = 0; idx<inputMask.length(); idx++){
			sb.append(getMaskedChar(inputStr.charAt(idx), inputMask.charAt(idx)));
		}
		
		return sb.toString();
		
	}



	private static Object getMaskedChar(char cString, char cMask) {
		if (cMask=='1'){
			return Character.toUpperCase(cString);
		}		
		return cString;
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
//		System.out.println(getPrint("hello 11001"));
//		System.out.println(getPrint("world 10000"));
//		System.out.println(getPrint("cba 111"));
//
//	}
}
