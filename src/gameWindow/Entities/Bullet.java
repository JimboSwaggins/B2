package gameWindow.Entities;

import java.awt.Graphics;

import gameWindow.GameWindow;

public class Bullet extends Entity{

	public Bullet(double xLocation, double yLocation, double yDelta, double xDelta, double speed, double angle, int size, boolean hostile) {
		super(xLocation, yLocation, 1, yDelta, xDelta);
		
		if(hostile) {
			this.entityType = eTYPE.HOSTILE;
		}else {
			this.entityType = eTYPE.HARMLESS;
		}
		
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
		
		sudoku();
	}

}
