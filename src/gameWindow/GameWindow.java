package gameWindow;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import mech.gameCalculate;
import render.gameRender;

public class GameWindow implements Runnable{
	public JFrame mainWindow;
	public static Canvas drawBoard;
	
	boolean running; 
	public static BufferedImage image;
	public static Graphics2D g;
	
	public void createAndShowGUI() {
		mainWindow = new JFrame();
		mainWindow.setSize(1280, 720);
		mainWindow.setVisible(true);
		
		drawBoard = new Canvas();
		drawBoard.setSize(1280, 720);
		
		
		mainWindow.add(drawBoard);
		drawBoard.setVisible(true);
		
		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
		
		
	}
	
	public void run() {
		running = true;
		image  = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		while(running) {
			gameRender.update(g);
			gameRender.gameDraw();
			gameCalculate.update();
		}
	}
	
	public GameWindow() {
		createAndShowGUI();
		this.run();
	}
}
