package a5;

public abstract class BasicIngredientImpl implements Ingredient {

	protected String name; 
	protected double pricePerOunce;
	protected int caloriePerOunce;
	protected boolean vegetarian;
	protected boolean isRice;
	protected boolean isShellfish;

	public BasicIngredientImpl(String name, Double pricePerOunce, Integer caloriesPerOunce, 
			Boolean vegetarian, Boolean isRice, Boolean isShellfish) {

		if (name == null ) {
			throw new RuntimeException("Name is Null");
		}

		if (pricePerOunce < 0.00 ) {
			throw new RuntimeException("Price Per Ounce is less than 0.00");
		}

		if (caloriesPerOunce < 0 ) {
			throw new RuntimeException("Calories Per Ounce is less than 0");
		}

		if (vegetarian == null ) {
			throw new RuntimeException("Vegetarian is Null");
		}

		if (isRice == null ) {
			throw new RuntimeException("isRice is Null");
		}

		if (isShellfish == null ) {
			throw new RuntimeException("isShellfish is Null");
		}

		this.name = name;
		this.pricePerOunce = pricePerOunce;
		this.caloriePerOunce = caloriesPerOunce;
		this.vegetarian = vegetarian; 
		this.isRice = isRice; 
		this.isShellfish = isShellfish;

	}
	
	
	public String getName() {
		return name;
	}

	public double getCaloriesPerDollar() {
		Double calsPerDollar = 0.00;
		calsPerDollar = getCaloriesPerOunce()/ getPricePerOunce();
		return calsPerDollar;
	}

	public int getCaloriesPerOunce() {
		return caloriePerOunce;
	}

	public double getPricePerOunce() {
		return pricePerOunce;
	}


	public boolean equals(Ingredient other) {
		if (other.getName().equals(getName())) {
			return true;
		}	
		return false;
	}


	public boolean getIsVegetarian() {
		return vegetarian;
	}


	public boolean getIsRice() {
		return isRice;
	}


	public boolean getIsShellfish() {
		return isShellfish;
	}





}
