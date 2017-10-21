package gameWindow.Entities;

import java.awt.Graphics;

import gameWindow.GameWindow;

public class Bullet extends Entity{

	public Bullet(double xLocation, double yLocation, double deltaX, double deltaY, double speed, int size) {
		super(xLocation, yLocation, 1, deltaX, deltaY);
		this.isControllable = false;
		this.xVelocity = 0.75 * deltaX;
		this.yVelocity = 0.75 * deltaY;
		this.acceleration = speed;
		this.size = size;
		GameWindow.objList.add(this);

	}
	
	public void draw(Graphics g) {
		g.fillOval((int)xLocation, (int)yLocation, this.size, this.size);
	}
	
	public void update() {
		this.xLocation += this.xVelocity;
		this.yLocation += this.yVelocity - this.acceleration;
		
		if(this.xLocation > 1280||this.xLocation < 0) {
			GameWindow.objList.remove(this);
		}if(this.yLocation > 720||this.yLocation < 0){
			GameWindow.objList.remove(this);
		}
	}

}
