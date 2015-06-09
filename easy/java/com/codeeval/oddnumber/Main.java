package com.codeeval.oddnumber;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		for (int i = 1; i <=99; i++){
			int m = i % 2;
			if (m != 0){
				System.out.println(i);
			}
		}
	}

	
	
	
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		System.out.println(bitposition("86,2,3"));
//		System.out.println(bitposition("125,1,2"));
//
//	}
}
