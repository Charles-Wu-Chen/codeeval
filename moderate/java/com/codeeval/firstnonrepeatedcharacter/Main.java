package com.codeeval.firstnonrepeatedcharacter;

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

//	private static String getPrint(String input) {
//		
//		String test = input;
//		while (test.length()>0){
//			String first = test.substring(0,1);
//			if (test.substring(1).contains(first)==false){
//				return first;
//			}else {
//				test = test.replace(first, "");
//			}
//		}
//
//		return "";
//		
//	}
	 public static char getPrint(String string1)
	    {
		 char[] string = string1.toCharArray();
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

	        for (char c : string) {
	            if (!map.containsKey(c)) {
	                map.put(c, 1);
	            } else {
	                map.put(c, map.get(c) + 1);
	            }
	        }

	        for (char c : string) {
	            int count = map.get(c);

	            if (count == 1) {
	                return c;
	            }
	        }

	        throw new IllegalArgumentException();
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

//	public static void main(String[] args) throws IOException {
//		System.out.println(getPrint("yellow"));
//		System.out.println(getPrint("tooth"));
//	}
}
