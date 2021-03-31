package sushigame.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

import comp401sushi.AvocadoPortion;
import comp401sushi.CrabPortion;
import comp401sushi.EelPortion;
import comp401sushi.IngredientPortion;
import comp401sushi.Nigiri;
import comp401sushi.Plate;
import comp401sushi.RedPlate;
import comp401sushi.RicePortion;
import comp401sushi.Roll;
import comp401sushi.Sashimi;
import comp401sushi.Sashimi.SashimiType;
import comp401sushi.SeaweedPortion;
import comp401sushi.ShrimpPortion;
import comp401sushi.Sushi;
import comp401sushi.TunaPortion;
import comp401sushi.YellowtailPortion;
import comp401sushi.Nigiri.NigiriType;

public class PlayerChefView extends JPanel implements ActionListener {

	private List<ChefViewListener> listeners;
	private Sushi newRoll;
	private Sushi sashimi;
	private Sushi nigiri;
	private int belt_size;

	public PlayerChefView(int belt_size) {
		this.belt_size = belt_size;
		listeners = new ArrayList<ChefViewListener>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JButton sashimi_button = new JButton("Make a new Plate of Sashimi");
		sashimi_button.setActionCommand("red_crab_sashimi_at_3");
		sashimi_button.addActionListener(this);
		add(sashimi_button);

		JButton nigiri_button = new JButton("Make a new Plate of Nigiri");
		nigiri_button.setActionCommand("create_new_nigiri");
		nigiri_button.addActionListener(this);
		add(nigiri_button);

		JButton roll_button = new JButton("Make a new Sushi Roll");
		roll_button.setActionCommand("create_new_roll");
		roll_button.addActionListener(this);
		add(roll_button);

		
	}

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	String [] rollKindOfPlate = new String[] {"Blue", "Green", "Red", "Gold"};



	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "red_crab_sashimi_at_3":
			

			String[] sashimiOptions = new String[] {"Tuna", "Yellow", "Eel", "Crab", "Shrimp"};
			int typesashimi;

			typesashimi = JOptionPane.showOptionDialog(null, "What type of Sashimi", "Create new Sashimi", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, sashimiOptions, sashimiOptions[0]);

