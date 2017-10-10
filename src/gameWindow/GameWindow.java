package gameWindow;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import gameWindow.Entities.Player;
import mech.gameCalculate;
import render.gameRender;

public class GameWindow implements Runnable, KeyListener{
	public JFrame mainWindow;
	public static Canvas drawBoard;
	
	boolean running; 
	public static BufferedImage image;
	public static Graphics2D g;
	public Player character;
	
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
		mainWindow.setIgnoreRepaint(true);
		character = new Player();

		
	}
	public void keyPressed(KeyEvent Key) {
		int keyCode = Key.getKeyCode();
			if(keyCode == KeyEvent.VK_LEFT){
				character.setLeft(true);
			}
			if(keyCode == KeyEvent.VK_RIGHT){
				character.setRight(true);
			}
			if(keyCode == KeyEvent.VK_UP){
				character.setUp(true);
			}
			if(keyCode == KeyEvent.VK_DOWN){
				character.setDown(true);
			}
			if(keyCode == KeyEvent.VK_SHIFT){
				character.setFocus(true);
			}
			if(keyCode == KeyEvent.VK_Z){
				character.setFiring(true);
			}
	}

	@Override
	public void keyReleased(KeyEvent Key) {
		int keyCode = Key.getKeyCode();
		if(keyCode == KeyEvent.VK_LEFT){
			character.setLeft(false);
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			character.setRight(false);
		}
		if(keyCode == KeyEvent.VK_UP){
			character.setUp(false);
		}
		if(keyCode == KeyEvent.VK_DOWN){
			character.setDown(false);
		}
		if(keyCode == KeyEvent.VK_SHIFT){
			character.setFocus(false);
		}
		if(keyCode == KeyEvent.VK_Z){
			character.setFiring(false);
		}
		
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
		this.run();
	}
	
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
