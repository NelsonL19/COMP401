package a5;

public class AvocadoPortion extends BasicIngredientPortionImpl implements IngredientPortion {


	public AvocadoPortion (double amount) {

		super(new Avocado(), amount);

	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}
		if (other.getName() != ing.getName()) {
			throw new RuntimeException("Ingredients do not match");
		}

		double total = 0.00;
		total = this.getAmount() + other.getAmount();
		return new AvocadoPortion(total);

	}
}

