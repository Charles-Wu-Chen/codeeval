package com.codeeval.simplesorting;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
		StringBuffer sb = new StringBuffer ();
		String [] inputStr = line.split(" ");
		double [] inputDouble = new double[inputStr.length];
		for (int pos = 0; pos < inputStr.length; pos++){
			inputDouble[pos]=Double.parseDouble(inputStr[pos]);
		}
		
		Arrays.sort(inputDouble);
		
		for (double b : inputDouble){
			sb.append(String.format("%.3f", b)+ " ");
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
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = null;
		File file = null;
		try {
			file = new File("simplesortinginput.txt");
			buffer = new BufferedReader(new FileReader(file));
			String line;

			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				System.out.println(getPrint(line));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			buffer.close();
		}

	}
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		System.out.println(getPrint("-38.797 7.581 14.354 70.920 90.374 99.323"));
//		System.out.println(getPrint("-55.552 -37.507 -3.263 27.999 40.079 65.213"));
//
//	}
}
