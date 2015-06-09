package com.codeeval.racingchar;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {


	
//	public static void main(String[] args) throws IOException {
//		File file = new File(args[0]);
//		BufferedReader buffer = new BufferedReader(new FileReader(file));
//		String line;
//		
//		List<String> raceGround = new ArrayList<String>();
//		while ((line = buffer.readLine()) != null) {
//			line = line.trim();
//			raceGround.add(line);
//		}
//		
//		generateRaceRoute(raceGround);
//		printRaceRoute(raceGround);
//	}

	private static void printRaceRoute(List<String> raceGround) {
		for (String route : raceGround){
			System.out.println(route);
		}
		
	}

	private static void generateRaceRoute(List<String> raceGround) {

		if (raceGround.size() ==1){
			//handle only 1 input line condition
			String input = raceGround.get(0);
			int index = getStartIndex(input);
			if (index >= 0){
				raceGround.set(0, input.substring(0,index)+"|"+input.substring(index+1));
				return;
			}

		}
		
		
		int startIndex=0;
		int endIndex=0;
		
		for (int i = 1; i < raceGround.size(); i++){
			String startLine = raceGround.get(raceGround.size()-i);
			String endLine = raceGround.get(raceGround.size()-i-1);
			
			startIndex = getStartIndex(startLine);
			endIndex = getEndIndex(startIndex, endLine);
			if (endIndex < 0) {
				raceGround.set(0, startLine.substring(0,startIndex)+"|"+startLine.substring(startIndex+1));
				break;
			}
			String getRouteStr = getRouteStr(startIndex, endIndex);
			
			raceGround.set(raceGround.size()-i, startLine.substring(0,startIndex)+getRouteStr+startLine.substring(startIndex+1));
		}
		//for the first line (last exit)
		raceGround.set(0, raceGround.get(0).substring(0,endIndex)+"|"+ raceGround.get(0).substring(endIndex+1));
	}

	private static String getRouteStr(int startIndex, int endIndex) {
		String routeStr = "";
		if (startIndex < endIndex){ routeStr = "/";}
		else if (startIndex == endIndex){routeStr = "|";}
		else {routeStr = "\\"; }
		return routeStr;
	}

	private static int getEndIndex(int startIndex, String endLine) {
		int endIndex = -1;
		
		for (int i = -1; i<=1;i++){
			if (startIndex + i >= 0) {
				if (endLine.substring(startIndex + i, startIndex + i +1).equals("C")){
					return startIndex + i;
				}
			}
		}
		
		for (int i = -1; i<=1;i++){
			if (startIndex + i >= 0) {
				if (endLine.substring(startIndex + i, startIndex + i +1).equals("_")){
					return startIndex + i;
				}
			}
		}
		
		return endIndex;
	}

	private static int getStartIndex(String startLine) {
		int index = -1;
		index = startLine.indexOf("C");
		if (index >= 0){
			
			return index;
		}
		index = startLine.indexOf("_");
		if (index >= 0){
			
			return index;
		}
		return index;
	}




	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = null;
		File file = null;
		try {
			file = new File("racingcharinput.txt");
			buffer = new BufferedReader(new FileReader(file));
			String line;
			
			List<String> raceGround = new ArrayList<String>();
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				raceGround.add(line);
			}
			
			generateRaceRoute(raceGround);
			printRaceRoute(raceGround);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			buffer.close();
		}

	}
}
