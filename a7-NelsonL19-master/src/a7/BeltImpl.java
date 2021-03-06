package a7;

import java.util.ArrayList;
import java.util.List;

import a7.PlateEvent.EventType;
import comp401sushi.Plate;


public class BeltImpl implements Belt {

	private Plate[] _belt;
	List<BeltObserver> currObservers;
	private Customer[] customers;

	public BeltImpl(int belt_size) {
		if (belt_size < 1) {
			throw new IllegalArgumentException("Illegal belt size");
		}

		_belt = new Plate[belt_size];
		currObservers = new ArrayList<BeltObserver>();
		customers = new Customer[belt_size];
	}



	@Override
	public int getSize() {
		return _belt.length;
	}

	@Override
	public Plate getPlateAtPosition(int position) {
		position = normalize_position(position);

		return _belt[normalize_position(position)];
	}

	@Override
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}

		position = normalize_position(position);

		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		}

		_belt[position] = plate;


		PlateEvent add = new PlateEvent(EventType.PLATE_PLACED, _belt[position] , position);
		for ( int i = 0; i < currObservers.size(); i++ ) {
			currObservers.get(i).handlePlateEvent(add);
		}

	}


	@Override
	public void clearPlateAtPosition(int position) {
		position = normalize_position(position);

		PlateEvent remove = new PlateEvent(EventType.PLATE_REMOVED, _belt[position] , position);


		_belt[position] = null; 

		for ( int i = 0; i < currObservers.size(); i++ ) {
			currObservers.get(i).handlePlateEvent(remove);
		}

	}

	private int normalize_position(int position) {
		int size = getSize();
		return (((position % size) + size) % size);
	}


	@Override
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		int offset = 0;
		position = normalize_position(position);

		while (offset < getSize()) {
			try {
				setPlateAtPosition(plate, position+offset);

				return normalize_position(position+offset);
			}
			catch (BeltPlateException e) {
				offset += 1;
			}
		}
		throw new BeltFullException(this);
	}

	@Override
	public void rotate() {
		Plate last_plate = _belt[getSize()-1];
		
		for (int i=getSize()-1; i>0; i--) {
			
			if ( _belt[i] != _belt[i-1]) {
				
				if ( customers[i] != null ) {
					
					customers[i].observePlateOnBelt(this, _belt[i-1], i-1);
				}
			}
			_belt[i] = _belt[i-1];
		}
		_belt[0] = last_plate;
		
		if ( customers[0] != null ) {
			
			customers[0].observePlateOnBelt(this, _belt[0], 0);
		}
	}


	public void addBeltObserver(BeltObserver o) {
		currObservers.add(o);
	}



	public void removeBeltObserver(BeltObserver o) {
		currObservers.remove(o);
	}


	public void registerCustomerAtPosition(Customer c, int position) {
		if (c == null) {
			throw new IllegalArgumentException();
		}
		if (customers[normalize_position(position)] != null) {
			throw new RuntimeException();
		}
		for (int i = 0; i < getSize(); i++) {
			if (customers[i] != null) {
				if ( customers[i].equals(c)) {
					throw new RuntimeException();
				}
			}
		}
		customers[normalize_position(position)] = c;
	}

	


	public Customer unregisterCustomerAtPosition(int position) {
		
		Customer currentCustomer;
		
		if (customers[normalize_position(position)] == null) {
			return null;
		}
		
		currentCustomer = customers[normalize_position(position)];
		customers[normalize_position(position)] = null;
		
		
		return currentCustomer;
	}
}
