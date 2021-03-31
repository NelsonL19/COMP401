package a6;

public class EelPortion extends BasicIngredientPortionImpl implements IngredientPortion {


	public EelPortion (double amount) {

		super(new Eel(), amount);

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
		return new EelPortion(total);

	}
}