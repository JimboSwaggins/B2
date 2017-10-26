package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.GameWindow;

public class Bullet extends Entity{
	private Color color;
	public Bullet(double xLocation, double yLocation, double deltaX, double deltaY, double speed, int size, boolean hostile, Color color) {
		super(xLocation, yLocation, 1, deltaX, deltaY);
		this.xVelocity = .7 * deltaX;
		this.yVelocity = .7 * deltaY;
		this.acceleration = speed;

		this.color = color;

		if(hostile) {
			this.entityType = eTYPE.HOSTILE;
		}else {
			this.entityType = eTYPE.HARMLESS;
		}

		this.size = size;
		GameWindow.objList.add(this);

	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)xLocation, (int)yLocation, this.size, this.size);
	}

	public void update() {
		this.xLocation += this.xVelocity;

		this.yLocation += this.yVelocity - this.acceleration;

		sudoku();
	}

}

class targetedBullet extends Bullet{
	public targetedBullet(double xLocation, double yLocation, double speed, int size, boolean hostile, Color color, Entity target) {
		super(xLocation, yLocation, 0, 0, speed, size, hostile, color);
		double xDif = this.xLocation - target.xLocation;
		double yDif = this.yLocation - target.yLocation;
		
		if(yDif > xDif) {
			xDif = (Math.abs(xDif)/yDif);
			yDif = (yDif/yDif);
		}else {
			yDif = (Math.abs(yDif)/xDif);
			xDif = (xDif/xDif);
		}
		
		this.xVelocity = xDif * speed;
		this.yVelocity = yDif * speed;


	}
	@Override 
	public void update() {
		this.xLocation -= this.xVelocity;
		this.yLocation -= this.yVelocity;

		sudoku();
	}
}

/*class bouncingBullet extends targetedBullet{
	public bouncingBullet(double xLocation, double yLocation, double angle, double speed, int size, boolean hostile, Color color) {
		super(xLocation, yLocation, angle, speed, size, hostile, color);
	}

	public void update() {
		double rad = Math.toRadians(90);
		this.xLocation += this.xVelocity;
		this.yLocation -= this.yVelocity;

		if(this.xLocation > 1280) {
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
			this.yVelocity *= -1;
		}
	}
}*/