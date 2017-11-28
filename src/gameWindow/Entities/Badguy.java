package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.GameWindow;

public class Badguy extends Entity{

	
	
	public double angleTarget() {
		double i = 0;
		return i;
		//get angle to player and stuff here.
		
	}
	/**
	 * 
	 * @param xLocation
	 * The Current X Location of the badGuy
	 * @param yLocation
	 * The Current YLocation of the badGuy
	 * @param Health
	 * The Current Health of the badGuy
	 */
	public Badguy(double xLocation, double yLocation, int Health) {
		super(xLocation, yLocation, Health, 0, 0, 60.0, 60.0, 5, 5);
		this.entityType = eTYPE.HOSTILE;
		this.reloadTime = 300;
		this.lastShot = System.currentTimeMillis();
		this.hitR = 5;
		GameWindow.objList.add(this);
		this.lastFiring = System.currentTimeMillis();
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval((int)this.xLocation - 15, (int)this.yLocation -15, 30, 30);
		
		//TODO add a size constructor
	}
	
	public void update() {
		this.xLocation += 0.1;
		this.yLocation += 0.1;
		if(System.currentTimeMillis() - this.lastFiring >= this.reloadTime) {
			TargetedBullet(GameWindow.character);
			this.lastFiring = System.currentTimeMillis();
		}
	
	}

}
