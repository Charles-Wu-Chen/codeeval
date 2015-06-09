package com.codeeval.majorelement;

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


				System.out.println(getMajorElement(line));

			

		}
	}

	private static  String getMajorElement(String line) {
		int[] countArr = new int [101] ;
		String ret = "None";
		String [] inputArr = line.split(",");
		int inputLength = inputArr.length;
		for (String inputStr : inputArr){
			int input = Integer.parseInt(inputStr);
			countArr[input] +=1;
			if (countArr[input] > inputLength/2 ){
				return input+"";
			}
		}
		
		return ret;
		
		
		
	}
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		System.out.println(getMajorElement("1,1"));
//		System.out.println(getMajorElement("1,1,2"));
//
//		System.out.println(getMajorElement("1,1,2,2"));
//		System.out.println(getMajorElement("1,1,2,2,3"));
//		System.out.println(getMajorElement("1,1,2,2,3,1"));
//		
//	}
}
