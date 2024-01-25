package com.codtech.it.solutions;

import java.util.Scanner;

class BankAccount {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial account balance: ");
        double initialBalance = sc.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();

            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();

            atm.processOption(choice);
        }
    }
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds!");
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner sc = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = sc.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful!");
                }
                break;

            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = sc.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful!");
                break;

            case 3:
                System.out.println("Current Balance: " + userAccount.getBalance());
                break;

            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

}

