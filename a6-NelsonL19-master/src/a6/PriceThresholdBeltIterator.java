package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PriceThresholdBeltIterator implements Iterator<Plate>{

	private Belt belt;
	private int startPosition;
	private int currentIndex; 
	private double maxPrice;
	private boolean calledNext;

	public PriceThresholdBeltIterator(Belt belt, int startPosition, double maxPrice) {
		if (belt == null) {
			throw new RuntimeException();
		}

		if (maxPrice < 0) {
			throw new RuntimeException();
		}

		this.belt = belt; 
		this.startPosition = startPosition; 
		this.currentIndex = startPosition; 
		this.maxPrice = maxPrice; 
		calledNext = false;
	}


	public boolean hasNext() {

		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(currentIndex) != null && belt.getPlateAtPosition(currentIndex).getPrice() < maxPrice) {
				return true;
			}
			currentIndex++;
		}
		return false;

	} 


	public Plate next() {

		if (!this.hasNext()) {
			throw new NoSuchElementException();
		}
		calledNext = true;

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
