package render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import gameWindow.GameWindow;
import mech.gameCalculate;

public class gameRender extends GameWindow{
	private static Graphics2D g;	
	private static BufferedImage image;
	public static void update() {	
	

	
		//DRAW IMAGES OF STUFF HERE
		
	}
	
	public static void draw() {
		Graphics g2  = drawBoard.getGraphics();
		//g2 Draws the stuff in the game
		g2.drawImage(image, 0, 0, null);
		switch(gameCalculate.status) {
		case MENU:
			
			g2.setColor(Color.RED);
			g2.drawString("EHLS", 50, 650);
			VRR.ping();
			break;
		default:
		System.out.println("HA");
			break;
		}
		
	}
}

