package a2;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int amtItems = scan.nextInt();

		String[] itemName = new String[amtItems];



		for (int i = 0; i < amtItems; i++) {
			itemName[i] = scan.next();
			scan.nextDouble();
			scan.nextBoolean();
			scan.nextInt();

		}

		int menuItems = scan.nextInt();

		String[] menuNames = new String[menuItems];
		int[] amountOfIngre = new int[menuItems];

		ArrayList<String> ingreList = new ArrayList<String>(); 
		ArrayList<Double> ounceIngre = new ArrayList<Double>(); 

		for (int i = 0; i < menuItems; i++) { 

			menuNames[i] = scan.next();



			int amountIng = scan.nextInt();
			amountOfIngre[i] = amountIng;




			for (int o = 0; o < amountIng; o++) {
				String name = scan.next();
				double oun = scan.nextDouble();

				ingreList.add(name);
				ounceIngre.add(oun);


			}

		}

		double[] ounceTot = new double[amtItems]; 
		String currentOrder = scan.next();


		while (!currentOrder.equals("EndOrder")) {
			int finder = find_index(menuNames, currentOrder);

			int finderCount = 0; 


			if (finder != 0) {
				for (int k = 0; k < finder; k++) {
					finderCount += amountOfIngre[k]; 

				}	
			}

			for (int p = finderCount; p < amountOfIngre[finder] + finderCount; p++) {
				for ( int y = 0; y < amtItems; y++) {
					if (ingreList.get(p).equals(itemName[y])) {
						ounceTot[y] = ounceTot[y] + ounceIngre.get(p);
					}
				}
			}
			currentOrder = scan.next();
		}
		System.out.println("The order will require: ");
		for (int u = 0; u < amtItems; u++) {
			System.out.println(String.format("%.2f", ounceTot[u]) + " ounces of " + itemName[u]);
		}



		scan.close(); 
	}

	// You can define helper methods here if needed.

	public static int find_index(String[] x, String y) { 
		for (int i = 0; i < x.length; i++) {
			if (x[i].equals(y)) {
				return i;
			}
		} return -1; 
	} 

}
