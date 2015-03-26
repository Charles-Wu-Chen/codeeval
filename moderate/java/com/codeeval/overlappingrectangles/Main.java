
package com.codeeval.overlappingrectangles;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

				System.out.println(getPrint(line));

		}
	}

	private static String getPrint(String line) {
		String result = "False";
		String [] inputs = line.split(",");
		Point p1 = new Point(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
		Point p2 = new Point(Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]));
		Point p3 = new Point(Integer.parseInt(inputs[4]), Integer.parseInt(inputs[5]));
		Point p4 = new Point(Integer.parseInt(inputs[6]), Integer.parseInt(inputs[7]));
		Square s1 = new Square (p1, p2
				 );
		Square s2 = new Square (p3, p4 
				 );
		
		if ( s1.isAnInsidePoint(p3)||s1.isAnInsidePoint(p4)
				||s1.isAnInsidePoint(new Point(p3.getX(), p4.getY()))
				||s1.isAnInsidePoint(new Point(p4.getX(), p3.getY()))
			||s2.isAnInsidePoint(p1)||s2.isAnInsidePoint(p2)
			||s2.isAnInsidePoint(new Point(p1.getX(), p2.getY()))
			||s2.isAnInsidePoint(new Point(p2.getX(), p1.getY()))
			)
			result = "True"	;
		
		return result;

	}

	

	private static String removeLast(String input, String lastChar){
		String result = input;
		if (input.contains(lastChar)){
			result = input.substring(0,input.lastIndexOf(lastChar));
		}
		return result;
	}
	
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader buffer = null;
//		File file = null;
//		try {
//			file = new File("racingcharinput.txt");
//			buffer = new BufferedReader(new FileReader(file));
//			String line;
//
//			while ((line = buffer.readLine()) != null) {
//				line = line.trim();
//				System.out.println(getUnique(line));
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			buffer.close();
//		}
//
//	}
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		System.out.println(getPrint("-3,3,-1,1,1,-1,3,-3"));
//		System.out.println(getPrint("-3,3,-1,1,-2,4,2,2"));
//		System.out.println(getPrint("56"));
//
//	}
	
	static class Square {
		Point leftUp;
		Point rightDown;
		
		public Square (Point a, Point b){
			leftUp = new Point(Math.min(a.getX(), b.getX()), Math.max(a.getY(), b.getY()));
			rightDown = new Point(Math.max(a.getX(), b.getX()), Math.min(a.getY(), b.getY()));;
			
		}

		public Point getLeftUp() {
			return leftUp;
		}

		public void setLeftUp(Point leftUp) {
			this.leftUp = leftUp;
		}

		public Point getRightDown() {
			return rightDown;
		}

		public void setRightDown(Point rightDown) {
			this.rightDown = rightDown;
		}
		
		public boolean isAnInsidePoint(Point c){
			
			return c.getX()>=leftUp.getX() && c.getX()<= rightDown.getX()
					&&c.getY() >= rightDown.getY() && c.getY() <=leftUp.getY();
		}
		
	}
	
	static class Point {
		int x;
		int y;
		
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
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		} 
		
	}
}