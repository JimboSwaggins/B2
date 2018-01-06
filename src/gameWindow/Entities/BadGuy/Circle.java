package gameWindow.Entities.BadGuy;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.Entities.Badguy;

public class Circle extends Badguy{

	public double xVel;
	public double yVel;
	
	/**
	 * @param xLocation
	 * @param yLocation
	 * @param Health
	 * @param xVel
	 * @param yVel
	 * @param Size
	 */
	
	public Circle(double xLocation, double yLocation, int Health, int xVel, int yVel, int Size) {
		super(xLocation, yLocation, Health, 0);
		this.size = Size;
		this.xVel = xVel;
		this.yVel = yVel;
		this.hitR = size /2;
	}

	public void update(){
		this.xLocation += xVel;
		this.yLocation += yVel;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval((int)xLocation - this.size/2, (int)yLocation - this.size/2, this.size, this.size);
	}
}
