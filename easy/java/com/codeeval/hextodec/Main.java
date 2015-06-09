package com.codeeval.hextodec;

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


				System.out.println(nmodm(line));

			

		}
	}

	private static int nmodm(String line) {
		int n = Integer.parseInt(line.split(",")[0]);
		int m = Integer.parseInt(line.split(",")[1]);
		return n - m*(n/m);

	}

	
	
	
	
//	public static void main(String[] args) throws IOException {
//		System.out.println(nmodm("20,6"));
//		System.out.println(nmodm("2,3"));
//
//
//	}
}
