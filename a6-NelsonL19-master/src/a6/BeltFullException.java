package a6;

public class BeltFullException extends Exception {
	
	Belt belt;
	
	public BeltFullException(Belt belt) {
		super("The Belt is full. It's size is " + belt.getSize() + ".");
		this.belt = belt;
	}
	 
	public Belt getBelt() {
		return belt;
	}

	
}
