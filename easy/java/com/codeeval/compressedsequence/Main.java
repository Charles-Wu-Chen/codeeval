package com.codeeval.compressedsequence;

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


				System.out.println(compress(line));

			

		}
	}

	private static String compress(String line) {
		StringBuffer sb = new StringBuffer();
		int count = 0;
		int pNum =Integer.parseInt(line.split(" ")[0]);
		
		for (String str : line.split(" ")){
			int cNum = Integer.parseInt(str);
			if (cNum == pNum){
				count ++;
			} else {
				
				sb.append(count+" "+pNum+" ");
				count = 1;
				pNum = cNum;
			}
			
		}
		sb.append(count+" "+pNum+" ");
		return sb.toString().trim();

	}

	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		System.out.println(compress("40 40 40 40 29 29 29 29 29 29 29 29 57 57 92 92 92 92 92 86 86 86 86 86 86 86 86 86 86"));
//		System.out.println(compress("73 73 73 73 41 41 41 41 41 41 41 41 41 41"));
//		System.out.println(compress("1 1 3 3 3 2 2 2 2 14 14 14 11 11 11 2"));
//		System.out.println(compress("7"));
//
//	}
}
