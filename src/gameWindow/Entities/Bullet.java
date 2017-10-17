package gameWindow.Entities;

import java.awt.Graphics;

import gameWindow.GameWindow;

public class Bullet extends Entity{

	public Bullet(double xLocation, double yLocation, double yDelta, double xDelta, double speed, double angle, int size) {
		super(xLocation, yLocation, 1, yDelta, xDelta);
		this.isControllable = false;
		this.speed = speed;
		this.angle = angle;
		this.size = size;
		GameWindow.objList.add(this);

	}
	
	public void draw(Graphics g) {
		g.fillOval((int)xLocation, (int)yLocation, this.size, this.size);
	}
	
	public void update() {
		this.xLocation += toXVelocity(this.angle, this.speed);
		this.yLocation += toYVelocity(this.angle, this.speed);
		
		if(this.xLocation > 1280||this.xLocation < 0) {
			GameWindow.objList.remove(this);
		}if(this.yLocation > 720||this.yLocation < 0){
			GameWindow.objList.remove(this);
		}
	}

}
