package gameWindow.Entities;

import java.awt.Graphics;

public abstract class Entity {
	
	protected boolean isControllable;
	public boolean CtrlCheck(){
		if(this.isControllable) {
			return true;
		}return false;	
	}
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
	

	public double toXVelocity(double theta, double vi) {
		theta = (double) theta % (2.0 * Math.PI);
		theta = Math.cos(theta);
		return(theta * vi);
	}
	
	public double toYVelocity(double theta, double vi) {
		theta = (double) theta % (2.0 * Math.PI);
		theta = Math.sin(theta);
		return(theta * vi);
	}
	
	private int bombs;
	public void bombsArithmetic(int deltaValue) {this.bombs += deltaValue;}
	public int getBombs() {return this.bombs;}
	
	private int lives;
	public void setLives(int i) {this.lives = i;}
	public void livesArithmetic(int deltaValue) {this.lives += deltaValue;}
	public int getLives() {return this.lives;}
	
	private boolean isRight;
	public void setRight(boolean input) {this.isRight = input;}
	
	private boolean isLeft;
	public void setLeft(boolean input) {this.isLeft = input;}
	
	private boolean isUp;
	public void setUp(boolean input) {this.isUp = input;}
	
	private boolean isDown;
	public void setDown(boolean input) {this.isDown = input;}
	
	@SuppressWarnings("unused")
	private boolean isFiring;
	public void setFiring(boolean input) {this.isFiring = input;}
	
	@SuppressWarnings("unused")
	private boolean isFocus;
	public void setFocus(boolean input) {this.isFocus = input;}

	
	
	public Entity(int xLocation, int yLocation, int Health, double yDelta, double xDelta) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.Health = Health;
		this.xDelta = xDelta;
		this.yDelta = yDelta;
	}
	
	public void update() {
		if(isControllable) {
			if(isUp) {this.yLocation--;}
			if(isDown) {this.yLocation++;}
			if(isRight) {this.xLocation++;}
			if(isLeft) {this.xLocation--;}
		}
	}
	
	public void draw(Graphics g) {
		//This shouldn't do anything, it's just to make this accessible by subclasses.
	
	
	}

	
	
}
