package com.w3epic.wiprotraining;

public class PalindromePossible {
	public static void main(String[] args) {
		int input1 = 1234;//-21251;
		if (input1 < 0) input1 *= -1;
		
		StringBuilder numberStr = new StringBuilder(String.valueOf(input1));
		int digitCount = numberStr.length();
		boolean isAnyCombinationPalindrome = false;
		
		if (input1 < 10) isAnyCombinationPalindrome = true;
		
		int x = 0;

		int range = digitCount / 2;
		if (digitCount % 2 == 0) range--;

		for (int g = 0; g < digitCount && input1 >= 10; g++) {
			for (int h = 1; h < digitCount; h++) {
				char temp = numberStr.charAt(g);
				numberStr.setCharAt(g, numberStr.charAt(h));
				numberStr.setCharAt(h, temp);
				System.out.print(numberStr.toString() + " :: \n");
				
				for (int i = 0; i < digitCount; i++) {			
					for (int j = 0; j < digitCount - 1; j++) {
						StringBuilder currentNumberStr = new StringBuilder(numberStr);				
						//if (i == j) continue;
						
						System.out.print(numberStr.toString() + " :: ");
						
						temp = numberStr.charAt(j);
						numberStr.setCharAt(j, numberStr.charAt(j+1));
						numberStr.setCharAt(j+1, temp);
						
						boolean isCurrentPalindrome = true;
						for (int k = 0; k <= range; k++) {
							if (numberStr.charAt(k) != numberStr.charAt(digitCount - k - 1)) {
								isCurrentPalindrome = false;
								break;
							}
						}
						
						if (isCurrentPalindrome) isAnyCombinationPalindrome = true;
						x++;
						System.out.print("i: " + i + " j: " + j + " :: " + currentNumberStr.toString() + "\n");
					}
				}
			}
		}

//		if (isAnyCombinationPalindrome == true) return 2;
//		else return 1;
		System.out.println(isAnyCombinationPalindrome);
		System.out.println(x);
	}
}
