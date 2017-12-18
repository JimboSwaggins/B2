package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;

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
	
	public Bullet(double xLocation, double yLocation, double speed, int size, boolean hostile, Color color) {
		super(xLocation, yLocation, 1, 5, 5, 5, 5);
	  
		this.color = color;
		this.hitR = 4;
		if(hostile) {
			this.entityType = eTYPE.HOSTILE;
		}else {
			this.entityType = eTYPE.HARMLESS;
		}
		GameWindow.objList.add(this);
		GameWindow.bullets.add(this);
			
	}
	
	/**
	 * Draws the bullet at the nearest integer coordinates (rounded up)
	 */
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)xLocation, (int)yLocation, this.size, this.size);
	}
	
	
	/**
	 * Updates the position of the bullet based on its speed.
	 */
	public void update() {
		this.xLocation += 0;
		this.yLocation -= speed;
	}

	public boolean isBullet() {
		return true;
	}



}
