package com.codeeval.querytable;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static int maxCol = 255;
	private static int maxRow = 255;

	public static int[][] board = new int[maxRow+1][maxCol+1];

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			executeCommand(line);
		}
	}

	private static void executeCommand(String line) {
		// SetCol 32 20
		// SetRow 16 31
		// QueryCol 32
		String [] inputs = line.split(" ");
		if ("SetCol".equals(inputs[0])) {
			int col = new Integer(inputs[1]);
			int colvalue = new Integer(inputs[2]);
			setColValue(col, colvalue);
		}
		if ("SetRow".equals(inputs[0])) {
			int col = new Integer(inputs[1]);
			int colvalue = new Integer(inputs[2]);
			setRowValue(col, colvalue);
		}
		if ("QueryCol".equals(inputs[0])) {
			int col = new Integer(inputs[1]);
			queryCol(col);
		}
		if ("QueryRow".equals(inputs[0])) {
			int col = new Integer(inputs[1]);
			queryRow(col);
		}

	}

	private static void queryRow(int row) {
		int result = 0;
		for (int i = 0; i <= maxRow; i++) {
			result += board[row][i];
		}

		System.out.println(result);
	}

	private static void queryCol(int col) {
		int result = 0;
		for (int i = 0; i <= maxCol; i++) {
			result += board[i][col];
		}

		System.out.println(result);

	}

	private static void setColValue(int col, int colvalue) {
		for (int i = 0; i <= maxCol; i++) {
			board[i][col] = colvalue;
		}

	}

	private static void setRowValue(int row, int rowvalue) {
		for (int i = 0; i <= maxCol; i++) {
			board[row][i] = rowvalue;
		}

	}

//	public static void main(String[] args) throws IOException {
//		executeCommand("SetCol 32 20");   
//		executeCommand("SetRow 15 7");    
//		executeCommand("SetRow 16 31");   
//		executeCommand("QueryCol 32");    
//		executeCommand("SetCol 2 14");    
//		executeCommand("QueryRow 10");    
//		executeCommand("SetCol 14 0");    
//		executeCommand("QueryRow 15");    
//		executeCommand("SetRow 10 1");    
//		executeCommand("QueryCol 2");     
//
//
//	}
}
