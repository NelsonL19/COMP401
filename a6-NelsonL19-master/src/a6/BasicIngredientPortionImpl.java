package a6;

public class BasicIngredientPortionImpl implements IngredientPortion {

	protected Ingredient ing;
	protected double amount; 
	

	public BasicIngredientPortionImpl(Ingredient ing, double amount)  {
		if (ing == null) {
			throw new RuntimeException("Ingredient is Null");
		}

		if (amount < 0.00 ) {
			throw new RuntimeException("Amount is less than 0.00");
		}

		this.ing = ing;
		this.amount = amount;
	}

	public Ingredient getIngredient() {
		return ing;
	}


	public String getName() {
		return ing.getName();
	}


	public double getAmount() {
		return amount;
	}


	public double getCalories() {
		return amount * ing.getCaloriesPerOunce();
	}


	public double getCost() {
		return (amount * ing.getPricePerOunce());
	}


	public boolean getIsVegetarian() {
		return ing.getIsVegetarian();

	}


	public boolean getIsRice() {
		return ing.getIsRice();
	}


	public boolean getIsShellfish() {
		return ing.getIsShellfish();
	}


	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		} else {
			if (other.getName() != ing.getName()) {
				throw new RuntimeException("Ingredients do not match");
			}

			double total = 0.00;
			total = getAmount() + other.getAmount();
			return new BasicIngredientPortionImpl(ing, total);

		}
	}

}
