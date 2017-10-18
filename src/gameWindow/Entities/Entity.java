package gameWindow.Entities;

import java.awt.Graphics;

public abstract class Entity {
	
	protected boolean isControllable;
	public boolean CtrlCheck(){
		if(this.isControllable) {
			return true;
		}return false;	
	}
	
	protected double height;
	
	protected double width;
	
	protected double hitX;
	protected double hitY;
	protected double hitR;
	
	protected int size;
	
	protected double angle;
	public double getAngle() {return this.angle;}
	
	protected double acceleration;
	public void setSpeed(double newSpeed) {this.acceleration = newSpeed;}
	public double getSpeed() {return this.acceleration;}
	
	
	protected int direction;
	public void setDirection(int i) {
		if(i <= 4&&i >= 0) {
			this.direction = i;
		}
		else {
			this.direction = 1;
		}
	}
	
	protected int Score;
	public int getScore() {return this.Score;}
	public void setScore(int i) { this.Score += i;}
	
	protected int Health;
	public int getHealth() {return this.Health;}
	public void setHealth(int toChange) {this.Health = toChange;}
	
	protected double xLocation;
	public double getX() {return this.xLocation;}
	public void setX(int i) {this.xLocation = i;}
	
	protected double xVelocity;
	public double getXV() { return (this.xVelocity);}
	public void setXV(int i) {this.xVelocity = i;}
	
	protected double yLocation;
	public double getY() {return this.yLocation;}
	public void setY(int i) {this.yLocation = i;}
	
	protected double yVelocity;
	public double getYV() { return (this.yVelocity);}
	public void setYV(int i) {this.yVelocity = i;}

	public double toXVelocity(double theta, double vi) {
		theta = Math.cos(theta);
		return(theta * vi);
	}
	
	public double toYVelocity(double theta, double vi) {
		theta = Math.sin(theta);
		return(-1 * theta * vi);
	}
	
	private int bombs;
	public void bombsArithmetic(int deltaValue) {this.bombs += deltaValue;}
	public int getBombs() {return this.bombs;}
	
	private int lives;
	public void setLives(int i) {this.lives = i;}
	public void livesArithmetic(int deltaValue) {this.lives += deltaValue;}
	public int getLives() {return this.lives;}
	
	protected boolean isRight;
	public void setRight(boolean input) {this.isRight = input;}
	
	protected boolean isLeft;
	public void setLeft(boolean input) {this.isLeft = input;}
	
	protected boolean isUp;
	public void setUp(boolean input) {this.isUp = input;}
	
	protected boolean isDown;
	public void setDown(boolean input) {this.isDown = input;}
	
	private boolean isFiring;
	public void setFiring(boolean input) {this.isFiring = input;}
	public boolean isFiring() {return this.isFiring;}
	
	private boolean isFocus;
	public void setFocus(boolean input) {this.isFocus = input;}
	public boolean isFocused() {return this.isFocus;}
	
	
	public Entity(double xLocation, double yLocation, int Health, double yVelocity, double xVelocity) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.Health = Health;

	}
	
	
	public void update() {
	}
	
	public void draw(Graphics g) {
		//This shouldn't do anything, it's just to make this accessible by subclasses.
	}
}
