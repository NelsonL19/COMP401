package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		
		// Your code goes here.
		int finder = scan.nextInt();
		String[] names = new String[finder];
		
		/* creates two new variables, that create an array of strings called names,
		 * with the array length being set to the variable finder
		 * which is assigned the next result of nextInt()
		 */
		
		
		double[] prices = new double[finder];
		//same as above scanner
		
		for (int i=0; i < finder; i++) {
		
			String line = scan.next().substring(0, 1) + (". ") + (scan.next()) + 
					(": ");
			
			//creates and adds the inital, lname, and the : 
			
			
			names[i]=line;
			int counter = 0;
			int itemNumber = scan.nextInt();
			while (counter < itemNumber) {
				double amount = scan.nextDouble();
				scan.next();
				amount *= scan.nextDouble();
				prices[i] +=amount;
				counter++;
			}
			
			line += String.format("%.2f", prices[i]);
			
			System.out.println(line);		

		// prints the output
			
			
			/* todo: fix janet's using double test = 12.50;
			 String money = String.format("%.2f", test);
			 System.out.println(money);
			 */
	}
scan.close();	

}
	// You can define / use static helper methods here.

}
	
