package gameWindow.Entities.BadGuy;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.GameWindow;
import gameWindow.Entities.Badguy;
import gameWindow.Entities.Entity;

public class Orbit extends Badguy{

	public Entity parent;
	public int radius;
	public double radPerSecond;
	public double sRad;
	public double cRad;
	
	
	/**
	 * @param Parent Entity to orbit
	 * @param Health hit points 
	 * @param Radius int for distance away from entity
	 * @param RPS (double in rads) How much to rotate every tick (60Hz)
	 * @param SRad (double in rads) Starring rotation
	 * @param size diameter of object
	 */
	public Orbit(Circle Parent, int Health, int Radius, double RPS, double SRad, int size) {
		super(Parent.getX(), Parent.getY(), Health, 0);
		this.parent = Parent;
		this.Health = Health;
		this.size = size;
		this.hitR = size / 2;
		this.radius = Radius;
		this.radPerSecond = RPS;
		this.sRad = SRad;
		this.cRad = SRad;
		
		
		this.value = 100;
		this.entityType = eTYPE.HOSTILE;
		this.reloadTime = 5000;
		this.lastShot = System.currentTimeMillis();
		this.lastShot = System.currentTimeMillis();
		this.hitR = 5;
		this.Health = Health;
		GameWindow.notBullets.add(this);
		this.lastFiring = System.currentTimeMillis();
	}

	public void update(){
		
		if(this.parent.getHealth() > 0) {
			this.xLocation = parent.getX() + this.radius * Math.cos(cRad);
			this.yLocation = parent.getY() + this.radius * Math.sin(cRad);
			this.cRad += this.radPerSecond;
		}else {
			this.xLocation += 1;
			this.yLocation += 1;
		}
		
		if(System.currentTimeMillis() - this.lastFiring >= this.reloadTime) {
			for(int i = 0; i < 24; i++) {
				this.angledBullet(0+(15*i), 4, 4, 0);
			}
			this.lastFiring = System.currentTimeMillis();
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillOval((int)xLocation - this.size/2, (int)yLocation - this.size/2, this.size, this.size);
	}
	
	public boolean isBullet() {
		return false;
	}
	
}
