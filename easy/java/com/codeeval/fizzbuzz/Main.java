package com.codeeval.fizzbuzz;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
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
		int x = Integer.parseInt(line.split(" ")[0]);
		int y = Integer.parseInt(line.split(" ")[1]);
		int count = Integer.parseInt(line.split(" ")[2]);
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 1; i<=count; i++){
			sb.append(check(i, x, y)+" ");
		}
		return sb.toString().trim();
	}

	

	private static String check(int i, int x, int y) {
		String result = "";
		
		if (i%x==0){
			result = "F";
		}
		if (i%y == 0){
			result = result+"B";
		}
		if (result.equals("")){
			result = i+"";
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
//		
//		System.out.println(getPrint("3 5 10"));
//		System.out.println(getPrint("2 7 15"));
//
//	}
}
