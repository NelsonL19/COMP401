package a3;

public class MenuItemImpl implements MenuItem {

	private String name;
	private IngredientPortion[] ingredients;

	public MenuItemImpl(String name, IngredientPortion[] ingredients) {
		if (name == null) {
			throw new RuntimeException("Name is null");
		}
		if (ingredients == null) {
			throw new RuntimeException("Ingredients is Null");
		}

		if (ingredients.length <= 0) {
			throw new RuntimeException("Ingredients Array Length is 0");
		} 

		IngredientPortion[] ingredientsClone = new IngredientPortion[ingredients.length];


		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i] == null) {
				throw new RuntimeException("Ingredient at Index: " + i + " is null");
			}			

			for (int j = 0; j < ingredients.length; j++) {
				ingredientsClone[j] = ingredients[j];
			}

		}

		this.name = name;
		this.ingredients = ingredientsClone; 
	}



	public String getName() {
		return name;
	}


	public IngredientPortion[] getIngredients() {

		IngredientPortion[] ingredientsClone = new IngredientPortion[ingredients.length];

		for (int i = 0; i < ingredients.length; i++) {
			ingredientsClone[i] = ingredients[i];
		}

		return ingredientsClone;
	}


	public int getCalories() {

		int ingreCals = 0;
		for (int i = 0; i < ingredients.length; i++) {
			ingreCals += ingredients[i].getCalories();
		}

		return ingreCals;
	}


	public double getCost() {
		
		double cost = 0.00;
		for (int i = 0; i < ingredients.length; i++) {
			cost += ingredients[i].getCost(); 
		}
		
		return cost;
	}


	public boolean getIsVegetarian() {

		boolean ingreVeg = true;
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i].getIsVegetarian() != true) {
				ingreVeg = false;
				
			}
		}
		return ingreVeg; 

	}

}
