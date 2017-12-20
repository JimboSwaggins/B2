package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameWindow.GameWindow;
import mech.Point;

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
		super(xLocation, yLocation, 3, Health, 60.0, 60.0, 5, 5);
		this.entityType = eTYPE.HOSTILE;
		this.reloadTime = 600;
		this.lastShot = System.currentTimeMillis();
		this.hitR = 5;
		this.Health = Health;
		GameWindow.notBullets.add(this);
		this.lastFiring = System.currentTimeMillis();
	}
	
	public void draw(Graphics g) {
		BufferedImage img = null;
		try {
				img = ImageIO.read(new File("../B2/img/enemy1.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, (int)(this.xLocation - (img.getWidth()/2)), (int)(this.yLocation - (img.getHeight()/2)), null);

		//TODO add a size constructor
	}
	int angle = 0;
	int firing = 0;
	Point target;
	public void update() {
		this.xLocation += 0.1;
		this.yLocation += 0.1;
		if(firing <= 0) {
			target = this.getPoint(GameWindow.character);
		}
		if(System.currentTimeMillis() - this.lastFiring >= this.reloadTime) {
			firing++;
			TargetedBulletToPoint(target, 10, 10);
			if(firing >= 10) {
				this.lastFiring = System.currentTimeMillis();
				firing = 0;
			}
		}
	
	}
	@Override
	public boolean isBullet() {
		// TODO Auto-generated method stub
		return false;
	}

}
