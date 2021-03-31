package a6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

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

		IngredientPortion[] rollAmts = new IngredientPortion[rollIngredients.length + 1];
		IngredientPortion[] rollCopy = new IngredientPortion[rollIngredients.length + 1];
		IngredientPortion[] rollFinal = new IngredientPortion[rollIngredients.length];

		ArrayList <IngredientPortion> ingreList = new ArrayList<IngredientPortion>();

		for (int i = 0; i < rollIngredients.length; i++) {
			ingreList.add(rollIngredients[i]);
		}

		for (int i = 0; i< ingreList.size(); i++) {
			for (int j = i+1; j < ingreList.size(); j++) {

				if (ingreList.get(i) != null) {

					if (ingreList.get(i).getIngredient().equals(ingreList.get(j).getIngredient())){
						ingreList.set(i, ingreList.get(i).combine(ingreList.get(j)));
						ingreList.remove(j);
					}
				}
			}
		}


		boolean hasSeaweed = false;
		for (int i = 0; i < ingreList.size(); i++) {
			if (ingreList.get(i).getIngredient().equals(new Seaweed())) {
				hasSeaweed = true;
			}


		}


		if (!hasSeaweed) {
			ingreList.add(new SeaweedPortion(0.12));
			
		} else  {
			for (int i = 0; i < ingreList.size(); i++) {
				if (ingreList.get(i).getIngredient().equals(new Seaweed())) {	
					double amount = ingreList.get(i).getAmount();
					if ( amount < 0.1) {
						ingreList.set(i, new SeaweedPortion(0.12));
						
					}
				}
			}
		}
		IngredientPortion[] ingreListFinal = new IngredientPortion[ingreList.size()];
		for (int i = 0; i < ingreList.size(); i++) {
			ingreListFinal[i] = ingreList.get(i);
		}


		this.name = name;
		this.rollIngredients = ingreListFinal;

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