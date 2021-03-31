package a5;

public class ShrimpPortion extends BasicIngredientPortionImpl implements IngredientPortion {


	public ShrimpPortion (double amount) {

		super(new Shrimp(), amount);

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
		return new ShrimpPortion(total);

	}
}