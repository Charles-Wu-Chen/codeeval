package com.codeeval.lowestunique;

/* Sample code to read in test cases:*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

				System.out.println(lowestUnique(line));

		}
	}

	private static int lowestUnique(String line) {
			
		String trimLine = line.replace(" ", "");
		for (int i = 1; i<=9 ;i ++){
			String newLine = line.replace(i+"", "");
			if ((line.length() - newLine.length()) == 1) {
				return trimLine.indexOf(i+"")+1;
			}
		}
		return 0;
	}

	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		
//
//		System.out.println(lowestUnique("3 3 9 1 6 5 8 1 5 3"));
//		System.out.println(lowestUnique("9 2 9 9 1 8 8 8 2 1 1"));
//
//	}
}
