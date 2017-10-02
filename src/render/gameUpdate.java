package render;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import gameWindow.GameWindow;

public class gameUpdate extends GameWindow{
<<<<<<< HEAD
	
	private static BufferedImage image;
	public static void update() {	
		image  = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
		
		g = (Graphics2D) image.getGraphics();
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 1280, 720);
		drawBoard.paint(g);
		
		
=======
	public void update() {
		drawBoard.setBackground(Color.BLACK);
		VRR.ping();
>>>>>>> origin/master
	}
}
