package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameWindow.GameWindow;

public class Bullet extends Entity{


/**
 * Creates a new bullet entity
 * @param xLocation The bullet's starting xLocation
 * @param yLocation The bullet's starting yLocation
 * @param deltaX The bullet's velocity on the xAxis
 * @param deltaY The bullet's velocity on the yAxis
 * @param speed The speed at which the bullet travels
 * @param size The size of the bullet
 * @param hostile Whether or not the bullet will hurt the player
 * @param color The Color of the bullet
 */
	
	private static BufferedImage[] bSprite = null;
	static {
		try {
			 bSprite = new BufferedImage[] {ImageIO.read(new File("../B2/img/bullet1.png")), ImageIO.read(new File("../B2/img/bullet2.png"))};
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage img;
	public Bullet(double xLocation, double yLocation, double speed, int size, boolean hostile, Color color, int damage, int bNum) {
		super(xLocation, yLocation, 1, 3, 5, 5, size, 5);
		this.size = size;
		this.color = color;
		this.hitR = size / 2;
		this.damage = damage;
		this.speed = speed;
		this.img = bSprite[bNum];
		if(hostile) {
			this.entityType = eTYPE.HOSTILE;
		}else {
			this.entityType = eTYPE.HARMLESS;
		}
		
		GameWindow.bullets.add(this);
		this.run();
	}
	
	/**
	 * Draws the bullet at the nearest integer coordinates (rounded up)
	 */
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawImage(img, (int)(this.xLocation - (img.getWidth()/2)+1), (int)(this.yLocation - (img.getHeight()/2)+1), null);
	}
	
	
	/**
	 * Updates the position of the bullet based on its speed.
	 */
	public void update() {
		this.xLocation += 0;
		this.yLocation -= speed;
		this.speed += .333;
	}
	
	/**
	 * Returns true, because this is a bullet.
	 */
	public boolean isBullet() {
		return true;
	}
	
	
	@Override
	public void run() {
	}


}
