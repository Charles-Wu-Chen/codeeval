package com.codeeval.lettercasepercentratio;

/* Sample code to read in test cases:*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	
	
//	public static void main(String[] args) throws IOException {
//		File file = new File(args[0]);
//		BufferedReader buffer = new BufferedReader(new FileReader(file));
//		String line;
//		while ((line = buffer.readLine()) != null) {
//			line = line.trim();
//
//				System.out.println(getPrint(line));
//
//		}
//	}

	private static String getPrint(String line) {
		int lowerCount = 0;
		int inputLength = line.length();
		for (char c : line.toCharArray()){
			if (Character.isLowerCase(c)){
				lowerCount++;
			}
		}
		
		double lowPercent = new BigDecimal((double)lowerCount*100.0d/(double)inputLength)
		.setScale(2, RoundingMode.HALF_UP).doubleValue();
		double upPercent = 100 -lowPercent;
		
		return "lowercase: "+String.format("%.2f", lowPercent)+" uppercase: "+String.format("%.2f", upPercent);
		
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
//	
//	
//	public static void main(String[] args) throws IOException {
//		
//		
//		System.out.println(getPrint("thisTHIS"));
//		System.out.println(getPrint("AAbbCCDDEE"));
//		System.out.println(getPrint("N"));
//		System.out.println(getPrint("UkJ"));
//
//	}
}
