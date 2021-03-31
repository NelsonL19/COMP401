package a5;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Roll implements Sushi {

	private String name;
	private IngredientPortion[] rollIngredients;


	public Roll(String name, IngredientPortion[] rollIngredients) {
		if (name == null) {
			throw new RuntimeException("Name is Null");
		}
		if (rollIngredients == null) {
			throw new RuntimeException("Roll Ingredients is Null");
		}

		for (int i = 0; i < rollIngredients.length; i++) {
			if (rollIngredients[i] == null) {
				throw new RuntimeException("Roll Ingredient at Index " + i + " is Null");
			}
		}
		
		

		this.name = name;
		this.rollIngredients = rollIngredients.clone();

	}

	public String getName() {
		return name;
	}


	public IngredientPortion[] getIngredients() {
		IngredientPortion[] ingres = rollIngredients.clone();
		return ingres;
	}


	public int getCalories() {

		int calories = 0; 

		IngredientPortion[] ingres = rollIngredients.clone();
		for (int i = 0; i < ingres.length; i++) {
			calories += ingres[i].getCalories();
		}

		return calories;
	}


	public double getCost() {

		double cost = 0.00;




		IngredientPortion[] ingres = rollIngredients.clone();
		for (int i = 0; i < ingres.length; i++) {
			cost += ingres[i].getCost();
		}

		double fCost = round(cost, 2);

		return fCost;
	}


	public static double round(double x, int y) {
		if (y < 0) throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(x);
		bd = bd.setScale(y, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}


	public boolean getHasRice() {

		IngredientPortion[] ingres = rollIngredients.clone();
		for (int i = 0; i < ingres.length; i++) {
			if (ingres[i].getIsRice() == true) {
				return true;
			}
		}

		return false;
	}

	public boolean getHasShellfish() {

		IngredientPortion[] ingres = rollIngredients.clone();
		for (int i = 0; i < ingres.length; i++) {
			if (ingres[i].getIsShellfish() == true) {
				return true;
			}
		}

		return false;
	}


	public boolean getIsVegetarian() {

		IngredientPortion[] ingres = rollIngredients.clone();
		for (int i = 0; i < ingres.length; i++) {
			if (ingres[i].getIsVegetarian() == true) {
				return true;
			}
		}

		return false;
	}
}