package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.GameWindow;

public class Badguy extends Entity{

	private int rSpeed;
	private long lastShot;
	
	
	public double angleTarget() {
		double i = 0;
		return i;
		//get angle to player and stuff here.
		
	}
	
	public Badguy(double xLocation, double yLocation, int Health) {
		super(xLocation, yLocation, Health, 0, 0);
		this.entityType = eTYPE.HOSTILE;
		this.rSpeed = 300;
		this.lastShot = System.currentTimeMillis();
		
		GameWindow.objList.add(this);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval((int)this.xLocation, (int)this.yLocation, 30, 30);
	}
	
	public void update() {
		this.xLocation++;
		this.yLocation++;
		
		sudoku();
	}

}
