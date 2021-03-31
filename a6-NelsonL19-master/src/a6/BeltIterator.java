package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BeltIterator implements Iterator<Plate> {

	private Belt belt;
	private int startPosition;
	private int currentIndex; 

	public BeltIterator(Belt belt, int startPosition) {
		if (belt == null) {
			throw new RuntimeException();
		}

		this.belt = belt; 
		this.startPosition = startPosition; 
		this.currentIndex = startPosition; 

	}

	public boolean hasNext() {
		for (Plate i : belt.getPlate()) {
			if (i != null) {
				return true;
			}
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
