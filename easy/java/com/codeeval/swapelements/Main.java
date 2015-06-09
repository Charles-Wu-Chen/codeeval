package com.codeeval.swapelements;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

				System.out.println(swapelements(line));

		}
	}

	private static String swapelements(String line) {
		String [] inputs = line.split(":");
		String [] inputInts = (inputs[0].trim().split(" "));
		String [] inputComs = (inputs[1].trim().split(","));
 		
		for (int i =0 ; i < inputComs.length; i ++){
			String com = inputComs[i].trim();
			
			int first = Integer.parseInt(com.split("-")[0]);
			int second = Integer.parseInt(com.split("-")[1]);
			
			String temp = inputInts[first];
			inputInts[first] = inputInts[second];
			inputInts[second] = temp;
			
		}
		
		StringBuffer sb = new StringBuffer();
		for (String i : inputInts){
			sb.append(i+ " ");
		}
		
		return sb.toString().trim();
	}

	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		System.out.println(swapelements("1 2 3 4 5 6 7 8 9 : 0-8"));
//		System.out.println(swapelements("1 2 3 4 5 6 7 8 9 10 : 0-1, 1-3"));
//
//	}
}
