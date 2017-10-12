package gameWindow;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import gameWindow.Entities.Player;
import mech.gameCalculate;
import render.gameRender;

public class GameWindow extends JFrame implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	public JFrame mainWindow;
	public static JPanel drawBoard;
	private Thread thread;
	boolean running; 
	public static BufferedImage image;
	public static Graphics2D g;
	public static Player character;
	
	public void createAndShowGUI() {
		mainWindow = new JFrame();
		mainWindow.setSize(1280, 720);
		mainWindow.setVisible(true);
		
		drawBoard = new JPanel();
		drawBoard.setSize(1280, 720);
		
		character = new Player();
		mainWindow.add(drawBoard);
		drawBoard.setVisible(true);
		
		mainWindow.addKeyListener(this);
		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainWindow.setFocusable(true);
		mainWindow.requestFocus();
		mainWindow.setVisible(true);
		

		
	}
	public void addNotify(){
		super.addNotify();
		if(thread == null){
			thread = new Thread(this);
			thread.start();
		}
		
		addKeyListener(this);
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
			character.update();
			gameRender.update();

	
		}
	}
	
	public GameWindow() {
		createAndShowGUI();
		this.run();
	}
	
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
