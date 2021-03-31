package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int finder = scan.nextInt();
		int amountOfItems = finder;
		
		//System.out.println(amountOfItems);
		
		double[] totalprices = new double[amountOfItems];
		String[] itemNames = new String[amountOfItems];
		
		for (int i = 0; i < amountOfItems; i++) {
			String item = scan.next();
			itemNames[i] = item;
			totalprices[i] = scan.nextDouble();
			
			// loops through items and prices and adds them into an array
		}
		int amountOfCustomers = scan.nextInt();
		
		
		
		String[] customerName = new String[amountOfCustomers];
		double[] amountSpent = new double[amountOfCustomers];
		
		// creates two arrays for amount spent and the customer
		
		
		for (int i = 0; i < amountOfCustomers; i++) {
			customerName[i] = scan.next() + " " + scan.next();	
			int amtCartItems = scan.nextInt();
			
			// gets the customer's name how many items are in their carts
			
				for (int r = 0; r < amtCartItems; r++) {
					int quantity = scan.nextInt();
					String item = scan.next();
					
					// gets how much of each items are in the carts
					
					for (int q = 0; q < finder; q++) {
						if (item.equals(itemNames[q])) {
							amountSpent[i] += totalprices[q] * quantity; 
							// calculates total amount spent for the item
						}
					}	
				}
			}
		
		String bigCustomer = new String();
		String smallCustomer = new String(); 
		Double bigSpend = 0.00;
		Double smallSpend = amountSpent[0];
		Double avgSpend = 0.00;
		
		//Initializing export variables
		
		
		if (amountOfCustomers <= 1) {
			bigCustomer = customerName[0];
			smallCustomer = customerName[0];
			bigSpend = amountSpent[0];
			smallSpend = amountSpent[0];
			avgSpend = amountSpent[0];
		} else {
			for (int i=0; i < amountOfCustomers; i++) {
				if (amountSpent[i] > bigSpend) {
					bigSpend = amountSpent[i];
					bigCustomer = customerName[i];
				}
				
				if (amountSpent[i] <= smallSpend) {
					smallSpend = amountSpent[i];
					smallCustomer = customerName[i];
				}	
			}
			for (int i = 0; i < amountSpent.length; i++) {
				avgSpend += amountSpent[i] / amountSpent.length;	
			}
		}
		
		//if there's just 1 customer, else calculates the rest
		
		
		
		String bigs = new String();
		String smalls = new String();
		String avgs = new String();
		
		
		bigs += String.format("%.2f", bigSpend);
		avgs += String.format("%.2f", avgSpend);
		smalls += String.format("%.2f", smallSpend);
		
		//double to string to preserve the concatenated zero
		
		System.out.println("Biggest: " + bigCustomer + " (" + bigs + ")");
		System.out.println("Smallest: " + smallCustomer + " (" + smalls + ")");
		System.out.println("Average: " + avgs);
		
		//outputs to console
		
		
		scan.close();
	}
	
	// You can define / use static helper methods here.
}
