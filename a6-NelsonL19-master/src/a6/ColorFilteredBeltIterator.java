package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ColorFilteredBeltIterator implements Iterator<Plate>{

	private Belt belt;
	private int startPosition;
	private int currentIndex; 
	private Plate.Color colorFilter;


	public ColorFilteredBeltIterator(Belt belt, int startPosition, Plate.Color colorFilter) {	
		if (belt == null) {
			throw new RuntimeException();
		}



		this.belt = belt; 
		this.startPosition = startPosition; 
		this.currentIndex = startPosition; 
		this.colorFilter = colorFilter;

	}





	public boolean hasNext() {

		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(currentIndex) != null&& belt.getPlateAtPosition(currentIndex).getColor().equals(colorFilter)) {
				return true;
				}
				currentIndex++;
			}
		
		return false;	 
	}


	boolean calledNext = false; 


	public Plate next() {
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		}
		calledNext = true;

		while (belt.getPlateAtPosition(currentIndex) == null) {
			currentIndex++;
		}

		Plate currentPlate = belt.getPlateAtPosition(currentIndex);
		currentIndex++;
		return currentPlate; 
	}

	public void remove() {
		if (!calledNext) {
			throw new IllegalStateException();
		}
		calledNext = false; 

		belt.removePlateAtPosition(currentIndex-1);
	}


}
