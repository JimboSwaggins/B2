package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.GameWindow;

public class Bullet extends Entity{

	
	private Color color;
	public Bullet(double xLocation, double yLocation, double yDelta, double xDelta, double speed, double angle, int size, boolean hostile, Color color) {
		super(xLocation, yLocation, 1, yDelta, xDelta);

		this.acceleration = speed;
		this.color = color;
		
		if(hostile) {
			this.entityType = eTYPE.HOSTILE;
		}else {
			this.entityType = eTYPE.HARMLESS;
		}
	
		this.angle = angle;
		this.size = size;
		GameWindow.objList.add(this);
			
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)xLocation, (int)yLocation, this.size, this.size);
	}
	
	public void update() {
		this.xLocation += toXVelocity(this.angle, this.acceleration);
		this.yLocation += toYVelocity(this.angle, this.acceleration);
		
		this.xLocation += this.xVelocity;
		this.yLocation += this.yVelocity;
		sudoku();
	}

}