			switch (typesashimi) {
			case 0:

				String position;
				position = JOptionPane.showInputDialog(null, "Position on Belt? (Whole Numbers)", 
						"Belt Position", JOptionPane.OK_CANCEL_OPTION);

				Double beltPost = Double.parseDouble(position);
				int finalBelt = beltPost.intValue();
				finalBelt--;

				int plateIndex;
				plateIndex = JOptionPane.showOptionDialog(null, "What will be the Plate Color", "Plate Color", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, rollKindOfPlate, rollKindOfPlate[0]);

				switch (plateIndex) {
				case 0:

					makeBluePlateRequest(new Sashimi(SashimiType.TUNA), finalBelt);
					break; 


				case 1: 
					makeGreenPlateRequest(new Sashimi(SashimiType.TUNA), finalBelt);
					break; 

				case 2: 
					makeRedPlateRequest(new Sashimi(SashimiType.TUNA), finalBelt);
					break; 
				case 3:

					String gPlateVal;
					String currCheck = "";
					gPlateVal = JOptionPane.showInputDialog(null, "Value of Plate between $5.00 and $10.00", 
							"Plate Value", JOptionPane.OK_CANCEL_OPTION);

					currCheck = gPlateVal;

					if (currCheck.substring(0).contains("$")) {
						gPlateVal = gPlateVal.substring(1, gPlateVal.length());
					}



					Double price = Double.parseDouble(gPlateVal);


					makeGoldPlateRequest(new Sashimi(SashimiType.TUNA), finalBelt, price);
					break; 
				}

				break;
			case 1:

				String yellowPosition;
				yellowPosition = JOptionPane.showInputDialog(null, "Position on Belt? (Whole Numbers)", 
						"Belt Position", JOptionPane.OK_CANCEL_OPTION);

				Double yellowBelt = Double.parseDouble(yellowPosition);
				int finalBeltYellow = yellowBelt.intValue();
				finalBeltYellow--;


				plateIndex = JOptionPane.showOptionDialog(null, "What will be the Plate Color", "Plate Color", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, rollKindOfPlate, rollKindOfPlate[0]);

				switch (plateIndex) {
				case 0:
					makeBluePlateRequest(new Sashimi(SashimiType.YELLOWTAIL), finalBeltYellow);
					break; 
				case 1:
					makeGreenPlateRequest(new Sashimi(SashimiType.YELLOWTAIL), finalBeltYellow);
					break; 
				case 2:
					makeRedPlateRequest(new Sashimi(SashimiType.YELLOWTAIL), finalBeltYellow);
					break; 
				case 3:

					String gPlateVal;
					String currCheck = "";
					gPlateVal = JOptionPane.showInputDialog(null, "Value of Plate between $5.00 and $10.00", 
							"Plate Value", JOptionPane.OK_CANCEL_OPTION);

					currCheck = gPlateVal;

					if (currCheck.substring(0).contains("$")) {
						gPlateVal = gPlateVal.substring(1, gPlateVal.length());
					}



					Double price = Double.parseDouble(gPlateVal);


					makeGoldPlateRequest(new Sashimi(SashimiType.YELLOWTAIL), finalBeltYellow, price);
					break; 


				}


				break;
			case 2:
				String eelPosition;
				eelPosition = JOptionPane.showInputDialog(null, "Position on Belt? (Whole Numbers)", 
						"Belt Position", JOptionPane.OK_CANCEL_OPTION);

				Double eelBelt = Double.parseDouble(eelPosition);
				int finalBeltEel = eelBelt.intValue();
				finalBeltEel--;


				plateIndex = JOptionPane.showOptionDialog(null, "What will be the Plate Color", "Plate Color", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, rollKindOfPlate, rollKindOfPlate[0]);

				switch (plateIndex) {
				case 0:
					makeBluePlateRequest(new Sashimi(SashimiType.EEL), finalBeltEel);
					break; 
				case 1:
					makeGreenPlateRequest(new Sashimi(SashimiType.EEL), finalBeltEel);
					break; 
				case 2:
					makeRedPlateRequest(new Sashimi(SashimiType.EEL), finalBeltEel);
					break; 
				case 3:

					String gPlateVal;
					String currCheck = "";
					gPlateVal = JOptionPane.showInputDialog(null, "Value of Plate between $5.00 and $10.00", 
							"Plate Value", JOptionPane.OK_CANCEL_OPTION);

					currCheck = gPlateVal;

					if (currCheck.substring(0).contains("$")) {
						gPlateVal = gPlateVal.substring(1, gPlateVal.length());
					}



					Double price = Double.parseDouble(gPlateVal);


					makeGoldPlateRequest(new Sashimi(SashimiType.EEL), finalBeltEel, price);
					break; 





				}
				break;
			case 3:

				String crabPosition;
				crabPosition = JOptionPane.showInputDialog(null, "Position on Belt? (Whole Numbers)", 
						"Belt Position", JOptionPane.OK_CANCEL_OPTION);

				Double crabBelt = Double.parseDouble(crabPosition);
				int finalBeltCrab = crabBelt.intValue();
				finalBeltCrab--;


				plateIndex = JOptionPane.showOptionDialog(null, "What will be the Plate Color", "Plate Color", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, rollKindOfPlate, rollKindOfPlate[0]);

				switch (plateIndex) {
				case 0:
					makeBluePlateRequest(new Sashimi(SashimiType.CRAB), finalBeltCrab);
					break; 
				case 1:
					makeGreenPlateRequest(new Sashimi(SashimiType.CRAB), finalBeltCrab);
					break; 
				case 2:
					makeRedPlateRequest(new Sashimi(SashimiType.CRAB), finalBeltCrab);
					break; 
				case 3:

					String gPlateVal;
					String currCheck = "";
					gPlateVal = JOptionPane.showInputDialog(null, "Value of Plate between $5.00 and $10.00", 
							"Plate Value", JOptionPane.OK_CANCEL_OPTION);

					currCheck = gPlateVal;

					if (currCheck.substring(0).contains("$")) {
						gPlateVal = gPlateVal.substring(1, gPlateVal.length());
					}



					Double price = Double.parseDouble(gPlateVal);


					makeGoldPlateRequest(new Sashimi(SashimiType.CRAB), finalBeltCrab, price);
					break; 

				}


				break;
			case 4:


				String shrimpPosition;
				shrimpPosition = JOptionPane.showInputDialog(null, "Position on Belt? (Whole Numbers)", 
						"Belt Position", JOptionPane.OK_CANCEL_OPTION);

				Double shrimpBelt = Double.parseDouble(shrimpPosition);
				int finalBeltShrimp = shrimpBelt.intValue();
				finalBeltShrimp--;


				plateIndex = JOptionPane.showOptionDialog(null, "What will be the Plate Color", "Plate Color", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, rollKindOfPlate, rollKindOfPlate[0]);

				switch (plateIndex) {
				case 0:
					makeBluePlateRequest(new Sashimi(SashimiType.SHRIMP), finalBeltShrimp);
					break; 
				case 1:
					makeGreenPlateRequest(new Sashimi(SashimiType.SHRIMP), finalBeltShrimp);
					break; 
				case 2:
					makeRedPlateRequest(new Sashimi(SashimiType.SHRIMP), finalBeltShrimp);
					break; 
				case 3:

					String gPlateVal;
					String currCheck = "";
					gPlateVal = JOptionPane.showInputDialog(null, "Value of Plate between $5.00 and $10.00", 
							"Plate Value", JOptionPane.OK_CANCEL_OPTION);

					currCheck = gPlateVal;

					if (currCheck.substring(0).contains("$")) {
						gPlateVal = gPlateVal.substring(1, gPlateVal.length());
					}



					Double price = Double.parseDouble(gPlateVal);


					makeGoldPlateRequest(new Sashimi(SashimiType.SHRIMP), finalBeltShrimp, price);
					break; 

				}



				break;
			}

