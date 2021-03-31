package a3;


public class IngredientImpl implements Ingredient {

	private String name; 
	private double price;
	private int calories;
	private boolean is_vegetarian;


	public IngredientImpl(String name, double price, int calories, boolean is_vegetarian) {
		if (name == null) {
			throw new RuntimeException("Name set to Null/Other Type");
		}
		if (price < 0.00) {
			throw new RuntimeException("Price is less than 0");
		}

		if (calories < 0) {
			throw new RuntimeException("Calories is less than 0");
		}
		
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.is_vegetarian = is_vegetarian;
		
	}

	public String getName() {
		return name;
	}


	public boolean getIsVegetarian() {
		return is_vegetarian;
	}


	public double getPricePerOunce() {
		return price;
	}


	public int getCaloriesPerOunce() {
		return calories;
	}


	public double getCaloriesPerDollar() {
		Double calsPerDollar = 0.00;
		calsPerDollar = getCaloriesPerOunce()/ getPricePerOunce();
		return calsPerDollar;
	}

}
