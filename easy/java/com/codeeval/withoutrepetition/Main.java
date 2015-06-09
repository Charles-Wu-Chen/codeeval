package com.codeeval.withoutrepetition;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Main {
	
	
//	public static void main(String[] args) throws IOException {
//		File file = new File(args[0]);
//		BufferedReader buffer = new BufferedReader(new FileReader(file));
//		String line;
//		while ((line = buffer.readLine()) != null) {
//			line = line.trim();
//
//				System.out.println(removeRepetition(line));
//
//		}
//	}

	private static String removeRepetition(String line) {

		StringBuffer sb = new StringBuffer();
		if (line.length() <= 1 ){
			return line;
		}
		
		char first = line.charAt(0);
		sb.append(first);
		
		for (int i = 1; i< line.length(); i++){
			char test = line.charAt(i);
			if (test != first){
				sb.append(test);
				first = test;
			}
			
			
		}

		return sb.toString();
	}

	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		System.out.println(removeRepetition("Shellless mollusk lives in wallless house in wellness. Aaaarrghh!"));
//		System.out.println(removeRepetition("But as he spake he drew the good sword from its scabbard, and smote a heathen knight, Jusssstin of thee Iron Valley."));
//		System.out.println(removeRepetition("No matttter whom you choose, she deccccclared, I will abide by your decision."));
//		System.out.println(removeRepetition("Wwwhat is your will?"));
//		System.out.println(removeRepetition("At his magic speech the ground oppened and he began the path of descent."));
//		System.out.println(removeRepetition("I should fly away and you would never see me again."));
//
//	}
}