			break;
			
		
		case "create_new_nigiri":

			String[] nigiriOptions = new String[] {"Tuna", "Yellow", "Eel", "Crab", "Shrimp"};
			int typeNigiri;

			typeNigiri = JOptionPane.showOptionDialog(null, "What type of Nigiri", "Create new Nigiri", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, nigiriOptions, nigiriOptions[0]);

			switch (typeNigiri) {
			case 0:

				String position;
				position = JOptionPane.showInputDialog(null, "Position on Belt? (Whole Numbers)", 
						"Belt Position", JOptionPane.OK_CANCEL_OPTION);

				Double beltPost = Double.parseDouble(position);
				int finalBelt = beltPost.intValue();
				finalBelt--;

				int plateIndex;
				plateIndex = JOptionPane.showOptionDialog(null, "What will be the Plate Color", "Plate Color", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, rollKindOfPlate, rollKindOfPlate[0]);

				switch (plateIndex) {
				case 0:

					makeBluePlateRequest(new Nigiri(NigiriType.TUNA), finalBelt);
					break; 


				case 1: 
					makeGreenPlateRequest(new Nigiri(NigiriType.TUNA), finalBelt);
					break; 

				case 2: 
					makeRedPlateRequest(new Nigiri(NigiriType.TUNA), finalBelt);
					break; 
				case 3:

					String gPlateVal;
					String currCheck = "";
					gPlateVal = JOptionPane.showInputDialog(null, "Value of Plate between $5.00 and $10.00", 
							"Plate Value", JOptionPane.OK_CANCEL_OPTION);

					currCheck = gPlateVal;

					if (currCheck.substring(0).contains("$")) {
						gPlateVal = gPlateVal.substring(1, gPlateVal.length());
					}



					Double price = Double.parseDouble(gPlateVal);


					makeGoldPlateRequest(new Nigiri(NigiriType.TUNA), finalBelt, price);
					break; 
				}

				break;
			case 1:

				String yellowPosition;
				yellowPosition = JOptionPane.showInputDialog(null, "Position on Belt? (Whole Numbers)", 
						"Belt Position", JOptionPane.OK_CANCEL_OPTION);

				Double yellowBelt = Double.parseDouble(yellowPosition);
				int finalBeltYellow = yellowBelt.intValue();
				finalBeltYellow--;


				plateIndex = JOptionPane.showOptionDialog(null, "What will be the Plate Color", "Plate Color", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, rollKindOfPlate, rollKindOfPlate[0]);

				switch (plateIndex) {
				case 0:
					makeBluePlateRequest(new Nigiri(NigiriType.YELLOWTAIL), finalBeltYellow);
					break; 
				case 1:
					makeGreenPlateRequest(new Nigiri(NigiriType.YELLOWTAIL), finalBeltYellow);
					break; 
				case 2:
					makeRedPlateRequest(new Nigiri(NigiriType.YELLOWTAIL), finalBeltYellow);
					break; 
				case 3:

					String gPlateVal;
					String currCheck = "";
					gPlateVal = JOptionPane.showInputDialog(null, "Value of Plate between $5.00 and $10.00", 
							"Plate Value", JOptionPane.OK_CANCEL_OPTION);

					currCheck = gPlateVal;

					if (currCheck.substring(0).contains("$")) {
						gPlateVal = gPlateVal.substring(1, gPlateVal.length());
					}



					Double price = Double.parseDouble(gPlateVal);


					makeGoldPlateRequest(new Nigiri(NigiriType.YELLOWTAIL), finalBeltYellow, price);
					break; 


				}


				break;
			case 2:
				String eelPosition;
				eelPosition = JOptionPane.showInputDialog(null, "Position on Belt? (Whole Numbers)", 
						"Belt Position", JOptionPane.OK_CANCEL_OPTION);

				Double eelBelt = Double.parseDouble(eelPosition);
				int finalBeltEel = eelBelt.intValue();
				finalBeltEel--;


				plateIndex = JOptionPane.showOptionDialog(null, "What will be the Plate Color", "Plate Color", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, rollKindOfPlate, rollKindOfPlate[0]);

				switch (plateIndex) {
				case 0:
					makeBluePlateRequest(new Nigiri(NigiriType.EEL), finalBeltEel);
					break; 
				case 1:
					makeGreenPlateRequest(new Nigiri(NigiriType.EEL), finalBeltEel);
					break; 
				case 2:
					makeRedPlateRequest(new Nigiri(NigiriType.EEL), finalBeltEel);
					break; 
				case 3:

					String gPlateVal;
					String currCheck = "";
					gPlateVal = JOptionPane.showInputDialog(null, "Value of Plate between $5.00 and $10.00", 
							"Plate Value", JOptionPane.OK_CANCEL_OPTION);

					currCheck = gPlateVal;

					if (currCheck.substring(0).contains("$")) {
						gPlateVal = gPlateVal.substring(1, gPlateVal.length());
					}



					Double price = Double.parseDouble(gPlateVal);


					makeGoldPlateRequest(new Nigiri(NigiriType.EEL), finalBeltEel, price);
					break; 





				}
				break;
			case 3:

				String crabPosition;
				crabPosition = JOptionPane.showInputDialog(null, "Position on Belt? (Whole Numbers)", 
						"Belt Position", JOptionPane.OK_CANCEL_OPTION);

				Double crabBelt = Double.parseDouble(crabPosition);
				int finalBeltCrab = crabBelt.intValue();
				finalBeltCrab--;


				plateIndex = JOptionPane.showOptionDialog(null, "What will be the Plate Color", "Plate Color", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, rollKindOfPlate, rollKindOfPlate[0]);

				switch (plateIndex) {
				case 0:
					makeBluePlateRequest(new Nigiri(NigiriType.CRAB), finalBeltCrab);
					break; 
				case 1:
					makeGreenPlateRequest(new Nigiri(NigiriType.CRAB), finalBeltCrab);
					break; 
				case 2:
					makeRedPlateRequest(new Nigiri(NigiriType.CRAB), finalBeltCrab);
					break; 
				case 3:

					String gPlateVal;
					String currCheck = "";
					gPlateVal = JOptionPane.showInputDialog(null, "Value of Plate between $5.00 and $10.00", 
							"Plate Value", JOptionPane.OK_CANCEL_OPTION);

					currCheck = gPlateVal;

					if (currCheck.substring(0).contains("$")) {
						gPlateVal = gPlateVal.substring(1, gPlateVal.length());
					}



					Double price = Double.parseDouble(gPlateVal);


					makeGoldPlateRequest(new Nigiri(NigiriType.CRAB), finalBeltCrab, price);
					break; 

				}


				break;
			case 4:


				String shrimpPosition;
				shrimpPosition = JOptionPane.showInputDialog(null, "Position on Belt? (Whole Numbers)", 
						"Belt Position", JOptionPane.OK_CANCEL_OPTION);

				Double shrimpBelt = Double.parseDouble(shrimpPosition);
				int finalBeltShrimp = shrimpBelt.intValue();
				finalBeltShrimp--;


				plateIndex = JOptionPane.showOptionDialog(null, "What will be the Plate Color", "Plate Color", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, rollKindOfPlate, rollKindOfPlate[0]);

				switch (plateIndex) {
				case 0:
					makeBluePlateRequest(new Nigiri(NigiriType.SHRIMP), finalBeltShrimp);
					break; 
				case 1:
					makeGreenPlateRequest(new Nigiri(NigiriType.SHRIMP), finalBeltShrimp);
					break; 
				case 2:
					makeRedPlateRequest(new Nigiri(NigiriType.SHRIMP), finalBeltShrimp);
					break; 
				case 3:

					String gPlateVal;
					String currCheck = "";
					gPlateVal = JOptionPane.showInputDialog(null, "Value of Plate between $5.00 and $10.00", 
							"Plate Value", JOptionPane.OK_CANCEL_OPTION);

					currCheck = gPlateVal;

					if (currCheck.substring(0).contains("$")) {
						gPlateVal = gPlateVal.substring(1, gPlateVal.length());
					}



					Double price = Double.parseDouble(gPlateVal);


					makeGoldPlateRequest(new Nigiri(NigiriType.SHRIMP), finalBeltShrimp, price);
					break; 

				}



				break;
			}

