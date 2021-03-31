package a3;

public class IngredientPortionImpl implements IngredientPortion {

	private Ingredient ing;
	private double amount;


	public IngredientPortionImpl(Ingredient ing, double amount) {
		if (amount < 0.00) {
			throw new RuntimeException("Amount is less than 0");
		}

		if (ing == null) {
			throw new RuntimeException("Ingredient type is Null");
		}
		

		this.ing = ing; 
		this.amount = amount;
	}


	
	public Ingredient getIngredient() {
		return this.ing;
	}


	public double getAmount() {
		return this.amount;
	}

	
	public String getName() {
		return ing.getName();
	}

	
	public boolean getIsVegetarian() {
		return ing.getIsVegetarian();
	}

	
	public double getCalories() {
		
		double calories = 0.00;
		
		calories += ing.getCaloriesPerOunce() * amount;
	
	
		return calories;
	}

	
	public double getCost() {
		
		double cost = 0.00;
		
		cost += amount * ing.getPricePerOunce();
		
		return cost;
	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		} else {
			if (other.getName() != getName()) {
				throw new RuntimeException("Ingredients do not match");
			}
			
			double total = 0.00;
			total = this.amount + other.getAmount();
			return new IngredientPortionImpl(this.ing, total);
			
		}



	}
}