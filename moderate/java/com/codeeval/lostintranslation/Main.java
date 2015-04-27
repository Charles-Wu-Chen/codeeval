package com.codeeval.lostintranslation;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	private static Map <String, String> defMap = new HashMap<String, String>();
	
	static {
		defMap.put("a", "y");
		defMap.put("b", "h");
		defMap.put("c", "e");
		defMap.put("d", "s");
		defMap.put("e", "o");
		defMap.put("f", "c");
		defMap.put("i", "d");
		defMap.put("j", "u");
		defMap.put("k", "i");
		defMap.put("l", "g");
		defMap.put("m", "l");
		defMap.put("n", "b");
		defMap.put("o", "k");
		defMap.put("p", "r");
		defMap.put("q", "z");
		defMap.put("r", "t");
		defMap.put("s", "n");
		defMap.put("t", "w");
		defMap.put("u", "j");
		defMap.put("v", "p");
		defMap.put("w", "f");
		defMap.put("x", "m");
		defMap.put("y", "a");
		defMap.put("z", "q");
		defMap.put("g", "v");
		defMap.put("h", "x");
	}
	
	public static void main(String[] args) throws IOException {
//		
//		String input1 = "rbc vjnmkf kd yxyqci na rbc zjkfoscdd ew rbc ujllmcptc rbkso rbyr ejp mysljylc kd kxveddknmc re jsicpdryside kr kd eoya kw aej icfkici re zjkr";
//		String input2 = "the public is amazed by the quickness of the jugglerwe think that our language is impossible to understandso it is okay if you decided to quit";
//		
//		Map<String, String> t = new HashMap<String, String>();
//		for (int i = 0; i<input1.length(); i++){
//			t.put(input1.substring(i,i+1), input2.substring(i,i+1));
//		}
//		
//		Set<String> ks =  t.keySet();
//		
//		List<String> kl = new ArrayList();
//		kl.addAll(ks);
//		
//		Collections.sort(kl);
//		
//		for (String key : kl){
//			System.out.printf("%s, %s\n", key, t.get(key)); 
//		}
//		
		
		
		
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			System.out.println(getPrint(line));

		}
	}

	private static String getPrint(String input) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i<input.length(); i++){
			String t = input.substring(i,i+1);
			if (defMap.containsKey(t)){
				sb.append(defMap.get(t));
			}else {
				sb.append(t);
			}
		
		}
		return sb.toString();
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
	
	
	
	
//	 public static void main(String[] args) throws IOException {
//	 System.out.println(getPrint("rbc vjnmkf kd yxyqci na rbc zjkfoscdd ew rbc ujllmcp"));
//	 System.out.println(getPrint("tc rbkso rbyr ejp mysljylc kd kxveddknmc re jsicpdrysi"));
//	 System.out.println(getPrint("de kr kd eoya kw aej icfkici re zjkr"));
//	}
}
