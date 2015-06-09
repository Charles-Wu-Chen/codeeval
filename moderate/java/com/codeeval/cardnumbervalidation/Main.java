package com.codeeval.cardnumbervalidation;

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

	private static int getPrint(String input) {
		String mInput = input.replace(" ", "");
		int total = 0;
		
		for (int t = mInput.length(); t>0 ; t-- ){
			if ((mInput.length() - t) %2 == 0){
				total  += Integer.valueOf(mInput.substring(t-1, t)); 
			}else {
				int doubleDig = Integer.valueOf(mInput.substring(t-1, t))*2; 
				if (doubleDig > 9){
					total = total + ( doubleDig % 10) + ( doubleDig / 10);
				} else total  += doubleDig;
			}
		}
		
		if (total % 10 ==0 ){
			return 1;
		} else return 0;
	}




	private static String removeLast(String input, String lastChar) {
		String result = input;
		if (input.contains(lastChar)) {
			result = input.substring(0, input.lastIndexOf(lastChar));
		}
		return result;
	}

	// public static void main(String[] args) throws IOException {
	// BufferedReader buffer = null;
	// File file = null;
	// try {
	// file = new File("racingcharinput.txt");
	// buffer = new BufferedReader(new FileReader(file));
	// String line;
	//
	// while ((line = buffer.readLine()) != null) {
	// line = line.trim();
	// System.out.println(getUnique(line));
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// buffer.close();
	// }
	//
	// }
	
//	 public static void main(String[] args) throws IOException {
//	 System.out.println(getPrint("6011 5940 0319 9511"));
//	 System.out.println(getPrint("5537 0213 6797 6815"));
//	 System.out.println(getPrint("5574 8363 8022 9735"));
//	 System.out.println(getPrint("3044 8507 9391 30"));
//	 System.out.println(getPrint("6370 1675 9034 6211 774"));
//	 
//	}
}
