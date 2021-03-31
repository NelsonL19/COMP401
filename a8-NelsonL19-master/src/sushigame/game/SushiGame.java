package sushigame.game;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import media.GameMusic;
import sushigame.controller.SushiGameController;
import sushigame.model.SushiGameModel;
import sushigame.view.SushiGameView;


public class SushiGame {

	public static void main(String[] args) throws Exception {
		
		SushiGameModel game_model = new SushiGameModel(20, 5, 4);
		SushiGameView game_view = new SushiGameView(game_model);
		SushiGameController game_controller = new SushiGameController(game_model, game_view);
		
		
		
		
		
		JFrame main_frame = new JFrame();
		GameMusic.main(args);
		main_frame.setTitle("KMP Dreams Of Sushi");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main_frame.setContentPane(game_view);

		
		main_frame.pack();
		main_frame.setVisible(true);
		
		JFrame tutorial = new JFrame();
		tutorial.setTitle("Game Information");
		JLabel tutInfo = new JLabel();
		
		
		
		
		
		String tutText = "<html>";
		tutText += "<br>";
		tutText += "<br>";
		tutText += "<br>";
		tutText += "<br>";
		tutText += "<br>";
		tutText += "Tutorial Time!" + "<br>";
		tutText += "Place the sushi to make the most money!" + "<br>";
		tutText += "Click on each plate to view it's ingredients!" + "<br>";
		tutText += "Rotate and Create Plates to move the Belt!" + "<br>";
		tutText += "Make sure your computer sound is On!" +"<br>";
		tutText += "<br>";
		tutText += "<br>";
		tutText += "<br>";
		tutText += "<br>";
		tutText += "<br>";
		
		
		tutInfo.setText(tutText);
		
		
	
		tutInfo.setSize(300, 100);;
		tutorial.add(tutInfo);
		
		URL url = new URL("https://www.mediterrasian.com/images/main/sushi_rolls.jpg");
	    Image image = ImageIO.read(url);

	    JLabel label = new JLabel(new ImageIcon(image));
	    tutorial.getContentPane().add(label);
		
		
		tutorial.setSize(500, 350);
		tutorial.pack();
		tutorial.setVisible(true);
		
	
	    
		
		
		
	}

}
