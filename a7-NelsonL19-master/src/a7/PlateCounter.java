package a7;

import a7.PlateEvent.EventType;
import comp401sushi.Plate;
import comp401sushi.Plate.Color;
import comp401sushi.PlateImpl;

public class PlateCounter implements BeltObserver {

	private int redCounter;
	private int blueCounter; 
	private int greenCounter;
	private int goldCounter;

	public PlateCounter(Belt b) {
		if (b == null) {
			throw new IllegalArgumentException();
		}
		
		redCounter = 0;
		blueCounter = 0;
		greenCounter = 0;
		goldCounter = 0;
		
		for ( int i = 0; i < b.getSize(); i++ ) {
			if ( b.getPlateAtPosition(i) != null ) {
				if (b.getPlateAtPosition(i).getColor().equals(Plate.Color.BLUE)) {
					blueCounter++;		
				}
				
				if (b.getPlateAtPosition(i).getColor().equals(Plate.Color.RED)) {
					redCounter++;
				}
				
				if (b.getPlateAtPosition(i).getColor().equals(Plate.Color.GREEN)) {
					greenCounter++;
				}
				
				if (b.getPlateAtPosition(i).getColor().equals(Plate.Color.GOLD)) {
					goldCounter++;
				}
			}
		}
		
		b.addBeltObserver(this);
	}

	

	public void handlePlateEvent(PlateEvent e) {
		Plate current = e.getPlate();
		Color currColo = current.getColor();
		EventType currType = e.getType();

		if (currType.equals(EventType.PLATE_PLACED)) {

			if (currColo.equals(Color.BLUE)) {
				blueCounter++;
			}
			
			if (currColo.equals(Color.RED)) {
				redCounter++;
			}
			
			if (currColo.equals(Color.GREEN)) {
				greenCounter++;
			}
			
			if (currColo.equals(Color.GOLD)) {
				goldCounter++;
			}
			
		}
		
		if (currType.equals(EventType.PLATE_REMOVED)) {

			if (currColo.equals(Color.BLUE)) {
				blueCounter--;
			}
			
			if (currColo.equals(Color.RED)) {
				redCounter--;
			}
			
			if (currColo.equals(Color.GREEN)) {
				greenCounter--;
			}
			
			if (currColo.equals(Color.GOLD)) {
				goldCounter--;
			}
			
		}
		
		
	}




	public int getRedPlateCount() {
		return redCounter;
	}
	public int getGreenPlateCount() {
		return greenCounter;
	}
	public int getBluePlateCount() {
		return blueCounter;
	}
	public int getGoldPlateCount() {
		return goldCounter;
	}


}
