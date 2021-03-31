package a7;

import a7.PlateEvent.EventType;
import comp401sushi.Plate.Color;


public class ProfitCounter implements BeltObserver {

	private double profit;
	private int length;	
	
	public ProfitCounter(Belt b) {
		if (b == null) {
			throw new IllegalArgumentException();
		}
		
		profit = 0;
		length = 0;

		for (int i = 0; i < b.getSize(); i++) {
			
			if (b.getPlateAtPosition(i)!= null && b.getPlateAtPosition(i).hasContents()) {
				profit += b.getPlateAtPosition(i).getProfit();
				length++;
			}
			
		}
		
		
		b.addBeltObserver(this);
		
	}
	
	public void handlePlateEvent(PlateEvent e) {
		double  currentProfit = e.getPlate().getProfit();
		EventType currType = e.getType();
		
		if (currType.equals(EventType.PLATE_PLACED)) {
			profit += currentProfit;
			length++;
		}
		
		if (currType.equals(EventType.PLATE_REMOVED)) {
			profit -= currentProfit;
			length--;
		}
	}

	public double getTotalBeltProfit() {
		
		
		return profit;
	}
	
	
	public double getAverageBeltProfit() {
		
		if (length == 0) {
			return 0; 
		}
		
		return getTotalBeltProfit() / length;
		
	}
	
	

}
