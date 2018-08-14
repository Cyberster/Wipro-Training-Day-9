package com.w3epic.wiprotraining;

public class WeightHillPattern {
	public static int getWeightHillPattern(int input1, int input2, int input3) {
		int totalWeight = 0;
		int initWeight = input2;
		
		for (int i = 0; i < input1; i++) {
			for (int j = 0; j <= i; j++) {
				totalWeight += initWeight;
				System.out.println("initWeight: " + initWeight);
			}
			
			initWeight += input3;
		}
		
		return totalWeight;
	}
	
	public static void main(String[] args) {
		System.out.println(getWeightHillPattern(5, 10, 2));
	}
}
