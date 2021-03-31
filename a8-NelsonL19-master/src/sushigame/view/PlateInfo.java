package sushigame.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401sushi.IngredientPortion;
import comp401sushi.Plate;

public class PlateInfo extends JPanel {

	private JLabel beltPositions; 
	private String contents;

	public PlateInfo(JLabel beltPositions) {
		this.beltPositions = beltPositions;	

		contents = "No Plate on Belt Position";

		this.beltPositions.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JLabel ingres = new JLabel(contents, JLabel.CENTER);
				JFrame platewidget = new JFrame("Plate Ingredients");
				platewidget.setVisible(true);
				platewidget.setSize(250,500);
				platewidget.add(ingres);
			}
		});


	}



	public void refresh(Plate plate) {
		if (plate == null) {
			contents = "No Plate on Belt Position";
		} else {
			
			String finalText = "<html>";
			
			if (plate.getColor().equals(Plate.Color.GOLD)) {
				finalText += "Plate Price: " + plate.getPrice() + "<br>";
			}
			
			finalText += "<br>";
			
			finalText += "Ingredients: " + "<br>";
			IngredientPortion[] help = plate.getContents().getIngredients();

			for (int i = 0; i < help.length; i++) {
				finalText += help[i].getName() + "<br>";
				finalText += "Amount: " + help[i].getAmount() + "<br>";
				
				finalText += "<br>";
				
			}
			
			finalText += plate.getClass().getName() + "<br>";
			
			
			
			contents = finalText;

		}





	}




}
