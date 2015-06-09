package com.codeeval.nmodm;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Main {
	public static Map hexvalue = new HashMap<String, Integer>();
	
	static{
		hexvalue.put("a", 10);
		hexvalue.put("b", 11);
		hexvalue.put("c", 12);
		hexvalue.put("d", 13);
		hexvalue.put("e", 14);
		hexvalue.put("f", 15);
		hexvalue.put("0", 0);
		hexvalue.put("1", 1);
		hexvalue.put("2", 2);
		hexvalue.put("3", 3);
		hexvalue.put("4", 4);
		hexvalue.put("5", 5);
		hexvalue.put("6", 6);
		hexvalue.put("7", 7);
		hexvalue.put("8", 8);
		hexvalue.put("9", 9);
	}
	
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();


				System.out.println(hextodec(line));

			

		}
	}

	private static int hextodec(String line) {
		int testResult = 0;
		
		testResult = hextodecRecursive(line, 0);
		
		return testResult;
	}

	private static int hextodecRecursive(String line, int i) {
		// TODO Auto-generated method stub
		if (line.length() == (i+1)){
			return (Integer)hexvalue.get(line.substring(i));
		}
		return (Integer)hexvalue.get(line.substring(i, i+1))*(int)Math.pow(16, line.length()-i-1) + hextodecRecursive(line, i+1);
	}

	
	
	
//	
//	public static void main(String[] args) throws IOException {
//		System.out.println(hextodec("9f"));
//		System.out.println(hextodec("11"));
//		System.out.println(hextodec("fffff"));
//		
//
//	}
}
