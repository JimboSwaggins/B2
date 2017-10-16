package gameWindow.Entities;

import java.awt.Graphics;

import gameWindow.GameWindow;

public class Bullet extends Entity{

	public Bullet(int xLocation, int yLocation, int Health, double yDelta, double xDelta, double speed, double angle) {
		super(xLocation, yLocation, Health, yDelta, xDelta);
		this.isControllable = false;
		this.speed = speed;
		this.angle = angle;
		GameWindow.objList.add(this);

	}
	
	public void draw(Graphics g) {
		g.fillOval(xLocation, yLocation, 4, 4);
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
