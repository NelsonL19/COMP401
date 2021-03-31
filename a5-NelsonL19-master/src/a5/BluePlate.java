package a5;

public class BluePlate implements Plate {
	
	private Sushi contents; 
	private Plate.Color color; 
 


	public BluePlate(Sushi contents) {
		this.color = Plate.Color.BLUE; 
		this.contents = contents;

	}


	public Sushi getContents() {
		return contents;
	}


	public Sushi removeContents() {
		Sushi temp = contents;
		contents = null;
		return temp;
	}


	public void setContents(Sushi s) throws PlatePriceException {
		if (s.getCost() > 4.0) {
			throw new PlatePriceException(); 
		} else {
			contents = s; 
		}
	}



	public boolean hasContents() {
		if (contents == null) {
		return false;
		}
			return true;
	}


	public double getPrice() {
		return 4.0;
	}


	public Color getColor() {
		return color;
	}

String doub = "";
	
	public double getProfit() {
		if (contents == null) {
			return 0;
		}
		double x = 0.00; 
		x = (4.0 - contents.getCost());
		
		doub = String.format("%.2f", x - .005);
		x = Double.parseDouble(doub);
		return x;  

	}

	

}
