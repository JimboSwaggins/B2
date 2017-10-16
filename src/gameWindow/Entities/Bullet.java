package gameWindow.Entities;

import java.awt.Graphics;

import gameWindow.GameWindow;

public class Bullet extends Entity{

	public Bullet(int xLocation, int yLocation, int Health, double yDelta, double xDelta) {
		super(xLocation, yLocation, Health, yDelta, xDelta);
		GameWindow.objList.add(this);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		
	}

}
