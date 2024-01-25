package com.codtech.it.solutions;

import java.util.Scanner;

public class GradeCalculator {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the number of subjects:");
			int numSubjects = sc.nextInt();

			int[] marks = new int[numSubjects];

			System.out.println("Enter marks (out of 100) for each subject:");
			for (int i = 0; i < numSubjects; i++) {
				System.out.print("Subject " + (i + 1) + ": ");
				marks[i] = sc.nextInt();
			}

			int totalMarks = calculateTotalMarks(marks);

			double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

			char grade = calculateGrade(averagePercentage);

			displayResults(totalMarks, averagePercentage, grade);
		}
	}

	private static int calculateTotalMarks(int[] marks) {
		int total = 0;
		for (int mark : marks) {
			total += mark;
		}
		return total;
	}

	private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
		return (double) totalMarks / numSubjects;
	}

	private static char calculateGrade(double averagePercentage) {
		if (averagePercentage >= 90) {
			return 'A';
		} else if (averagePercentage >= 80) {
			return 'B';
		} else if (averagePercentage >= 70) {
			return 'C';
		} else if (averagePercentage >= 60) {
			return 'D';
		} else {
			return 'F';
		}
	}

	private static void displayResults(int totalMarks, double averagePercentage, char grade) {
		System.out.println("\nResults:");
		System.out.println("Total Marks: " + totalMarks);
		System.out.println("Average Percentage: " + averagePercentage + "%");
		System.out.println("Grade: " + grade);
	}
}
