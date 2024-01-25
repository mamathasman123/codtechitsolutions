package com.codtech.it.solutions;

import java.util.Scanner;
import java.util.Random;

public class GuesstheNumber {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Random random = new Random();
			int lowerBound = 1;
			int upperBound = 100;
			int noOfAttempts = 10;
			int score = 0;
			
      boolean playAgain = true;

			while (playAgain) {
				int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
				int attempts = 0;
				System.out.println("Guess the number between " + lowerBound + " and " + upperBound + "!");
				while (attempts < noOfAttempts) {
					System.out.print("Enter your guess: ");
					int userGuess = sc.nextInt();
					attempts++;

					if (userGuess == generatedNumber) {
						System.out.println("Congratulations! You guessed the correct number " + generatedNumber + "  in "
								+ attempts + " attempts!");
						score++;
						break;
					} else if (userGuess < generatedNumber) {
						System.out.println("Too low!  plese Try a higher number.");
					} else {
						System.out.println("Too high! please Try a lower number.");
					}
				}

				if (attempts == noOfAttempts) {
					System.out.println(
							"Oops! You've reached the maximum number of attempts. The number was " + generatedNumber + ".");
				}

				System.out.print("Do you want to play again? (yes/no): ");
				String playAgainInput = sc.next().toLowerCase();
				if (!playAgainInput.equals("yes")) {
					playAgain = false;
				}
			}

			System.out.println("Your total score is: " + score);
		}
	}

}
