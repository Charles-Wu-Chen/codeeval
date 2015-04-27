package com.codeeval.comparepoints;

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
		return checkPosition(Integer.parseInt(inputs[2]) - Integer.parseInt(inputs[0]), Integer.parseInt(inputs[3]) - Integer.parseInt(inputs[1]));
		
		
		
		
		
	}

	

	private static String checkPosition(int x, int y) {
		if (x == 0 && y ==0){
			return "here";
		}else if (x == 0 && y > 0){
			return "N";
		}else if (x == 0 && y < 0){
			return "S";
		}else if (x > 0 && y ==0){
			return "E";
		}else if (x < 0 && y ==0){
			return "W";
		}else if (x > 0 && y > 0){
			return "NE";
		}else if (x > 0 && y < 0){
			return "SE";
		}else if (x < 0 && y > 0){
			return "NW";
		}else if (x < 0 && y < 0){
			return "SW";
		}
		return "";
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
//		
//		
//		System.out.println(getPrint("0 0 1 5"));
//		System.out.println(getPrint("12 13 12 13"));
//		System.out.println(getPrint("0 1 0 5"));
//
//	}
}
