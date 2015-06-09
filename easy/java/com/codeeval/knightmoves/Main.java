package com.codeeval.knightmoves;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            char col = line.substring(0,1).toCharArray()[0];
            String temp = line.substring(1,2);
            int row = new Integer(temp);
            
            List<String> nextPositions = getNextPositions (col, row);
            StringBuffer tempS = new StringBuffer();
            for (String n : nextPositions){
            	tempS.append(n+" ");
            }

            System.out.println(tempS.toString().trim());
        }
    }
    
    
    public static List<String> getNextPositions (char col, int row){
    	char maxCol = 'h';
    	char minCol = 'a';
    	int maxRow = 8;
    	int minRow = 1;
    	
    	int [][] possibleMove = {{-2,-1},{-2,1},{2,-1},{2,1},{-1,-2},{-1,2},{1,-2},{1,2}};
    	
    	ArrayList<String> nextPositions = new ArrayList<String>();
    	
    	for (int[] t:possibleMove){
    		
    		char newCol = (char) (col + t[0]);
    		int newRow = row+t[1];
    		
    		if (newCol >= minCol && newCol <= maxCol && newRow >= minRow && newRow <= maxRow){
    			nextPositions.add(Character.toString(newCol)+ newRow);
    		}
    	}
//    	
//    	if (col - 2 >= minCol && row -1 >= minRow) nextPositions.add(Character.toString((char)(col - 2)) + (row -1));
//    	
//    	if (col - 2 >= minCol && row + 1 <= maxRow) nextPositions.add(Character.toString((char)(col - 2)) + (row +1));
//    	
//    	if (col - 1 >= minCol && row -2 >= minRow) nextPositions.add(Character.toString((char)(col - 1)) + (row -2));
//    	
//    	if (col - 1 >= minCol && row +2 <= maxRow) nextPositions.add(Character.toString((char)(col - 1)) + (row +2));
//    	
//    	if (col + 1 <= maxCol && row -2 >= minRow) nextPositions.add(Character.toString((char)(col + 1)) + (row -2));
//    	
//    	if (col + 1 <= maxCol && row +2 <= maxRow) nextPositions.add(Character.toString((char)(col + 1)) + (row +2));
//    	
//    	if (col + 2 <= maxCol && row -1 >= minRow) nextPositions.add(Character.toString((char)(col + 2)) + (row -1));
//    	
//    	if (col + 2 <= maxCol && row +1 <= maxRow) nextPositions.add(Character.toString((char)(col + 2)) + (row +1));
    	
    	
    	return nextPositions;
    	
    }
}
