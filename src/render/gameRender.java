package render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import gameWindow.GameWindow;

public class gameRender extends GameWindow{
	private static Graphics2D g;	
	private static BufferedImage image;
	public static void update() {	
		image  = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
		
		g = (Graphics2D) image.getGraphics();
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 1280, 720);
		g.setColor(Color.GREEN);
		g.drawString(VRR.listOfTimes.toString(), 50, 50);
		drawBoard.paint(g);
		//DRAW IMAGES OF STUFF HERE
		VRR.ping();
	}
	
	public static void draw() {
		Graphics g2  = drawBoard.getGraphics();
		g2.drawImage(image, 0, 0, null);
	}
}

