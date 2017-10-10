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

		//g2 Draws the stuff in the game
		
		image = new BufferedImage(1280, 900, BufferedImage.TYPE_INT_RGB);
		Graphics g2  = image.getGraphics();
		g2.drawImage(image, 0, 0, null);
		switch(gameCalculate.status) {
		case MENU:
			g2.setColor(Color.BLACK);
			g2.fillRect(0, 0, 1280, 900);
			g2.setColor(Color.RED);
			g2.drawString("EHLS", 50, 400);
			VRR.ping();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
		System.out.println("HA");
			break;
		}
		
	}
}

