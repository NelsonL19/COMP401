package a5;


public class GoldPlate implements Plate{
	private Sushi contents; 
	private Plate.Color color; 
	private double price;
 


	public GoldPlate(Sushi contents, double price) {
		
		if (price < 5.0) {
			throw new IllegalArgumentException();
		}
		
		
		this.color = Plate.Color.GOLD; 
		this.contents = contents;
		this.price = price; 

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
		if (s.getCost() > this.price) {
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
		return price;
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
		x = (getPrice() - contents.getCost());
		
		doub = String.format("%.2f", x - .005);
		x = Double.parseDouble(doub);
		return x;  

	}

}
