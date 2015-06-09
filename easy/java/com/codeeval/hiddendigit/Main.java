package com.codeeval.hiddendigit;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;


public class Main {
	public static Map matchvalue = new HashMap<String, Integer>();
	
	static{
		
		matchvalue.put("a", 0);
		matchvalue.put("b", 1);
		matchvalue.put("c", 2);
		matchvalue.put("d", 3);
		matchvalue.put("e", 4);
		matchvalue.put("f", 5);
		matchvalue.put("g", 6);
		matchvalue.put("h", 7);
		matchvalue.put("i", 8);
		matchvalue.put("j", 9);
	}
	
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();


				System.out.println(findHidden(line));

			

		}
	}

	private static String findHidden(String line) {
		String testResult = "";
		
		for (int i=0;i<line.length();i++){
			String testC = line.substring(i,i+1);
			
			if (isNumeric(testC)){
				testResult += testC;
			}
			else if (matchvalue.containsKey(testC)){
				testResult += matchvalue.get(testC);
			}
		}
		
		return testResult.equals("")?"NONE":testResult;
	}

	public static boolean isNumeric(String str)
	{
	  return str.matches("\\d");  
	}
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		System.out.println(findHidden("abcdefghik"));
//		System.out.println(findHidden("Xa,}A#5N}{xOBwYBHIlH,#W"));
//		System.out.println(findHidden("(ABW>'yy^'M{X-K}q,"));
//		System.out.println(findHidden("6240488"));
//	
//	}
}
