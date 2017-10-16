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
		
		g.fillOval(xLocation, yLocation, 4, 4);
	}
	
	public void update() {
		if(this.xLocation > 1280||this.xLocation < 0) {
			GameWindow.objList.remove(this);
			System.gc();
		}if(this.yLocation > 720||this.yLocation < 0){
			GameWindow.objList.remove(this);
			System.gc();
		}
	}

}
