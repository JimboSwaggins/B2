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
		super(xLocation, yLocation, Health, 60.0, 60.0, 40, 40);
		this.entityType = eTYPE.HOSTILE;
		this.reloadTime = 1;
		this.lastShot = System.currentTimeMillis();
		this.hitR = 5;
		this.t = 0;
		GameWindow.objList.add(this);
		GameWindow.notBullets.add(this);
		this.lastFiring = System.currentTimeMillis();
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval((int)this.xLocation - 15, (int)this.yLocation -15, 30, 30);
		
		//TODO add a size constructor
	}
	
	private double t;
	
	public void update() {
		this.t++;
		this.xLocation += 2*(double)Math.cos(t * 0.02);
		this.yLocation += 2*(double)Math.sin(t * 0.02);
		if(System.currentTimeMillis() - this.lastFiring >= this.reloadTime) {
			for(int i = 0; i <= 360;i+= 5) {
				AngledBullet(i, 5, 4, 5);
			}
			this.lastFiring = System.currentTimeMillis();
		}
	
	}
	
	/**
	 * Always returns false because this entity is not a bullet.
	 */
	@Override
	public boolean isBullet() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
