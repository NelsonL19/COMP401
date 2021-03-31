package a4;

public class Nigiri implements Sushi {

	private NigiriType type;
	public enum NigiriType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};

	
	public Nigiri(NigiriType type) {
		if (type == null) {
			throw new RuntimeException("Type is Null");
		}
		this.type = type; 
	}

	public String getName() {
		
		switch (type) {
		
		case CRAB:
			return "crab nigiri";
			
		case EEL:
			return "eel nigiri";
			
		case SHRIMP:
			return "shrimp nigiri";
			
		case TUNA:
			return "tuna nigiri";
			
		case YELLOWTAIL:
			return "yellowtail nigiri";
			
		default:
			break;
		
		}
		
		return null;
	}


	public IngredientPortion[] getIngredients() {
		
		IngredientPortion[] ingres = new IngredientPortion[2];

		switch (type) {

		case CRAB:
			ingres[0] = new CrabPortion(0.75);
			ingres[1] = new RicePortion(0.5);
			return ingres;

		case EEL:
			ingres[0] = new EelPortion(0.75);
			ingres[1] = new RicePortion(0.5);
			return ingres;

		case SHRIMP:
			ingres[0] = new ShrimpPortion(0.75);
			ingres[1] = new RicePortion(0.5);
			return ingres;

		case TUNA:
			ingres[0] = new TunaPortion(0.75);
			ingres[1] = new RicePortion(0.5);
			return ingres;

		case YELLOWTAIL:
			ingres[0] = new YellowtailPortion(0.75);
			ingres[1] = new RicePortion(0.5);
			return ingres;

		}
		return ingres;
		
	}

	
	public int getCalories() {
		
		double ingreCal = 0.75;
		double riceCal = 0.5; 
		double totalCal = 0.0;
		
		switch (type) {
		
		case CRAB:
			totalCal = ingreCal * 37;
			totalCal += (riceCal * 34);
			
			Long calCrabLong = Math.round(totalCal);
			int totalCalCrab = Integer.valueOf(calCrabLong.intValue());
			return totalCalCrab;
			
		case EEL:
			totalCal = ingreCal * 82;
			totalCal += (riceCal * 34);
			
			Long calEelLong = Math.round(totalCal);
			int totalCalEel = Integer.valueOf(calEelLong.intValue());
			return totalCalEel;
			
			
		case SHRIMP:
			totalCal = ingreCal * 32;
			totalCal += (riceCal * 34);
			
			Long calShrimpLong = Math.round(totalCal);
			int totalCalShrimp = Integer.valueOf(calShrimpLong.intValue());
			return totalCalShrimp;
			
			
		case TUNA:
			totalCal = ingreCal * 42;
			totalCal += (riceCal * 34);
			
			Long calTunaLong = Math.round(totalCal);
			int totalCalTuna = Integer.valueOf(calTunaLong.intValue());
			return totalCalTuna;
			
			
			
		case YELLOWTAIL:
			totalCal = ingreCal * 57;
			totalCal += (riceCal * 34);
			
			Long calYellowtailLong = Math.round(totalCal);
			int totalCalYellowtail = Integer.valueOf(calYellowtailLong.intValue());
			return totalCalYellowtail;
			
			
			
		default:
			break;
		
		}
		
		return 0;
		
	}

	
	public double getCost() {
		
		double amount = 0.75;
		double costOfRice = 0.13;
		double amountOfRice = 0.50; 
		
		switch (type) {

		case CRAB:
			amount *= 0.72;
			amount += (costOfRice * amountOfRice);
			
			return amount;

		case EEL:
			amount *= 2.14;
			amount += (costOfRice * amountOfRice);
			return amount + 0.01;

		case SHRIMP:
			amount *= 0.65;
			amount += (costOfRice * amountOfRice);
			return amount;

		case TUNA:
			amount *= 1.67;
			amount += (costOfRice * amountOfRice);
			return amount;

		case YELLOWTAIL:
			amount *= 0.74;
			amount += (costOfRice * amountOfRice);
			return amount;

		default:
			break;

		}
		return amount;
		
	}

	
	public boolean getHasRice() {
		return true;
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
