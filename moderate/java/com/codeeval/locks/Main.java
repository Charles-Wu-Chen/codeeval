package com.codeeval.locks;

/* Sample code to read in test cases:*/

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
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
		String [] inputArr = input.split(" ");
		int gateNumber = Integer.parseInt(inputArr[0]);
		int stepNumber = Integer.parseInt(inputArr[1]);
		
		BigInteger firstBeatMask = getFirstBeatMask(gateNumber);
		BigInteger secondBeatMask = getSecondBeatMask(gateNumber);
		
		//System.out.println(firstBeatMask.toString(2));
		//System.out.println(secondBeatMask.toString(2));
		
		BigInteger stage = new BigInteger("0");
		
		if (stepNumber > 1){
			if ((stepNumber-1) % 2 == 1){
				stage = stage.or(firstBeatMask).xor(secondBeatMask);
				
			}else {
				stage = stage.or(firstBeatMask).xor(secondBeatMask).or(firstBeatMask).xor(secondBeatMask);
			}
		}
		//last step
		BigInteger finalStage = stage.xor(new BigInteger("1"));
		
		int countOne = countOne(finalStage)	;
		return gateNumber - countOne;
		
	}




	private static int countOne(BigInteger finalStage) {
		int count =0;
		while (finalStage.compareTo(new BigInteger("0"))>0){
			count ++;
			finalStage = finalStage.and(finalStage.subtract(new BigInteger("1")));
		}
		return count;
}




	private static BigInteger getSecondBeatMask(int gateNumber) {
		BigInteger holder = BigInteger.valueOf(0);
		for (int t = 1;  t<=gateNumber; t++){
			holder = holder.shiftLeft(1);
			if (t%3 !=0){
				holder=holder.add(new BigInteger("1"));
			}
		}
		//System.out.println(holder.toString(2));
		return (BigInteger)holder.xor( new BigDecimal(Math.pow(2, gateNumber)).toBigInteger().subtract(new BigInteger("1")));
	}

	private static BigInteger getFirstBeatMask(int gateNumber) {
		if (gateNumber == 1)
			return BigInteger.valueOf(0);
		if (gateNumber == 2){
			return BigInteger.valueOf(1);
		}
		BigInteger holder = BigInteger.valueOf(0);
		for (int t = (gateNumber-1); t >= 0; t=t-2){
			holder = holder.add( new BigDecimal(Math.pow(2, t)).toBigInteger());
		}
		return (BigInteger)holder.xor(new BigDecimal(Math.pow(2, gateNumber)).toBigInteger().subtract(new BigInteger("1")));
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
//	 public static void main(String[] args) throws IOException {
//	 System.out.println(getPrint("3 1"));
//	 System.out.println(getPrint("10 10"));	 
//	 System.out.println(getPrint("100 97"));
//	 System.out.println(getPrint("100 98"));
//	 System.out.println(getPrint("100 99"));
//	 System.out.println(getPrint("100 100"));	 
//	}
}
