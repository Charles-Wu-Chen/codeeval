package com.codeeval.sumtozero;

import java.util.Arrays;

public class Combinations {
	private StringBuilder output = new StringBuilder();
	private final String inputstring;

	public Combinations(final String str) {
		inputstring = str;
		System.out.println("The input string  is  : " + inputstring);
	}

	public static void main(String args[]) {
		Combinations combobj = new Combinations("wxyz");
		System.out.println("");
		System.out.println("");
		System.out.println("All possible combinations are :  ");
		System.out.println("");
		System.out.println("");
		combobj.combine();
		
		
		int N = 4;
	       String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	       String elements = alphabet.substring(0, N);
	       System.out.println();
	       // using first implementation
	       comb1(elements);
	       System.out.println();

	       // using second implementation
	       comb2(elements);
	       System.out.println();
	       
	       //3 out of 3
	       String[] arr = {"A","B","C"};
	        combinations2(arr, 3, 0, new String[3]);
	}

	public void combine() {
		combine(0);
	}

	private void combine(int start) {
		for (int i = start; i < inputstring.length(); ++i) {
			output.append(inputstring.charAt(i));
			System.out.println(output);
			if (i < inputstring.length())
				combine(i + 1);
			output.setLength(output.length() - 1);
		}
	}
	
	
	// print all subsets of the characters in s
    public static void comb1(String s) { comb1("", s); }

    // print all subsets of the remaining elements, with given prefix 
    private static void comb1(String prefix, String s) {
        if (s.length() > 0) {
            System.out.println(prefix + s.charAt(0));
            comb1(prefix + s.charAt(0), s.substring(1));
            comb1(prefix,               s.substring(1));
        }
    }  

    // alternate implementation
    public static void comb2(String s) { comb2("", s); }
    private static void comb2(String prefix, String s) {
        System.out.println(prefix);
        for (int i = 0; i < s.length(); i++)
            comb2(prefix + s.charAt(i), s.substring(i + 1));
    }  

    
    static void combinations2(String[] arr, int len, int startPosition, String[] result){
        if (len == 0){
            System.out.println(Arrays.toString(result));
            return;
        }       
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }       

}