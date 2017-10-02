package gameWindow;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Window {
	JFrame mainWindow;
	Canvas drawBoard;
	public void createAndShowGUI() {
		mainWindow = new JFrame();
		mainWindow.setSize(1280, 720);
		mainWindow.setVisible(true);
		
		drawBoard = new Canvas();
		
		mainWindow.add(drawBoard);
		
		
	}
	
	public Window() {
		createAndShowGUI();
	}
}
