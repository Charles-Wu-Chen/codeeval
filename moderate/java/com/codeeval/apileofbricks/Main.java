package com.codeeval.apileofbricks;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

//	public static void main(String[] args) throws IOException {
//		File file = new File(args[0]);
//		BufferedReader buffer = new BufferedReader(new FileReader(file));
//		String line;
//		while ((line = buffer.readLine()) != null) {
//			line = line.trim();
//
//			System.out.println(getPrint(line));
//
//		}
//	}
	
//[-1,-5] [5,-2]|(1 [4,7,8] [2,9,0]);(2 [0,7,1] [5,9,8])
	private static String getPrint(String input) {
		String holeStr = input.split("\\|")[0];
		String [] inputHole = holeStr.split("\\[|\\] \\[|\\]");
		int [][] holePos = new int[2][2];
		int count = 0;
		for (String i : inputHole){
			if (i !=null && !i.equals("")){
				holePos [count][0] = Integer.parseInt(i.substring(0, i.indexOf(",")));
				holePos [count][1] = Integer.parseInt(i.substring(i.indexOf(",")+1).trim());	
				count++;
			}
		}
		
		int longerL = Math.abs(holePos[0][0] - holePos[1][0] );
		int shorterL = Math.abs(holePos[0][1] - holePos[1][1] );
		
		if (longerL < shorterL){
			int temp = shorterL;
			shorterL = longerL;
			longerL = temp;
		}
		
		
		String bricksStr = input.split("\\|")[1];
		HashMap<String, Brick> bricks = new HashMap<String, Brick>();
		
		String [] inputBricks = bricksStr.split(";");
		for (String inputStr : inputBricks){
			String[] singleBrickVar = inputStr.split("\\(|\\[|\\] \\[|\\]\\)");
			String hashKey = "";
			Point [] points = new Point[2];
			int c = 0;
			for (String brickVar : singleBrickVar){
				if (brickVar !=null && !brickVar.equals("")){
					if (isNumeric (brickVar.trim())){
						hashKey = brickVar.trim();
					} else {
						String [] coor = brickVar.split(",");
						points[c ++] = new Point (Integer.parseInt(coor[0]),
								Integer.parseInt(coor[1]),
								Integer.parseInt(coor[2])
								);
					}
				}
			}
			
			bricks.put(hashKey, new Brick(points[0], points[1]));
			points = null;
			
		}
		
		List <String> resultList = new ArrayList<String>();
		
		
		Collections.sort(resultList);

		String result = "";
		for (String k : resultList){
			result = result + k + ",";
		}
		
		result = removeLast(result, ",");
		if (result.equals("")){
			result = "-";
		}
		return result;
	}

	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
	private static class Brick{
		
		private Point p1;
		private Point p2;
		private List<Double> lengthList = new ArrayList<Double>();
		
		
		public Point getP1() {
			return p1;
		}


		public boolean isFitIn(int longerL, int shorterL) {
			return (lengthList.get(1)<=longerL &&lengthList.get(0)<=shorterL);

		}


		public void setP1(Point p1) {
			this.p1 = p1;
		}


		public Point getP2() {
			return p2;
		}


		public void setP2(Point p2) {
			this.p2 = p2;
		}


		public Brick(Point p1, Point p2){
			this.p1 = p1;
			this.p2 = p2;
			
			
			double l1 = Math.abs(p1.getX() - p2.getX());
			double l2 = Math.abs(p1.getY() - p2.getY());
			double l3 = Math.abs(p1.getZ() - p2.getZ());
			
			lengthList.add(l1);
			lengthList.add(l2);
			lengthList.add(l3);
			
			Collections.sort(lengthList);
		}
	}

	private static class Point {
		
		private int x;
		private int y;
		private int z;
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getZ() {
			return z;
		}
		public void setZ(int z) {
			this.z = z;
		}
		public Point (int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
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

	
	 public static void main(String[] args) throws IOException {
	 System.out.println(getPrint("[4,3] [3,-3]|(1 [10,9,4] [9,4,2])"));
	 System.out.println(getPrint("[-1,-5] [5,-2]|(1 [4,7,8] [2,9,0]);(2 [0,7,1] [5,9,8])"));
	 System.out.println(getPrint("[-4,-5] [-5,-3]|(1 [4,8,6] [0,9,2]);(2 [8,-1,3] [0,5,4])"));
	 System.out.println(getPrint("[-1,-1] [0,0]|(1 [4,8,6] [0,9,2]);(3 [1,1,1] [2,2,2]);(3 [1,1,1] [2,2,2]);(2 [8,-1,3] [0,5,4]);(4 [0,7,1] [5,9,8])"));
	 System.out.println(getPrint("[-1,-1] [0,0]|(1 [4,8,6] [0,9,2]);(3 [1,1,1] [2,2,2]);(5 [1,1,1] [2,2,2]);(2 [8,-1,3] [0,5,4]);(4 [0,7,1] [5,9,8])"));
		}
}
