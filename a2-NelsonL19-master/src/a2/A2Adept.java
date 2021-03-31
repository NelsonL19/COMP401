package a2;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int amtItems = scan.nextInt();

		String[] itemName = new String[amtItems];
		double[] pricePerOunce = new double[amtItems];
		boolean[] veg = new boolean[amtItems];
		int[] calPerOunce = new int[amtItems];


		for (int i = 0; i < amtItems; i++) {
			itemName[i] = scan.next();
			pricePerOunce[i] = scan.nextDouble();
			veg[i] = scan.nextBoolean();
			calPerOunce[i] = scan.nextInt();
		}

		//CalsPerPrice
		double[] calsPerDollar = new double[amtItems];
		for (int i = 0; i < amtItems; i++) {
			calsPerDollar[i] = calPerOunce[i] / pricePerOunce[i];
		}

		int menuItems = scan.nextInt();

		String[] menuNames = new String[menuItems];


		for (int i = 0; i < menuItems; i++) {


			menuNames[i] = scan.next();
			int amountOfIngre = scan.nextInt();


			String[] ingreList = new String[amountOfIngre];
			double[] ouncesRequired = new double[amountOfIngre];
			double cost[] = new double[amtItems];
			double[] calories = new double[menuItems];
			boolean vegItem = true;



			for (int o = 0; o < amountOfIngre; o++) {
				ingreList[o] = scan.next();
				ouncesRequired[o] = scan.nextDouble();

				for (int r = 0; r < amtItems; r++) {
					if (itemName[r].equals(ingreList[o])) {
						cost[i] += (pricePerOunce[r] * ouncesRequired[o]);
						calories[i] += (calPerOunce[r] * ouncesRequired[o]);

						if (!veg[r]) {
							vegItem = false;

						}	





					}

				}

			}



		
			//Start of Output Creation goes here (still in For Loop, should print inside loop)

			int fCalories = ((int) (calories[i] + 0.5));
			String fCost = String.format("%.2f", cost[i]);





			System.out.println(menuNames[i] + ":");
			System.out.println(fCalories + " calories");
			System.out.println("$" + fCost);
			if (vegItem) {
				System.out.println("Vegetarian");
			} else {
				System.out.println("Non-Vegetarian");

			}


			 



		}
		scan.close(); 
	}

	// You can define helper methods here if needed.

}
