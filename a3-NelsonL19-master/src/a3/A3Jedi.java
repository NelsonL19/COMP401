package a3;

import java.util.Scanner;
import java.util.ArrayList;

public class A3Jedi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int amtItems = scan.nextInt();
		Ingredient[] ingredients = new Ingredient[amtItems];



		for (int i = 0; i < amtItems; i++) {
			String name = scan.next();
			Double pricePerOunce = scan.nextDouble();
			Boolean isVeg = scan.nextBoolean();
			Integer calories = scan.nextInt(); 

			ingredients[i] = new IngredientImpl(name, pricePerOunce, calories, isVeg);


		}

		IngredientPortion[] ingredientsAmounts = new IngredientPortion[amtItems];
		for (int i = 0; i < amtItems; i++) {
			ingredientsAmounts[i] = new IngredientPortionImpl(ingredients[i], 0.00);
		}


		int menuItems = scan.nextInt();

		String[] menuNames = new String[menuItems];

		MenuItemImpl[] menuContents = new MenuItemImpl[menuItems];

		for (int i = 0; i < menuItems; i++) {


			menuNames[i] = scan.next();
			Integer amtIngr = scan.nextInt();

			String[] ingres = new String[amtIngr];
			double[] ingresOunces = new double[amtIngr]; 
			IngredientPortion[] ingreList = new IngredientPortionImpl[amtIngr];

			for (int j = 0; j < amtIngr; j++) {
				ingres[j] = scan.next();
				ingresOunces[j] = scan.nextDouble();

				for (int k = 0; k < amtItems; k++) {
					if (ingres[j].equals(ingredients[k].getName())) {
						ingreList[j] = new IngredientPortionImpl(ingredients[k], ingresOunces[j]);
					}
				}
			}

			menuContents[i]= new MenuItemImpl(menuNames[i],ingreList);


		}

		double[] ounceTot = new double[amtItems];

		for (int i = 0; i < ounceTot.length; i++) {
			ounceTot[i] = 0.00;
		}

		String currentOrder = scan.next();

		while (!currentOrder.equals("EndOrder")) {

			for (int i = 0; i < ingredients.length; i++) {

				for (MenuItemImpl menuItem: menuContents) {

					boolean sameOrder = false;
					sameOrder = compareNames(menuItem.getName(), currentOrder);
					
					if (sameOrder){

						IngredientPortion[] currIngre = menuItem.getIngredients();

						for (int l = 0; l < currIngre.length; l++) {

							boolean sameIngredient = false;
							
							sameIngredient = compareNames(ingredients[i].getName(), currIngre[l].getName());
							
							if (sameIngredient) {

									ingredientsAmounts[i].combine(currIngre[l]);
									ounceTot[i] += currIngre[l].getAmount();
								
							}
						}
					}
				}
			}

			currentOrder = scan.next();

		}
		
		
	
		
		
		System.out.println("The order will require: ");
		for (int u = 0; u < amtItems; u++) {
			System.out.println(String.format("%.2f", ounceTot[u]) + " ounces of " + ingredients[u].getName());
		}
		scan.close();	
	}


	public static int findIndex(String[] x, String y) { 
		for (int i = 0; i < x.length; i++) {
			if (x[i].equals(y)) {
				return i;
			} 
		} return -1; 
	} 
	
	public static boolean compareNames(String x, String y) {
			if (x.equals(y)){
				return true;
			}
		return false;
	}
	
}