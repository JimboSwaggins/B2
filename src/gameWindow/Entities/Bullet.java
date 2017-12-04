package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.GameWindow;

public class Bullet extends Entity{
private Color color;
	public Bullet(double xLocation, double yLocation, double deltaX, double deltaY, double speed, int size, boolean hostile, Color color) {
		super(xLocation, yLocation, 1, deltaX, deltaY, 5, 5, 5, 5);
		this.xVelocity =  deltaX;
		this.yVelocity =  deltaY;
		this.acceleration = speed;
	  
		this.color = color;
		this.hitR = (double)size/2;
		if(hostile) {
			this.entityType = eTYPE.HOSTILE;
		}else {
			this.entityType = eTYPE.HARMLESS;
		}
		GameWindow.objList.add(this);
			
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)xLocation, (int)yLocation, this.size, this.size);
	}
	
	public void update() {
		this.xLocation +=  .6 * this.xVelocity * render.VRR.time;
		this.yLocation +=  .6 * this.yVelocity * render.VRR.time - .5 * this.acceleration * render.VRR.time;
	}

}



class bouncingBullet extends targetedBullet{
	public bouncingBullet(double xLocation, double yLocation, double angle, double speed, int size, boolean hostile, Color color) {
		super(xLocation, yLocation, angle, speed, size, hostile, color);
	}
	
	public void update() {
		
		if(this.xLocation > 1280) {
			this.xLocation = 1280;
			this.xVelocity *=  -1;
		}
		if(this.yLocation > 720) {
			this.yLocation = 720;
			this.yVelocity *= -1;
		}
		if(this.xLocation < 0) {
			this.xLocation = 0;
			this.xVelocity *=  -1;
		}
		if(this.yLocation < 0) {
			this.yLocation = 0;
			this.yVelocity *= -1;
		}
	}
}