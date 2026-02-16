package com.examples.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;



public class CollectionDemo1 {
	public static void main(String[] args) {
//		interArrayListExample();
//		stringArrayListExample();
//		prodArrayListExample();
//		intTreeSetExample();
//		prodTreeSetExample();
//		prodHashSetExample();
		asListandSort();
	}
	
	//It will sort the result and then it will display
	//In comparTo method inside Product class logic is there
	public static void prodTreeSetExample() {
		Set<Product> prodSet = new TreeSet<>();
		
		prodSet.add(new Product(102,"headphone",20.0));
		prodSet.add(new Product(101,"charger",10.0));
		prodSet.add(new Product(103,"laptop",30.0));
		prodSet.add(new Product(1000,"pc",40.0));
		
		System.out.println(prodSet);
	}
	
	//This is for HashSet
	public static void prodHashSetExample() {
		Set<Product> prodSet = new HashSet<>();
		
		prodSet.add(new Product(102,"headphone",20.0));
		prodSet.add(new Product(101,"charger",10.0));
		prodSet.add(new Product(103,"laptop",30.0));
		
		
		System.out.println("prodSet.contains()==>"+prodSet.contains(new Product(102,"headphone",20.0)));
		System.out.println(prodSet);
	}
	
	public static void intTreeSetExample() {
		Set<Integer> intSet = new TreeSet<>();
		intSet.add(1234);
		intSet.add(34);
		intSet.add(12);
		intSet.add(124);
		System.out.println(intSet);
	}
	public static void interArrayListExample() {
//		List intList = new ArrayList();//Non generics
		List<Integer> intList1 = new Vector<Integer>();
		intList1.add(34);
		intList1.add(50);
		intList1.add(56);
		
		Collections.sort(intList1);
		System.out.println(intList1);
		Collections.sort(intList1, null);
//		intList1.forEach(System.out::println);
//		
//		for (int i = 0; i < intList1.size(); i++) {
//            if (intList1.get(i).equals(34)) {
//            	intList1.remove(intList1.get(i));
//            }
//            System.out.println(intList1.get(i));
//        }
//		
//		Iterator<Integer> itr = intList1.iterator();
//		
//		while(itr.hasNext()) {
//			Integer temp = itr.next();
//			System.out.println(temp);
//		}
//		System.out.println("intList1.size()=="+intList1.size());
//		System.out.println("intList1.contains(34)==>"+intList1.contains(34));
//		System.out.println("intList1.contains(10)==>"+intList1.contains(10));
//		System.out.println("intList1.remove(Integer.valueOf(10))==> "+intList1.remove(Integer.valueOf(10)));
//		System.out.println("intList1.remove(Integer.valueOf(34))==> "+intList1.remove(Integer.valueOf(34)));
//		System.out.println("clearing list...");
//		intList1.clear();
//		System.out.println(intList1);
		
	}
	public static void stringArrayListExample() {
		List<String> stringList1 = new ArrayList<String>();
		stringList1.add("Pratik");
		stringList1.add("Gaikwad");
		
//		stringList1.forEach(System.out::println);
//		for(String s : stringList1) {
//			System.out.println(s);
//		}
//		Iterator<String> itr = stringList1.iterator();
//		
//		while(itr.hasNext()) {
//			String temp = itr.next();
//			System.out.println("Length of "+ temp+"is "+ temp.length());
//		}
	}
	public static void prodArrayListExample() {
		List<Product> prodList = new ArrayList<Product>();
		prodList.add(new Product(101,"Samsung",1000));
		prodList.add(new Product(102,"Redmi",2000));
		prodList.add(new Product(103,"One Plus",4000));
		
		Collections.sort(prodList, new ProdNameComparator());
		for(Product temp : prodList) {
			System.out.println(temp.getProdCode()+ " "+ temp.getProdName());
		}
		 
//		prodList.forEach(System.out::println);
		
//		for(Product p : prodList) {
//			System.out.println(p);
//		}
//		 Iterator<Product> itr = prodList.iterator();
//		
//		while(itr.hasNext()) {
//			Product temp = itr.next();
//			double discount=0.0;
//			if(temp.getPrice()>500)
//			{
//				 discount=(temp.getPrice()-((temp.getPrice()*10)/100));
//			}
//			else {
//				 discount=(temp.getPrice()-((temp.getPrice()*5)/100));
//			}
//			System.out.println(temp.getProdName()+" "+ temp.getProdCode()+ " "+ temp.getPrice());
//			System.out.println("Price after discount "+discount);
//		}
//		System.out.println(prodList);
//		System.out.println(prodList.remove(prodList.size()-1));//removing last element
//		System.out.println("prodList.contains(p1)==>"+prodList.contains(new Product(101,"Samsung",1000)));
//		System.out.println("prodList.remove(p1)==> "+prodList.remove(new Product(101,"Samsung",1000)));
//		System.out.println("prodList.contains(p1)==>"+prodList.contains(new Product(101,"Samsung",1000)));
//		System.out.println("prodList.contains(p3)==>"+prodList.contains(new Product(103,"One Plus",4000)));
		
	}
	public static void asListandSort() {

		List<Product> prodList=Arrays.asList(new Product(101,"PC",10),new Product(201,"Laptop",20));
		System.out.println(prodList);
		System.out.println("Before Sorting....");
		for(Product p : prodList) {
			System.out.println(p.getProdCode()+" "+ p.getProdName()+" "+ p.getPrice());
		}
		
		Collections.sort(prodList);
		System.out.println("After Sorting...");
		for(Product p : prodList) {
			System.out.println(p.getProdCode()+" "+ p.getProdName()+" "+ p.getPrice());
		}
		
	}
	
}
