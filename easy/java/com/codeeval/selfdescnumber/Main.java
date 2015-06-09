package com.codeeval.selfdescnumber;

/* Sample code to read in test cases:*/

import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();


				System.out.println(checkValidNumber(line));

			

		}
	}

	private static int checkValidNumber(String line) {
		int [] valueCount = new int [line.length()];

		try{
			for (int pos = 0; pos < line.length(); pos++) {
				int pos_val = new Integer(line.substring(pos, pos + 1));
				valueCount[pos_val] = valueCount[pos_val]+1;
			}
		}catch (ArrayIndexOutOfBoundsException aoe){
			return 0;
		}
		
		return numberFormat(valueCount).equals(line)?1:0;
	}

	private static String numberFormat(int[] valueCount) {
		String result = "";
		for (int v : valueCount){
			result += (v+"");
		}
		return result;
		
	}
	
	
//	public static void main(String[] args) throws IOException {
//		System.out.println(checkValidNumber("1210"));
//		System.out.println(checkValidNumber("2020"));
//		System.out.println(checkValidNumber("22"));
//		
//
//	}
}
