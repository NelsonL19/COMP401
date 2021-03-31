package a5;

public class YellowtailPortion extends BasicIngredientPortionImpl implements IngredientPortion {


	public YellowtailPortion (double amount) {

		super(new Yellowtail(), amount);

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
		return new YellowtailPortion(total);

	}
}