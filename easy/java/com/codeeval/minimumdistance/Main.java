package com.codeeval.minimumdistance;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		String [] input1 = line.split(" ");
		ArrayList<Integer> inputInts = new ArrayList<Integer>();
		
		for (String input : input1){
			inputInts.add(Integer.parseInt(input));
		}
		
		inputInts.remove(0);
		
		int max = Collections.max(inputInts);
		int min = Collections.min(inputInts);
		
		int finalDistance = Integer.MAX_VALUE;
		
		for (int i = min; i<=max; i++){
			int distance = getDistance(i, inputInts);
			if (distance >= finalDistance){
				return finalDistance;
			}else {
				finalDistance = distance;
			}
		}
		return finalDistance;
		
	}

	

	private static int getDistance(int i, ArrayList<Integer> inputInts) {
		int distance = 0;
		for (int test : inputInts){
			distance += Math.abs(i - test);
		}

		return distance;
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
//		System.out.println(getPrint("4 3 3 5 7"));
//		System.out.println(getPrint("3 20 30 40"));
//	}
}
