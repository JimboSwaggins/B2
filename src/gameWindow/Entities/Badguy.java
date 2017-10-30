package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.GameWindow;

public class Badguy extends Entity{

	

	@SuppressWarnings("unused")
	private int rSpeed;
	@SuppressWarnings("unused")
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
		this.hitR = 5;
		GameWindow.objList.add(this);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval((int)this.xLocation - 15, (int)this.yLocation -15, 30, 30);
		
		//TODO add a size constructor
	}
	
	public void update() {
		this.xLocation += 0.1;
		this.yLocation += 0.1;
		
		TargetedBullet(GameWindow.character);
		
	
		sudoku();
	}

}
