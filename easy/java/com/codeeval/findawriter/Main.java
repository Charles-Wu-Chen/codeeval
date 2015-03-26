package com.codeeval.findawriter;

/* Sample code to read in test cases:*/

import java.io.*;
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
		String inputStr = line.split("\\|")[0];
		String inputNum = line.split("\\|")[1];
		StringBuffer sb = new StringBuffer();
		String [] inputNumArr = inputNum.trim().split(" ");
		
		for (String tmp: inputNumArr){
			int pos = Integer.parseInt(tmp);
			sb.append(inputStr.charAt(pos-1));
		}
		
		return sb.toString();
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
	
	public static void main(String[] args) throws IOException {
		
		
		System.out.println(getPrint("osSE5Gu0Vi8WRq93UvkYZCjaOKeNJfTyH6tzDQbxFm4M1ndXIPh27wBA rLclpg| 3 35 27 62 51 27 46 57 26 10 46 63 57 45 15 43 53"));
		System.out.println(getPrint("3Kucdq9bfCEgZGF2nwx8UpzQJyHiOm0hoaYP6ST1WM7Nks5XjrR4IltBeDLV vA| 2 26 33 55 34 50 33 61 44 28 46 32 28 30 3 50 34 61 40 7 1 31"));

	}
}
