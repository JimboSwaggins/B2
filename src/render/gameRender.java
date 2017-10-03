package render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import gameWindow.GameWindow;

public class gameRender extends GameWindow{

	public static void update(Graphics2D g1) {	
		g1.setColor(Color.BLACK);
		g1.fillRect(0, 0, 1280, 720);
		VRR.ping();

	}
	public static void gameDraw(){
		Graphics g2  = image.getGraphics();
		g2.drawImage(image, 0, 0, null);
	}
}
