package com.codeeval.romannumerals;

/* Sample code to read in test cases:*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			System.out.println(transformNumToRomanString(line));

		}
	}

	public static List<RomanNumber> getDescSortedRomanList() {
		List<RomanNumber> numberList = new ArrayList<RomanNumber>();
		for (RomanNumber day : RomanNumber.values()) {
			numberList.add(day);
		}
		Collections.sort(numberList, new Comparator<RomanNumber>() {
			public int compare(RomanNumber rn1, RomanNumber rn2) {
				return Integer.signum(rn2.getValue() - rn1.getValue()); 
			}
		});

		return numberList;
	}

	public static String transformNumToRomanString(String line) {
		int inputNum = Integer.parseInt(line);
		StringBuffer sb = new StringBuffer();
		List<RomanNumber> testList = getDescSortedRomanList();
		while (inputNum > 0) {
			testList = getValidTestList(inputNum, testList);

			inputNum = handleFirstChar(inputNum, sb, testList);
		}
		return sb.toString();
	}

	private static int handleFirstChar(int inputNum, StringBuffer sb,
			List<RomanNumber> testList) {
		sb.append(testList.get(0).getDisplay());
		
		return inputNum - testList.get(0).getValue();
	}

	private static List<RomanNumber> getValidTestList(int inputNum,
			List<RomanNumber> testList) {

		Iterator<RomanNumber> iter = testList.iterator();
		while (iter.hasNext() && iter.next().getValue()>inputNum) {
			
				iter.remove();
		}

		return testList;
	}

//	public static void main(String[] args) throws IOException {
//		List test = getDescSortedRomanList();
//		System.out.println(Arrays.toString(test.toArray()));
//		
//		List test2 = getValidTestList(3000,
//				test);
//		System.out.println(Arrays.toString(test2.toArray()));
//		List test3 = getValidTestList(900,
//				test);
//		System.out.println(Arrays.toString(test3.toArray()));
//		List test4 = getValidTestList(123,
//				test);
//		System.out.println(Arrays.toString(test4.toArray()));
//		
//		System.out.println(transformNumToRomanString("123"));
//		System.out.println(transformNumToRomanString("159"));
//		System.out.println(transformNumToRomanString("296"));
//		System.out.println(transformNumToRomanString("3992"));
//		
//		//CXXIII
//		//CLIX
//		//CCXCVI
//		//MMMCMXCII
//	}
}

enum RomanNumber {
	I(1, "I"), IV(4, "IV"), V(5, "V"), IX(9, "IX"), X(10, "X"), XL(40, "XL"), L(
			50, "L"), XC(90, "XC"), C(100, "C"), CD(400, "CD"), D(500, "D"), CM(
			900, "CM"), M(1000, "M");

	private final int value;
	private final String display;

	RomanNumber(int value, String display) {
		this.value = value;
		this.display = display;
	}

	public int getValue() {
		return value;
	}

	public String getDisplay() {
		return display;
	}
}
