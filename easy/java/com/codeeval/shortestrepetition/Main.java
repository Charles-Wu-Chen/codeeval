package com.codeeval.shortestrepetition;

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


				System.out.println(getShortestRep(line));

			

		}
	}

	private static int getShortestRep(String line) {
		int shortestRep = 1;
		String rep = line.substring(0,shortestRep);
		
		while (line.split(rep).length >0) {
			shortestRep++;
			rep = line.substring(0,shortestRep);
		}
		

		
		return shortestRep;
	}

	
	
//	
//	public static void main(String[] args) throws IOException {
////		System.out.println(hextodec("9f"));
////		System.out.println(hextodec("11"));
////		System.out.println(hextodec("fffff"));
//		
//		System.out.println("bcbcbcbcbcbcbcbcbcbcbcbcbcbc".split("bc").length);
//		System.out.println("dddddddddddddddddddd".split("d").length);
//		System.out.println("adcdefg".split("adcdefg").length);
//		System.out.println("abcabcabcabc".split("abc").length);
//		System.out.println(getShortestRep("bcbcbcbcbcbcbcbcbcbcbcbcbcbc"));
//		System.out.println(getShortestRep("dddddddddddddddddddd"));
//		System.out.println(getShortestRep("adcdefg"));
//		System.out.println(getShortestRep("abcabcabcabc"));
//		
//	}
}
