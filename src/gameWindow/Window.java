package gameWindow;

import javax.swing.JFrame;

public class Window {
	JFrame mainWindow;
	
	public void createAndShowGUI() {
		mainWindow = new JFrame();
		mainWindow.setSize(1280, 720);
		mainWindow.setVisible(true);
	}
	
	public Window() {
		createAndShowGUI();
	}
}
