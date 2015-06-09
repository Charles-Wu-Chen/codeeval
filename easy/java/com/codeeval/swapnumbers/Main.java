package com.codeeval.swapnumbers;

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
		StringBuffer sb = new StringBuffer();
		for (String input : inputs){
			StringBuffer tmpSb = new StringBuffer(input);
			tmpSb.replace(0, 1, input.substring(input.length()-1, input.length()));
			tmpSb.replace(input.length()-1, input.length(), input.substring(0, 1));
			sb.append(tmpSb);
			sb.append(" ");
			
		}
			
		
		return removeLast(sb.toString(), " ");
		
		
		
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
//		
//		
//		System.out.println(getPrint("4Always0 5look8 4on9 7the2 4bright8 9side7 3of8 5life5"));
//		System.out.println(getPrint("5Nobody5 7expects3 5the4 6Spanish4 9inquisition0"));
//		
//	}
}
