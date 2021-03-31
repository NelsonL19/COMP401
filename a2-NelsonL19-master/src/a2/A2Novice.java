package a2;

import java.util.Scanner;

public class A2Novice {

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

		//Number of Vegetarian Ingredients in the Menu
		int numOfVeg = 0;
		for (int i = 0; i < amtItems; i++) {
			if (veg[i] == true) {
				numOfVeg++;
			}
		}

		//CalsPerPrice
		double[] calsPerDollar = new double[amtItems];
		for (int i = 0; i < amtItems; i++) {
			calsPerDollar[i] = calPerOunce[i] / pricePerOunce[i];
		}

		String highCalName = "";
		String lowCalName = "";

		//Highest/Lowest
		Double highCal = 0.00;
		for (int i = 0; i < amtItems; i++) {
			if (calsPerDollar[i] > highCal) {
				highCal += calsPerDollar[i];
				highCalName = itemName[i];
			}
		}

		double lowCal = highCal;
		for (int i = 0; i < amtItems; i++) {
			if (calsPerDollar[i] <= lowCal) {
				lowCal = calsPerDollar[i];
				lowCalName = itemName[i];
			}
		}


		//System Output
		System.out.println("Number of vegetarian ingredients: " + numOfVeg);
		System.out.println("Highest cals/$: " + highCalName);
		System.out.println("Lowest cals/$: " + lowCalName);


		scan.close();

		// You can define helper methods here if needed.

	}
}