			break;
		case "create_new_roll":
			String nameOfRoll = "";
			String nameinput;
			nameinput = JOptionPane.showInputDialog(null, "Enter a Roll name", 
					"Set Name", JOptionPane.OK_CANCEL_OPTION);
			nameOfRoll = (String.valueOf(nameinput));

			String[] amtIngredients = new String[] {"1", "2", "3", "4","5","6", "7" , "8"};


			int numOfIngres;
			numOfIngres = JOptionPane.showOptionDialog(null, "Number of Ingredients", "Number of Ingredients", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, amtIngredients, amtIngredients[0]);
			numOfIngres++;

			String [] ingreLists = new String[] {"Avocado", "Crab", "Eel", "Rice", "Yellowtail", "Seaweed", "Shrimp", "Tuna"};

			IngredientPortion[] ingreList = new IngredientPortion[numOfIngres];
			for (int i = 0; i < numOfIngres; i++) {

				int ingIndex;

				ingIndex = JOptionPane.showOptionDialog(null, "Which Ingredient?", "Which Ingredient?", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, ingreLists, ingreLists[0]);

				switch (ingIndex) {
				case 0:

					String avoInput;
					avoInput = JOptionPane.showInputDialog(null, "Amount of Ingredient (No More than 1.5 Ounces)", 
							"Amount of Ingrdient (No More than 1.5 Ounces)", JOptionPane.OK_CANCEL_OPTION);
					double avoPort = Double.parseDouble(avoInput);
					ingreList[i] = new AvocadoPortion(avoPort);
					break;

				case 1:

					String crabInput;
					crabInput = JOptionPane.showInputDialog(null, "Amount of Ingredient (No More than 1.5 Ounces)", 
							"Amount of Ingrdient (No More than 1.5 Ounces)", JOptionPane.OK_CANCEL_OPTION);
					double crabPort = Double.parseDouble(crabInput);
					ingreList[i] = new CrabPortion(crabPort);
					break;

				case 2:

					String eelInput;
					eelInput = JOptionPane.showInputDialog(null, "Amount of Ingredient (No More than 1.5 Ounces)", 
							"Amount of Ingrdient (No More than 1.5 Ounces)", JOptionPane.OK_CANCEL_OPTION);
					double eelPort = Double.parseDouble(eelInput);
					ingreList[i] = new CrabPortion(eelPort);
					break;

				case 3:

					String riceInput;
					riceInput = JOptionPane.showInputDialog(null, "Amount of Ingredient (No More than 1.5 Ounces)", 
							"Amount of Ingrdient (No More than 1.5 Ounces)", JOptionPane.OK_CANCEL_OPTION);
					double ricePort = Double.parseDouble(riceInput);
					ingreList[i] = new RicePortion(ricePort);
					break;

				case 4:

					String yellowInput;
					yellowInput = JOptionPane.showInputDialog(null, "Amount of Ingredient (No More than 1.5 Ounces)", 
							"Amount of Ingrdient (No More than 1.5 Ounces)", JOptionPane.OK_CANCEL_OPTION);
					double yellowPort = Double.parseDouble(yellowInput);
					ingreList[i] = new YellowtailPortion(yellowPort);
					break;

				case 5: 

					String seaInput;
					seaInput = JOptionPane.showInputDialog(null, "Amount of Ingredient (No More than 1.5 Ounces)", 
							"Amount of Ingrdient (No More than 1.5 Ounces)", JOptionPane.OK_CANCEL_OPTION);
					double seaPort = Double.parseDouble(seaInput);
					ingreList[i] = new SeaweedPortion(seaPort);
					break;

				case 6: 

					String shrimpInput;
					shrimpInput = JOptionPane.showInputDialog(null, "Amount of Ingredient (No More than 1.5 Ounces)", 
							"Amount of Ingrdient (No More than 1.5 Ounces)", JOptionPane.OK_CANCEL_OPTION);
					double shrimpPort = Double.parseDouble(shrimpInput);
					ingreList[i] = new ShrimpPortion(shrimpPort);
					break;

				case 7:

					String tunaInput;
					tunaInput = JOptionPane.showInputDialog(null, "Amount of Ingredient (No More than 1.5 Ounces)", 
							"Amount of Ingrdient (No More than 1.5 Ounces)", JOptionPane.OK_CANCEL_OPTION);
					double tunaPort = Double.parseDouble(tunaInput);
					ingreList[i] = new TunaPortion(tunaPort);
					break;


				}

			}

