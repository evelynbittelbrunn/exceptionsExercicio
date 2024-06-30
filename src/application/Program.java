package application;

import java.util.Locale;
import java.util.Scanner;

import exceptions.BusinessExceptions;
import model.entities.Account;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		
		System.out.print("Initial balance: ");
		Double initialBalance = sc.nextDouble();
		
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, initialBalance, withdrawLimit);
		
		System.out.print("Enter amount for withdraw: ");
		Double amount = sc.nextDouble();
		
		try {
			acc.withdraw(amount);
			System.out.printf("New balance: %.2f%n", acc.getBalance());	
		} catch(BusinessExceptions e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
