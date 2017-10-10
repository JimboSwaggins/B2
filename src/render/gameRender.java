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
		
		g = (Graphics2D) image.getGraphics();
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 1280, 720);
	
		

	
		drawBoard.paint(g);
		//DRAW IMAGES OF STUFF HERE

		draw();

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
	
	public static void draw() {

		
		image = new BufferedImage(1280, 900, BufferedImage.TYPE_INT_RGB);
		Graphics g2  = image.getGraphics();
		g2.drawImage(image, 0, 0, null);
		switch(gameCalculate.status) {
		case MENU:

			g2.setColor(Color.BLACK);
			g2.fillRect(0, 0, 1280, 900);
			
			g2.setColor(Color.GREEN);
			g2.drawString("Test text", 50, 50);
		
			break;
		default:
		System.out.println("HA");
			break;
		}
		
	}
}

