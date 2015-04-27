package com.codeeval.sumtozero;

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

private static int count = 0;
	 public static int getPrint(String input)
	    {
		 count = 0;
		 String [] inputs = input.split(",");
		comb(inputs, 4, 0, new String[4]);

				
		System.out.println( );
		return count;
		
	    }

	 
	 

	private static void comb(String[] inputs, int len, int start, String[] elements) {
		if (len <= 0){
			//System.out.println(Arrays.toString(elements));
			if (calculateSum(elements) == 0){
				
				count ++;
			}
			
			return;
		}
		
		for (int i = start; i<=inputs.length-len; i++){
			elements[elements.length-len] = inputs[i];
			comb(inputs, len-1, i+1, elements);
		}
	}


	private static int calculateSum(String[] elements) {
		int sum = 0;
		for (String s :elements){
			sum+=Integer.parseInt(s);
		}
		return sum;
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

	
	
	
//	
//	
//	public static void main(String[] args) throws IOException {
//		System.out.println(getPrint("2,3,1,0,-4,-1"));
//		System.out.println(getPrint("0,-1,3,-2"));
//	}
}
