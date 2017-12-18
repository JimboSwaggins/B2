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
import render.VRR;

public class GameWindow extends Thread implements Runnable, KeyListener {

	public JFrame mainWindow;
	public static JPanel drawBoard;
	boolean running; 
	public static BufferedImage image;
	public static Graphics2D g;
	public static Player character;
	public static ArrayList<Entity> objList;
	public static ArrayList<Entity> trash;
	
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
		objList = new ArrayList<Entity>();
		bullets = new ArrayList<Entity>();
		notBullets = new ArrayList<Entity>();
	}
	
	public void keyPressed(KeyEvent Key) {
		int keyCode = Key.getKeyCode();
			if(keyCode == KeyEvent.VK_LEFT){
				for(int i = 0; i < objList.size(); i++) {
					if(objList.get(i).CtrlCheck()) {
						objList.get(i).setLeft(true);
						objList.get(i).setDirection(4);
					}
				}
			}
			else if(keyCode == KeyEvent.VK_RIGHT) {
				for(int i = 0; i < objList.size(); i++) {
					if(objList.get(i).CtrlCheck()) {
						objList.get(i).setRight(true);
						objList.get(i).setDirection(2);
					}
				}
			}
			if(keyCode == KeyEvent.VK_UP){
				for(int i = 0; i < objList.size(); i++) {
					if(objList.get(i).CtrlCheck()) {
						objList.get(i).setUp(true);
						objList.get(i).setDirection(1);
					}
				}
			}
			else if(keyCode == KeyEvent.VK_DOWN){
				for(int i = 0; i < objList.size(); i++) {
					if(objList.get(i).CtrlCheck()) {
						objList.get(i).setDown(true);
						objList.get(i).setDirection(3);
					}
				}
			}
			if(keyCode == KeyEvent.VK_SHIFT){
				for(int i = 0; i < objList.size(); i++) {
					if(objList.get(i).CtrlCheck()) {
						objList.get(i).setFocus(true);
					}
				}
			}
			if(keyCode == KeyEvent.VK_Z){
				for(int i = 0; i < objList.size(); i++) {
					if(objList.get(i).CtrlCheck()) {
						objList.get(i).setFiring(true);
					}
				}
			}
	}

	@Override
	public void keyReleased(KeyEvent Key) {
		int keyCode = Key.getKeyCode();
		if(keyCode == KeyEvent.VK_LEFT){
			for(Entity e: objList) {
				if(e.CtrlCheck()) {
					e.setLeft(false);
				}
			}
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			for(Entity e: objList) {
				if(e.CtrlCheck()) {
					e.setRight(false);
				}
			}
		}
		if(keyCode == KeyEvent.VK_UP){
			for(int i = 0; i < objList.size(); i++) {
				if(objList.get(i).CtrlCheck()) {
					objList.get(i).setUp(false);
				}
			}
		}
		if(keyCode == KeyEvent.VK_DOWN){
			for(int i = 0; i < objList.size(); i++) {
				if(objList.get(i).CtrlCheck()) {
					objList.get(i).setDown(false);
				}
			}
		}
		if(keyCode == KeyEvent.VK_SHIFT){
			for(int i = 0; i < objList.size(); i++) {
				if(objList.get(i).CtrlCheck()) {
					objList.get(i).setFocus(false);
				}
			}
		}
		if(keyCode == KeyEvent.VK_Z){
			for(int i = 0; i < objList.size(); i++) {
				if(objList.get(i).CtrlCheck()) {
					objList.get(i).setFiring(false);
				}
			}
		}
		
	}
	public Badguy memer;
	
	private ExecutorService executor;
	
	/**
	 * The main engine of the game
	 */
	public void run() {
		boolean running = true;

		                                                                                                            
		ini_Systems();
		character = new Player(400, 400);
		memer = new Badguy(93, 39, 1);
		
		for(int i = 0; i < 5000; i ++) {
			new Badguy(Math.random() * 1280 , Math.random() * 720, 1);
		}
	
		long nextFrame =  (System.nanoTime() + 16666667);	
		while(running) {
			
			
			while(System.nanoTime() <= nextFrame) {
					
			}
			calcUpdate();
			
			nextFrame += 16666667;
			
			
			
				executor.execute(new Collision());
			
			
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
		for(int i = 0; i < objList.size();i++) {
			objList.get(i).update();
		}
		Iterator<Entity> itr = objList.iterator();

		while (itr.hasNext()){
		    if(itr.next().sudoku()){
		    	itr.remove();
		    }
		}
	}
	
	private static String LifeNum;
	public static void setLifeNum(int i) {LifeNum = Integer.toString(i);}
	
	private static String Score;
	public static void setScore(int i) {Score = Integer.toString(i);}
	
	
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
		g2.drawString("Lives :" + LifeNum, 60, 60);
		g2.drawString("Score : " + Score, 60, 70);

		g2.drawString(String.valueOf(GameWindow.objList.size()), 70, 80);
		for(int i = 0; i < objList.size(); i++) {
			objList.get(i).draw(g2);
		}
		
		
		g2 = drawBoard.getGraphics();
		g2.drawImage(image, 0, 0, null);
		//DRAW IMAGES OF STUFF HERE
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
