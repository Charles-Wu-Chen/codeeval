package com.codeeval.niceangles;

/* Sample code to read in test cases:*/

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			System.out.println(getAngle(line));

		}
	}

	private static String getAngle(String line) {
		BigDecimal input = new BigDecimal(line);
		StringBuffer sb = new StringBuffer();
		BigDecimal iPart = input.divideToIntegralValue(BigDecimal.ONE);
		sb.append(iPart.intValue());

		BigDecimal fPart = input.subtract(iPart);
		sb.append(".");
		BigDecimal minute = fPart.multiply(new BigDecimal(60));
		BigDecimal minutePart = minute.divideToIntegralValue(BigDecimal.ONE);
		if (minutePart.compareTo(BigDecimal.TEN) < 0) {
			sb.append(0);
		}
		sb.append(minutePart.intValue() + "'");
		BigDecimal secondPart = minute.subtract(minutePart);
		BigDecimal second = secondPart.multiply(new BigDecimal(60));
		BigDecimal secondIntPart = second.divideToIntegralValue(BigDecimal.ONE);
		if (secondIntPart.compareTo(BigDecimal.TEN) < 0) {
			sb.append(0);
		}
		sb.append(secondIntPart.intValue() + "\"");

		return sb.toString();
	}

//	public static void main(String[] args) throws IOException {
//
//		System.out.println(getAngle("330.39991833"));
//		System.out.println(getAngle("0.001"));
//		System.out.println(getAngle("14.64530319"));
//		System.out.println(getAngle("0.25"));
//		System.out.println(getAngle("254.16991217"));
//		System.out.println(getAngle("254"));
//
//	}
}
