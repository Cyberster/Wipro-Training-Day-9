package com.w3epic.wiprotraining;

public class Main {

	public static void main(String[] args) {
		int[] combinations = Combinations.getCombinations(123);
		
		for (int i = 0; i < combinations.length; i++) {
			System.out.println(i+1 + ": " + combinations[i]);
		}

	}

}
