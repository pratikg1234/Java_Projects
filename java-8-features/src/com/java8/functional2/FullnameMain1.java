package com.java8.functional2;

public class FullnameMain1 {
	public static void main(String[] args) {
		m2((fname,lname)->fname+" "+lname);
	}
	public static void m2(Fullname f) {
		String f1=f.showFullname("Pratik", "Gaikwad");
		System.out.println(f1);;
	}
}
