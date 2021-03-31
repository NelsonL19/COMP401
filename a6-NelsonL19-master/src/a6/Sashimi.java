package a6;


public class Sashimi implements Sushi {

	private SashimiType type;

	public enum SashimiType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};


	public Sashimi(SashimiType type) { 
		if (type == null) {
			throw new RuntimeException("Type is set to Null");
		}

		this.type = type; 

	}


	public String getName() {
		if (type == SashimiType.TUNA) {
			return "tuna sashimi";
		}

		if (type == SashimiType.YELLOWTAIL) {
			return "yellowtail sashimi";
		}

		if (type == SashimiType.EEL) {
			return "eel sashimi";
		}

		if (type == SashimiType.CRAB) {
			return "crab sashimi";
		}
		if (type == SashimiType.SHRIMP) {
			return "shrimp sashimi";
		}

		return null;
	}



	public IngredientPortion[] getIngredients() {

		IngredientPortion[] ingres = new IngredientPortion[1];

		switch (type) {

		case CRAB:
			ingres[0] = new CrabPortion(0.75);
			return ingres;

		case EEL:
			ingres[0] = new EelPortion(0.75);
			return ingres;

		case SHRIMP:
			ingres[0] = new ShrimpPortion(0.75);
			return ingres;

		case TUNA:
			ingres[0] = new TunaPortion(0.75);
			return ingres;

		case YELLOWTAIL:
			ingres[0] = new YellowtailPortion(0.75);
			return ingres;

		}
		return ingres;
	}


	
	public int getCalories() {

		double cal = 0.75;

		switch (type) {

		case CRAB:
			cal *= 37;

			Long calCrabLong = Math.round(cal);
			int totalCalCrab = Integer.valueOf(calCrabLong.intValue());
			return totalCalCrab;

		case EEL:
			cal *= 82;

			Long calEelLong = Math.round(cal);
			int totalCalEel = Integer.valueOf(calEelLong.intValue());
			return totalCalEel;


		case SHRIMP:
			cal *= 32; 

			Long calShrimpLong = Math.round(cal);
			int totalCalShrimp = Integer.valueOf(calShrimpLong.intValue());
			return totalCalShrimp;


		case TUNA: 
			cal *= 42;

			Long calTunaLong = Math.round(cal);
			int totalCalTuna = Integer.valueOf(calTunaLong.intValue());
			return totalCalTuna;


		case YELLOWTAIL:
			cal *= 57;

			Long calYellowtailLong = Math.round(cal);
			int totalCalYellowtail = Integer.valueOf(calYellowtailLong.intValue());
			return totalCalYellowtail;


		default:
			break;

		}
		int totalCal = (int) cal;

		return totalCal;
	}



	public double getCost() {

		double cost = 0.75;

		switch (type) {

		case CRAB:
			cost *= 0.72;
			return cost;

		case EEL:
			cost *= 2.14;
			return cost;

		case SHRIMP:
			cost *= 0.65;
			return cost;

		case TUNA:
			cost *= 1.67;
			return cost;

		case YELLOWTAIL:
			cost *= 0.74;
			return cost;

		default:
			break;

		}
		return cost;
	}



	public boolean getHasRice() {
		return false;
	}



	public boolean getHasShellfish() {

		switch (type) {

		case CRAB:
			return true;

		case EEL:
			return false;

		case SHRIMP:
			return true;

		case TUNA:
			return false;

		case YELLOWTAIL:
			return false;

		default:
			break;

		}

		return false;
	}



	public boolean getIsVegetarian() {	
		return false;
	}
}
