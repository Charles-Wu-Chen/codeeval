package com.codeeval.setintersection;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

				System.out.println(getIntersections(line));

		}
	}

	private static String getIntersections(String line) {
		String [] inputs = line.split(";");
		String [] firstArr = inputs[0].split(",");
		String [] secondArr = inputs[1].split(",");

		StringBuffer sb = new StringBuffer();
		int firstStart = Integer.parseInt(firstArr[0]);
		int firstEnd = Integer.parseInt(firstArr[firstArr.length-1]);
		int secondStart = Integer.parseInt(secondArr[0]);
		int secondEnd = Integer.parseInt(secondArr[secondArr.length-1]);
		
		if (firstEnd >= secondStart && secondEnd >= firstStart){
			int [] ints = {firstStart, firstEnd, secondStart, secondEnd};
			Arrays.sort(ints);
			for (int i = ints[1]; i<= ints[2]; i++){
				if (Arrays.asList(firstArr).contains(i+"") && Arrays.asList(secondArr).contains(i+"") )
					sb.append(i+ ",");
			}
			if (sb.length() > 0)
				return sb.substring(0,sb.lastIndexOf(","));
		}
		return sb.toString();
	}

//	
//	
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader buffer = null;
//		File file = null;
//		try {
//			file = new File("setIntersectionsinput.txt");
//			buffer = new BufferedReader(new FileReader(file));
//			String line;
//			
//			List<String> raceGround = new ArrayList<String>();
//			while ((line = buffer.readLine()) != null) {
//				line = line.trim();
//				System.out.println(getIntersections(line));
//			}
//			
//
//		}catch (Exception e){
//			e.printStackTrace();
//		}finally {
//			buffer.close();
//		}
//
//	}
}
