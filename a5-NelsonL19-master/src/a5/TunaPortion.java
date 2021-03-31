package a5;

public class TunaPortion extends BasicIngredientPortionImpl implements IngredientPortion {


	public TunaPortion (double amount) {

		super(new Tuna(), amount);

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
		return new TunaPortion(total);

	}
}