package sushigame.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver {

	private SushiGameModel game_model;
	private JLabel display;
	private int counts;

	public ScoreboardWidget(SushiGameModel gm) {
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);
		counts = 0;

		display = new JLabel();
		display.setVerticalAlignment(SwingConstants.TOP);
		setLayout(new BorderLayout());
		display.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (counts < 2) {
					counts++;
				} else {
					counts = 0;
				}

				refresh();

			}

		});


		add(display, BorderLayout.CENTER);
		display.setText(makeScoreboardHTMLPrice());
	}

	private String makeScoreboardHTMLPrice() {
		String sb_html = "<html>";
		sb_html += "<h1>Scoreboard: Profit</h1>";
		sb_html += "<h2>Click to Advance Scoreboard Styles </h2>" + "<br>";

		// Create an array of all chefs and sort by balance.
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		Arrays.sort(chefs, new HighToLowBalanceComparator());

		for (Chef c : chefs) {
			sb_html += c.getName() + " ($" + Math.round(c.getBalance()*100.0)/100.0 + ") <br>";
		}



		return sb_html;
	}

	private String makeScoreboardHTMLTotal() {
		String sb_html = "<html>";
		sb_html += "<h1>Scoreboard : Total Amount Sold </h1>";
		sb_html += "<h2>Click to Advance Scoreboard Styles </h2>" + "<br>";


		// Create an array of all chefs and sort by balance.
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		Arrays.sort(chefs, new HighToLowBalanceComparator());

		for (Chef c : chefs) {
			sb_html += c.getName() + " Ounces: " + c.totalFoodConsumed()  +"<br>";
		}



		return sb_html;
	}

	private String makeScoreboardHTMLSpoiled() {
		String sb_html = "<html>";
		sb_html += "<h1>Scoreboard: Spoiled </h1>";
		sb_html += "<h2>Click to Advance Scoreboard Styles </h2>" + "<br>";


		// Create an array of all chefs and sort by balance.
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		Arrays.sort(chefs, new HighToLowBalanceComparator());

		for (Chef c : chefs) {
			sb_html += c.getName() + " Ounces: " + c.totalFoodSpoiled() + "<br>";
		}



		return sb_html;
	}






	public void refresh() {
		if (counts == 0) {
			display.setText(makeScoreboardHTMLPrice());		
		}

		if (counts == 1) {
			display.setText(makeScoreboardHTMLTotal());		
		}

		if (counts == 2) {
			display.setText(makeScoreboardHTMLSpoiled());		
		}


	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			refresh();
		}		
	}

}