			newRoll = new Roll(nameOfRoll, ingreList);


			String position;
			position = JOptionPane.showInputDialog(null, "Position on Belt? (Whole Numbers)", 
					"Belt Position", JOptionPane.OK_CANCEL_OPTION);

			Double beltPost = Double.parseDouble(position);
			int finalBelt = beltPost.intValue();
			finalBelt--;


			int plateIndex;
			plateIndex = JOptionPane.showOptionDialog(null, "What will be the Plate Color", "Plate Color", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, rollKindOfPlate, rollKindOfPlate[0]);

			switch (plateIndex) {
			case 0:
				makeBluePlateRequest(newRoll, finalBelt);
				break;
			case 1: 
				makeGreenPlateRequest(newRoll, finalBelt);
				break;

			case 2:
				makeRedPlateRequest(newRoll, finalBelt);
				break;

			case 3:

				String gPlateVal;
				String currCheck = "";
				gPlateVal = JOptionPane.showInputDialog(null, "Value of Plate between $5.00 and $10.00", 
						"Plate Value", JOptionPane.OK_CANCEL_OPTION);

				currCheck = gPlateVal;

				if (currCheck.substring(0).contains("$")) {
					gPlateVal = gPlateVal.substring(1, gPlateVal.length());
				}



				Double price = Double.parseDouble(gPlateVal);


				makeGoldPlateRequest(newRoll, finalBelt, price);	
				break;

			}



		}
	}






}
