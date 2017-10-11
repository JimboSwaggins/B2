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
		image  = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
		Graphics g2  = image.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, 1280, 720);
		g2.setColor(Color.RED);
		g2.drawString("EHLS", 50, 400);
		g2.drawString(VRR.listOfTimes.toString(), 50, 50);
		
		g2 = drawBoard.getGraphics();
		g2.drawImage(image, 0, 0, null);

		//DRAW IMAGES OF STUFF HERE
		VRR.ping();
	}
	
	public static void draw(BufferedImage image) {
		Graphics g2  = drawBoard.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, 1280, 720);
		g2.setColor(Color.RED);
		g2.drawString("EHLS", 50, 400);
		g2.drawString(VRR.listOfTimes.toString(), 50, 50);
		drawBoard.paint(g2);
		
	}
}