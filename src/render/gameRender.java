package render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gameWindow.GameWindow;

@SuppressWarnings("serial")
public class gameRender extends GameWindow{
	private static BufferedImage image;
	
	private static String LifeNum;
	public static void setLifeNum(int i) {LifeNum = Integer.toString(i);}
	
	private static String Score;
	public static void setScore(int i) {Score = Integer.toString(i);}
	
	public static void update() {	
		image  = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
		Graphics g2  = image.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, 1280, 720);
<<<<<<< HEAD
		g2.setColor(Color.GREEN);
		g2.drawString("DEBUG STRING", 50, 400);
=======
		g2.setColor(Color.RED);
>>>>>>> 5ee6be09932da952da1227bbbe0dcc3bc3c61334
		g2.drawString(VRR.deltaX.toString(), 50, 50);
		g2.drawString("Lives :" + LifeNum, 60, 60);
		g2.drawString("Score : " + Score, 60, 70);

		for(int i = 0; i < objList.size(); i++) {
			objList.get(i).draw(g2);
		}
		
		
		g2 = drawBoard.getGraphics();
		g2.drawImage(image, 0, 0, null);
		//DRAW IMAGES OF STUFF HERE
		VRR.ping();
	}
}