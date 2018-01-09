package gameWindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import gameWindow.Entities.Badguy;
import gameWindow.Entities.Entity;
import gameWindow.Entities.Player;
import gameWindow.Entities.BadGuy.Circle;
import gameWindow.Entities.BadGuy.Eye;
import gameWindow.Entities.BadGuy.Glitch;
import gameWindow.Entities.BadGuy.Orbit;
import render.VRR;

public class GameWindow extends Thread implements Runnable, KeyListener {

	public JFrame mainWindow;
	public static JPanel drawBoard;
	boolean running; 
	public static BufferedImage image;
	public static Graphics2D g;
	public static Player character;
	
	public static ArrayList<Entity> notBullets;
	public static ArrayList<Entity> bullets;
	
	/**
	 * Creates the main game window.
	 */
	private void createAndShowGUI() {
		mainWindow = new JFrame();
		mainWindow.setSize(1280, 720);
		mainWindow.setVisible(true);
		
		drawBoard = new JPanel();
		drawBoard.setSize(1280, 720);
		mainWindow.add(drawBoard);
		drawBoard.setVisible(true);
		
		mainWindow.addKeyListener(this);
		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainWindow.setFocusable(true);
		mainWindow.setResizable(false);
		mainWindow.requestFocus();
		mainWindow.setVisible(true);
	}
	
	/**
	 * Initiates the game array, which holds every entity in the game.
	 */
	private void ini_Systems() {
		executor = Executors.newCachedThreadPool();

		bullets = new ArrayList<Entity>();
		notBullets = new ArrayList<Entity>();
	}
	
	public void keyPressed(KeyEvent Key) {
		int keyCode = Key.getKeyCode();

		if(keyCode == KeyEvent.VK_LEFT){
			character.setLeft(true);
			
		}
		else if(keyCode == KeyEvent.VK_RIGHT) {
			character.setRight(true);
		}
		if(keyCode == KeyEvent.VK_UP){
			character.setUp(true);
		}
		else if(keyCode == KeyEvent.VK_DOWN){
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
			character.setDown(false);		}
		if(keyCode == KeyEvent.VK_SHIFT){
			character.setFocus(false);
		}
		if(keyCode == KeyEvent.VK_Z){
			character.setFiring(false);
		}
		
	}
	
	private ExecutorService executor;
	
	/**
	 * The main engine of the game
	 */
	public void run() {
		boolean running = true;
                                                                                                        
		ini_Systems();
		character = new Player(400, 400);
		
		for(int i = 0; i < 20; i ++) {
			//new Eye(Math.random() * 1280 , Math.random() * 720, 50, 8);
			//new Orbit(new Circle(Math.random() * 1280 , Math.random() * 720,10,0.0,1.0,30), 100, 30, Math.PI / 45, Math.random() * Math.PI * 2 , 10);
			new Glitch(Math.random() * 1280 , Math.random() * 720,10,0.0,0.0,20,5);
		}
	
		long nextFrame =  (System.nanoTime() + 16666667);	
		while(running) {
			
			
			while(System.nanoTime() <= nextFrame) {
					
			}
			calcUpdate();
			
			nextFrame += 16666667;


			for(Entity e: notBullets) {
				executor.execute(e);
			}

			renderUpdate();
			
		}
	}
	/**
	 * Initializes the game.
	 */
	public GameWindow() {
		createAndShowGUI();
		this.run();
	}
	
	public enum GAMESTATE{
		MENU,
	}
	
	public GAMESTATE status = GAMESTATE.MENU;
	
	/**
	 * Updates every entity in the game. First, it checks through the list and updates every entity.
	 * Then, it removes every entity that is outside the bounds of the game. 
	 */
	private void calcUpdate() {
		for(Entity e: bullets) {
			e.update();
		}
		for(Entity e: notBullets) {
			e.update();
		}
		Iterator<Entity> itr = notBullets.iterator();

		while (itr.hasNext()){
		    if(itr.next().sudoku()){
		    	itr.remove();
		    }
		}
		
		itr = bullets.iterator();
		while (itr.hasNext()){
		    if(itr.next().sudoku()){
		    	itr.remove();
		    }
		}
	}
	
	public static int lives;
	
	/**
	 * Overwrites the number of lives that the player has. 
	 * @param i new amount of lives that the player has.
	 */
	public void setLives(int i) {lives = i;}
	
	/**
	 * Adds a number to the player's number of lives. Use negative numbers to subtract lives from the player's lives. 
	 * @param deltaValue number to be added or subtracted.
	 */
	public void livesArithmetic(int deltaValue) {lives += deltaValue;}
	
	/**
	 * Returns the number of lives that the player has.
	 * @return number of lives the player has.
	 */
	public int getLives() {return lives;}
	
	/**
	 * Renders the entities in the game to the main JFrame.
	 */
	public static void renderUpdate() {	
		image  = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
		Graphics g2  = image.getGraphics();
		//g2.drawImage(image, 0, 0, null);
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, 1280, 720);


		g2.setColor(Color.RED);
		g2.drawString(VRR.deltaX.toString(), 50, 50);
		g2.drawString("Lives :" + lives, 60, 60);
		//g2.drawString("Score : " + score, 60, 70);

		
		for(Entity e:notBullets) {
			e.draw(g2);
		}
		for(Entity e:bullets) {
			e.draw(g2);
		}
		
		
		g2 = drawBoard.getGraphics();
		g2.drawImage(image, 0, 0, null);
		//DRAW IMAGES OF STUFF HERE
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
