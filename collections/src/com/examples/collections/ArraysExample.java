package com.examples.collections;

import java.util.Arrays;
import java.util.List;

public class ArraysExample {
	public static void main(String[] args) {
		String[] fruitsArray = {"Mango", "Apple", "Banana", "Orange"};
        List<String> fruitsList = Arrays.asList(fruitsArray); 

        System.out.println("Original List:");
        for (String fruit : fruitsList) {
            System.out.println(fruit);
        }


        Arrays.sort(fruitsArray); 

        System.out.println("\nSorted List:");
        for (String fruit : fruitsList) {
            System.out.println(fruit);
        }
	}
}
