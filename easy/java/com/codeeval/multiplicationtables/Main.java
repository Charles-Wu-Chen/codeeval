package com.codeeval.multiplicationtables;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	private static final int size = 12;
	private static final int placeholderSize= 4;
	public static void main(String[] args) throws IOException {
		

				getPrint();

		
	}

	private static void getPrint() {
		for (int r = 1; r<=size; r++){
			StringBuffer sb = new StringBuffer();
			for (int c= 1; c<=size; c++){
				System.out.print(String.format("%4d", r*c));
			}
			System.out.println();
		}
		
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
//		System.out.println(getPrint("19"));
//		System.out.println(getPrint("0"));
//
//	}
}
