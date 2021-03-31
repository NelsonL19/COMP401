package sushigame.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import comp401sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class BeltView extends JPanel implements BeltObserver {

	private Belt belt;
	private JLabel[] belt_labels;
	private PlateInfo[] plateViews;

	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize()/2, 2));
		belt_labels = new JLabel[belt.getSize()];
		plateViews = new PlateInfo[belt.getSize()];
		for (int i = 0; i < belt.getSize(); i++) {
			JLabel plabel = new JLabel("");
			plabel.setMinimumSize(new Dimension(300, 60));
			plabel.setPreferredSize(new Dimension(300, 60));
			plabel.setOpaque(true);
			plabel.setBackground(Color.BLACK);
			plabel.setAlignmentY(LEFT_ALIGNMENT);
			
			plateViews[i] = new PlateInfo(plabel);
			
			
			add(plabel);
			belt_labels[i] = plabel;
		}
		refresh();
	}




	@Override
	public void handleBeltEvent(BeltEvent e) {	
		refresh();
	}

	private void refresh() {

		try{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch(Exception e){
			e.printStackTrace(); 
		}


		for (int i=0; i<belt.getSize(); i++) {
			Plate p = belt.getPlateAtPosition(i);
			JLabel plabel = belt_labels[i];

			if (p == null) {
				plabel.setText("No Plate at Belt Location " + (i + 1));
				plabel.setBackground(Color.GRAY);

			} else {

				String info = "<html>";
				info += "Chef: " + p.getChef().getName() + "<br>";
				info += "Contents: " + p.getContents().getName() + "<br>";
				info += "Plate Age:" + belt.getAgeOfPlateAtPosition(i)+ "<br>";
				info += "Belt Position: " + (i+1) + "<br>";
				plabel.setText(info);
				
				

				plateViews[i].refresh(p);
				
				switch (p.getColor()) {
				case RED:
					plabel.setBackground(Color.RED);
					break;
				case GREEN:
					plabel.setBackground(Color.GREEN); 
					break;
				case BLUE:
					plabel.setBackground(Color.BLUE); 
					break;
				case GOLD:
					plabel.setBackground(Color.YELLOW); 
					break;
					
					
				}
			}



		}









	}



}
