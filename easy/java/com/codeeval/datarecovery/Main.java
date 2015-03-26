package com.codeeval.datarecovery;

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

	private static String getPrint(String line) {
		String input1 = line.split(";")[0];
		String input2 = line.split(";")[1];
		
		String [] wordArr = input1.split(" ");
		
		String [] keyArr = input2.split(" ");
		

		List<String> wordList = new LinkedList<String>(Arrays.asList(wordArr));
		
		StringBuffer sb = new StringBuffer();
		
		int maxLoop = keyArr.length;
		
		if (keyArr.length >wordArr.length) {
			maxLoop = wordArr.length;
		}
		
		String [] resultArr =  new String [wordArr.length];
		for (int i = 0; i< maxLoop; i++){
			resultArr [Integer.parseInt(keyArr[i])-1] = (wordArr[i]+ " ");
			
			wordList.remove(wordArr[i]);
		}
		
			for (int t = 0; t <wordArr.length; t++){
				if (resultArr[t] != null)
					sb.append(resultArr[t]);
				else {
					sb.append(wordList.get(0)+" ");
					wordList.remove(0);
				}
			}
	
			
		
		return removeLast(sb.toString(), " ");
		
		
		
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
//		
//		
//		System.out.println(getPrint("2000 and was not However, implemented 1998 it until;9 8 3 4 1 5 7 2"));
//		System.out.println(getPrint("programming first The language;3 2 1"));
//		System.out.println(getPrint("programs Manchester The written ran Mark 1952 1 in Autocode from;6 2 1 7 5 3 11 4 8 9"));
//
//	}
}
