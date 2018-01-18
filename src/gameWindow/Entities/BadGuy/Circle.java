package gameWindow.Entities.BadGuy;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.GameWindow;
import gameWindow.Entities.Badguy;
import gameWindow.Entities.Entity.eTYPE;

public class Circle extends Badguy{

	
	private double xV;
	private double yV;

	/**
	 * @param xLocation
	 * @param yLocation
	 * @param Health
	 * @param xVel
	 * @param yVel
	 * @param Size
	 */
	
	public Circle(double xLocation, double yLocation, int Health, double xVel, double yVel, int Size) {
		super(xLocation, yLocation, Health, 0);
		this.size = Size;
		this.xV = xVel;
		this.yV = yVel;
		this.hitR = size/2;
		
		
		this.value = 100;
		this.entityType = eTYPE.HOSTILE;
		this.reloadTime = 1000;
		this.lastShot = System.currentTimeMillis();
		this.hitR = 5;
		this.Health = Health;
		GameWindow.notBullets.add(this);
		this.lastFiring = System.currentTimeMillis();
	}

	public void update(){
		this.xLocation += xV;
		this.yLocation += yV;
		
		if(System.currentTimeMillis() - this.lastFiring >= this.reloadTime) {
			for(int i = 0; i < 3; i++) {
				this.angledBullet((this.getAngle(GameWindow.character) - 15) + (15*i), 4, 4, 1);
			}
			this.lastFiring = System.currentTimeMillis();
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval((int)xLocation - this.size/2, (int)yLocation - this.size/2, this.size, this.size);
	}
}
