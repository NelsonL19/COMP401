package a6;

public class RicePortion extends BasicIngredientPortionImpl implements IngredientPortion {


	public RicePortion (double amount) {

		super(new Rice(), amount);

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
		return new RicePortion(total);

	}
}