package com.w3epic.wiprotraining;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static int[] getCombinations(int input1) {
		//int input1 = 1234; //-21251;
		if (input1 < 0) input1 *= -1;
		
		StringBuilder numberStr = new StringBuilder(String.valueOf(input1));
		int digitCount = numberStr.length();
		
		int totalCombinationCount = (int) (Math.pow(2, digitCount) - 2);
		totalCombinationCount *= totalCombinationCount;
		int[] conbinations = new int[totalCombinationCount];
		int x = 0; // iterates combinations

		for (int g = 0; g < digitCount && input1 >= 10; g++) {
			for (int h = 1; h < digitCount; h++) {
				char temp = numberStr.charAt(g);
				numberStr.setCharAt(g, numberStr.charAt(h));
				numberStr.setCharAt(h, temp);
				//System.out.print(numberStr.toString() + " :: \n");
				
				for (int i = 0; i < digitCount; i++) {			
					for (int j = 0; j < digitCount - 1; j++) {
						//StringBuilder currentNumberStr = new StringBuilder(numberStr);				
						//if (i == j) continue;
						
						//System.out.print(numberStr.toString() + " :: ");
						
						temp = numberStr.charAt(j);
						numberStr.setCharAt(j, numberStr.charAt(j+1));
						numberStr.setCharAt(j+1, temp);
						conbinations[x++] = Integer.parseInt(numberStr.toString());

						//System.out.print("i: " + i + " j: " + j + " :: " + currentNumberStr.toString() + "\n");
					}
				}
			}
		}
		
		return conbinations;
	}
	
	// combinations = blank i.e. {} initially, currentLevel = 0 initially
	/* getCombinations2(String symbols, int parent, List<Integer> combinations, int currentLevel, int targetLevel)
	 * 	String symbols:				contains symbols like 1234 or abcd
	 * 	int parent:					parent node which will be combined with the symbols, initially 0
	 * 	List<Integer> combinations:	its the data to be passed while calling, it'll carry the result, initially blank ArrayList(Integer)
	 * 	int currentLevel:			current level of tree i.e. current combination digit count, initially 0
	 * 	int targetLevel:			target level to be achieved i.e. result combination digit count
	 * 
	 * 	Author: Arpan Das
	 * 	Idea: https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
	 * */
	public static void getCombinations2(String symbols, int parent, List<Integer> combinations, int currentLevel, int targetLevel) {	
		if (targetLevel == 0) return;
		if (currentLevel > targetLevel) return;
		
		List<Integer> combList = new ArrayList<>();
		
		if (currentLevel == 0) {
			combinations.clear();
			combinations.add(Integer.parseInt(symbols));
			getCombinations2(symbols, 0, combinations, currentLevel+1, targetLevel);
		} else if (currentLevel == 1) {
			// for level 1, just add individual symbols to combinations
			for (int i = 0; i < symbols.length(); i++) {
				//System.out.println("parent: " + String.valueOf(parent));
				combList.add(Integer.parseInt(String.valueOf(parent) + String.valueOf(symbols.charAt(i))));
				//getCombinations2(symbols, combList.get(i), combinations, currentLevel+1, targetLevel);
			}
			
			combinations.clear();
			for (int i = 0; i < combList.size(); i++) {
				combinations.add(combList.get(i));
			}
			
			for (int i = 0; i < combList.size(); i++) {
				getCombinations2(symbols, combList.get(i), combinations, currentLevel+1, targetLevel);
			}
			
		} else { // here is the prob, correct below
			for (int i = 0; i < symbols.length(); i++) {
				//if (parent != Integer.parseInt(String.valueOf(numbersStr.charAt(i)))) {
					combList.add(Integer.parseInt(String.valueOf(parent) + String.valueOf(symbols.charAt(i))));
				//}
			}
		
			// append to combination
			for (int i = 0; i < combList.size(); i++) {
				combinations.add(combList.get(i));
			}
			
			for (int i = 0; i < combList.size(); i++) {
				getCombinations2(symbols, combList.get(i), combinations, currentLevel+1, targetLevel);
			}
			
			// clear unnecessary combinations
			for (int i = 0; i < combinations.size(); i++) {
				if (String.valueOf(combinations.get(i)).length() != targetLevel) {
					combinations.remove(i);
				}
			}
		}
		
	}
}
