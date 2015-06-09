package com.codeeval.readmore;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	private static int maxLength = 55;
	private static String READ_MORE = "... <Read More>";
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();


				System.out.println(massage(line));

			

		}
	}

	private static String massage(String line) {
		String massageResult = "";
		
		if (line.length() <= maxLength){
			massageResult = line;
		} else {
			String tempResult  = line.substring(0, 40);
			int spaceIndex = tempResult.lastIndexOf(" ");
			if (spaceIndex >= 0){
				tempResult = line.substring(0, spaceIndex).trim();
			} 
			massageResult = tempResult + READ_MORE;	
		}
		
		return massageResult;
	}

	
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader buffer = null;
//		File file = null;
//		try {
//			file = new File("readmoreinput.txt");
//			buffer = new BufferedReader(new FileReader(file));
//			String line;
//			
//			while ((line = buffer.readLine()) != null) {
//				line = line.trim();
//				System.out.println(massage(line));
//			}
//			
//		}catch (Exception e){
//			e.printStackTrace();
//		}finally {
//			buffer.close();
//		}
//
//	}
}
