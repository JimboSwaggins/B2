package gameWindow.Entities;

public abstract class Entity {

	protected int Health;
	public int getHealth() {return this.Health;}
	public void setHealth(int toChange) {this.Health = toChange;}
	
	protected int xLocation;
	public int getX() {return this.xLocation;}
	public void setX(int i) {this.xLocation = i;}
	
	protected double xDelta;
	public double getXD() {return this.xDelta;}
	public void setXD(double toChange) {this.xDelta = toChange;}
	
	protected int yLocation;
	public int getY() {return this.yLocation;}
	public void setY(int i) {this.yLocation = i;}
	
	protected double yDelta;
	public double getYD() {return this.yDelta;}
	public void setYD(double toChange) {this.yDelta = toChange;}
	
	
}
