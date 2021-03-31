package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

import a6.Plate.Color;

public class BeltImpl implements Belt {

	private int beltSize;
	private Plate[] plateLength;

	public BeltImpl(int beltSize) {
		if (beltSize <= 0) {
			throw new IllegalArgumentException("Belt Size is less than 0");		
		}

		this.beltSize = beltSize; 
		plateLength = new Plate[beltSize];
	}
	public int getSize() {
		return beltSize;
	}


	public Plate[] getPlate() {
		return plateLength;
	}
	
	public Plate getPlateAtPosition(int position) {
		return plateLength[wrapAround(position)];

	}


	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}
		if (plateLength[wrapAround(position)] != null) {
			throw new BeltPlateException(position, plate, this);
		}
		
		plateLength[wrapAround(position)] = plate; 
	}


	public void clearPlateAtPosition(int position) {
		plateLength[position] = null; 
	}


	public Plate removePlateAtPosition(int position) {
		Plate current = getPlateAtPosition(position);
		if (current == null) {
			throw new NoSuchElementException();
		}
		clearPlateAtPosition(position);
		return current;
	}

	public int wrapAround(int position) {

		int finalPosition = ((position % this.getSize()) + this.getSize()) % this.getSize();


		return finalPosition;

	}


	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		if (plateLength[position] == null) {
			plateLength[position] = plate; 
			return position;
		}

		for (int i = position; i < plateLength.length; i++) {
			if (plateLength[i] == null) {
				plateLength[wrapAround(i)] = plate;
				return i;
			}
		} throw new BeltFullException(this);
	}






	public Iterator<Plate> iterator() {

		Iterator<Plate> iter = new BeltIterator(this, 0);
		return iter; 
	}
	
	
	
	
	@Override
	public Iterator <Plate >iteratorFromPosition(int position) {
		Iterator<Plate> iter = new BeltIterator(this, position);
		return iter;
	}
	
	
	
	
	public void rotate() {
		Plate[] newBelt = new Plate[plateLength.length+1];
		
		for (int i = 0; i < newBelt.length; i++) {
			newBelt[wrapAround(i+1)] = plateLength[wrapAround(i)];
		}
		
		for (int i = 0; i < newBelt.length; i++) {
			plateLength[wrapAround(i)] = newBelt[wrapAround(i)];
		}
		
	}
	
	
	@Override
	public Iterator<Plate> iterator(double maxPrice) {
		Iterator<Plate> iter = new PriceThresholdBeltIterator(this, 0 , maxPrice);
		return iter; 
	}
	@Override
	public Iterator<Plate> iterator(Color color) {
		Iterator<Plate> iter = new ColorFilteredBeltIterator(this, 0 , color);
		return iter;
	}
	@Override
	public Iterator<Plate> iteratorFromPosition(int position, double maxPrice) {
		Iterator<Plate> iter = new PriceThresholdBeltIterator(this, position, maxPrice);
		return iter;
	}
	@Override
	public Iterator<Plate> iteratorFromPosition(int position, Color color) {
		Iterator<Plate> iter = new ColorFilteredBeltIterator(this, position , color);
		return iter;
	}
}

