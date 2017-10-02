package gameWindow;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import render.gameUpdate;

public class GameWindow {
	public JFrame mainWindow;
	public static Canvas drawBoard;
	
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
	}
	
	public GameWindow() {
		createAndShowGUI();
		gameUpdate.update();
	}
}
