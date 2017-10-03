package gameWindow;

import java.awt.Canvas;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import mech.gameCalculate;
import render.gameRender;

public class GameWindow implements Runnable{
	public JFrame mainWindow;
	public static Canvas drawBoard;
	
	public void createAndShowGUI() {
		mainWindow = new JFrame();
		mainWindow.setSize(1280, 720);
		mainWindow.setVisible(true);
		
		drawBoard = new Canvas();
		drawBoard.setSize(1280, 720);
		
		
		mainWindow.add(drawBoard);
		
		mainWindow.pack();
		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
		
		
	}
	
	public void run() {
		boolean running = true;
		while(running) {
			gameCalculate.update();
			gameRender.update();
			gameRender.draw();
		}
	}
	
	public GameWindow() {
		createAndShowGUI();
		gameRender.update();
		this.run();
	}
}
