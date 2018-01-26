package gameWindow.Entities.BadGuy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameWindow.GameWindow;
import gameWindow.Entities.Badguy;
import mech.Point;

public class Eye extends Badguy implements Cloneable{
	
	
	public static BufferedImage img1 = null;
	public static BufferedImage img2 = null;
	int angle = 0;
	int firing = 0;
	Point target;
	
	public void update() {
		this.xLocation += yLocation/30;
		this.yLocation += 0.1;
		
		if(firing <= 0) {
			target = this.getPoint(GameWindow.character);
		}
		if(System.currentTimeMillis() - this.lastFiring >= this.reloadTime) {
			firing++;
			TargetedBulletToPoint(GameWindow.character.toPoint(),-30, 8, 0.2, 0);
			
			if(firing >= 100) {
				this.lastFiring = System.currentTimeMillis();
				firing = 0;
			}
		}
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
	
	static {
		try {
			img1 = ImageIO.read(new File("../B2/img/enemy1a.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		try {
			img2 = ImageIO.read(new File("../B2/img/enemy1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Eye(double xLocation, double yLocation) {
		super(xLocation, yLocation, 10, 150);
		this.value = 100;
		this.entityType = eTYPE.HOSTILE;
		this.reloadTime = 2000;
		this.lastShot = System.currentTimeMillis();
		

		GameWindow.notBullets.add(this);
		this.lastFiring = System.currentTimeMillis();
		
		this.hitR = img1.getWidth()/2;
	}
	
	
	public void draw(Graphics g) {
		BufferedImage img = null;
		if(firing <= 0){
			img = img1;
		}
		else{
			img = img2;
		
		}
		g.drawImage(img, (int)(this.xLocation - (img.getWidth()/2)+1), (int)(this.yLocation - (img.getHeight()/2)+1), null);

		
	}
	

	@Override
	public boolean sudoku() {
		if(this.xLocation > GameWindow.Width||this.xLocation < 0||this.yLocation >GameWindow.Height||this.yLocation < 0) {
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
