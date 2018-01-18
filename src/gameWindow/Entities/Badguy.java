package gameWindow.Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameWindow.GameWindow;
import mech.Point;

public class Badguy extends Entity{

	
	protected int value;
	/**
	 * 
	 * @param xLocation
	 * The Current X Location of the badGuy
	 * @param yLocation
	 * The Current YLocation of the badGuy
	 * @param Health
	 * The Current Health of the badGuy
	 */
	public Badguy(double xLocation, double yLocation, int Health, int speed) {
		super(xLocation, yLocation, Health, speed, 60.0, 60.0, 5, 5);
		this.entityType = eTYPE.HOSTILE;
		this.reloadTime = 2000;
		this.lastShot = System.currentTimeMillis();
		this.hitR = 5;
		this.Health = Health;
		GameWindow.notBullets.add(this);
		this.lastFiring = System.currentTimeMillis();
	}
	
	public void draw(Graphics g) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("../B2/img/p_down.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, (int)(this.xLocation - (img.getWidth()/2)+1), (int)(this.yLocation - (img.getHeight()/2)+1), null);
	}
	int angle = 0;
	protected int firing = 0;
	protected Point target;
	public void update() {}
	
	@Override
	public boolean sudoku() {
		if(this.xLocation > GameWindow.Height||this.xLocation < -10||this.yLocation >720||this.yLocation < -10) {
			return true;
		}if(this.Health <= 0) {
			GameWindow.score += this.value;
			this.value = 0;
			return true;
		}
		return false;
	}
	@Override
	public boolean isBullet() {
		// TODO Auto-generated method stub
		return false;
	}

}
