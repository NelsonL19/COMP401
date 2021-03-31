package a6;

public class CrabPortion extends BasicIngredientPortionImpl {
	
	
	
	public CrabPortion (double amount) {
		
		super(new Crab(), amount);
		
	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		} else {
			if (other.getName() != getName()) {
				throw new RuntimeException("Ingredients do not match");
			}
			
			double total = 0.00;
			total = this.getAmount() + other.getAmount();
			return new CrabPortion(total);
			
		}
	}
}

