package com.practice.examples;

import java.util.ArrayList;
import java.util.List;

public class Practice {
	public static void main(String[] args) {
//		pract();
		long l = 10L;
		int y = (int)l;
	}
	static{
		 int a =10;
	}
	public static void pract() throws NumberFormatException{
		List<String> strList = new ArrayList<>();
		
		
		synchronized (strList) {
			strList.add("Pratik");
			strList.add("Gaikwad");
		}
		for(String s : strList) {
			System.out.println(s);
		}
	}
}
