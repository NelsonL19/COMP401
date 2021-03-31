package a1;

import java.util.Scanner;
import java.util.ArrayList;

public class A1Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int finder = scan.nextInt();
		int amountOfItems = finder;

		

		double[] totalprices = new double[amountOfItems];
		String[] itemNames = new String[amountOfItems];
		int[] uniqueBuyers = new int[amountOfItems];
		int[] itemQuan = new int[amountOfItems];
		

		for (int i = 0; i < amountOfItems; i++) {
			String item = scan.next();
			itemNames[i] = item;
			totalprices[i] = scan.nextDouble();

			// loops through items and prices and adds them into an array
		}
		int amountOfCustomers = scan.nextInt();


		String[] customerName = new String[amountOfCustomers];
		double[] amountSpent = new double[amountOfCustomers];
		String[]itemBought = new String[amountOfCustomers];
		
 	
		
 		
		// creates two arrays for amount spent and the customer
		
 		
 		
		
		for (int i = 0; i < amountOfCustomers; i++) {
			customerName[i] = scan.next() + " " + scan.next();	
			int amtCartItems = scan.nextInt();
			
			// gets the customer's name how many items are in their carts
			boolean[] hasBoughtItemType = new boolean[amountOfItems];
				for (int r = 0; r < amtCartItems; r++) {
					int quantity = scan.nextInt();
					String item = scan.next();
					
					
					// gets how much of each items are in the carts
					
					for (int q = 0; q < finder; q++) {
						if (item.equals(itemNames[q])) {
							amountSpent[i] += totalprices[q] * quantity; 
							
							// update uniqueBuyers and itemQuantites arrays using the index q
							if (!hasBoughtItemType[q]) {
								hasBoughtItemType[q] = true;

								uniqueBuyers[q] += 1;
							}
							
							itemQuan[q] += quantity; 
							
						} 
						
					}	
				}
			}
		for (int i = 0; i < amountOfItems; i++) {
			if (itemQuan[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);	
			} else {
		System.out.println(uniqueBuyers[i] + " customers bought " + itemQuan[i] + " " + itemNames[i]);	
			}
		}
		scan.close();
	}

	// You can define / use static helper methods here.
	
	
	
}
