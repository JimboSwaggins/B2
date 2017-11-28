package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.GameWindow;
import mech.Point;

public abstract class Entity {
	
	/**
	 * Amount of time in milliseconds between shots fired by this entity
	 */
	protected int reloadTime;
	@SuppressWarnings("unused")
	protected long lastShot;
	
	/**
	 * The last time that the entity fired
	 */
	protected long lastFiring;
	
	/**
	 * 
	 * The classification of the entity in relation to the player:
	 * HARMLESS indicates that it cannot hurt the player, but can hurt enemies.
	 * HOSTILE indicates that it can hurt the player, and is hurt by HARMLESS entities.
	 * CTRL indicates that it is player controlled.
	 * @author nahte
	 *
	 */
	protected enum eTYPE{
		CRTL, HOSTILE, HARMLESS
	}
	
	protected eTYPE entityType;
	public boolean CtrlCheck(){
		if(this.entityType.equals(eTYPE.CRTL)) {
			return true;
			}return false;	
	}
	
	/**
	 * The height of the entity.
	 */
	protected final double height;
	
	/**
	 * The width of the entity
	 */
	protected final double width;
	
	/**
	 * The xLocation of the center of the entity's hitbox
	 */
	protected double hitX;
	
	/**
	 * The yLocation of the center of the entity's hitbox
	 */
	protected double hitY;
	
	/**
	 * The radius of the entity's hitbox, which extends from the point (hitX, hitY)
	 */
	protected double hitR;
	
	protected final int size;
	
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
	
	/**
	 * The score of the player.
	 */
	protected static int Score;
	
	/**
	 * The health of the entity.
	 */
	protected int Health;
	
	/**
	 * The current xLocation of the entity.
	 */
	protected double xLocation;

	/**
	 * returns the xLocation of the entity that it is called on.
	 * @return xLocation
	 */
	public double getX() {return this.xLocation;}
	
	/**
	 *Sets the xLocation of the entity that it is called on.
	 * @param i new xLocation
	 * 
	 */
	public void setX(int i) {this.xLocation = i;}
	
	public double xVelocity;
	public double getXV() { return (this.xVelocity);}
	public void setXV(int i) {this.xVelocity = i;}
	

	protected double yLocation;
	protected double yVelocity;
  
	
	/**
	 * Removes the entity from the update list if it is far enough beyond the screen
	 */
	public void sudoku() {
		if(this.xLocation > 1500||this.xLocation < -220||this.yLocation > 940||this.yLocation < -220) {
			GameWindow.objList.remove(this);
		}
	}
	
	
	public double toXVelocity(double theta, double acceleration) {
		theta = Math.cos(theta);
		return(theta * acceleration);
	}
	
	public double toYVelocity(double theta, double acceleration) {
		theta = Math.sin(theta);
		return(-1 * theta * acceleration);
	}
	
	public void updateOnAngle(double angle, double acceleration) {
		this.xLocation += this.toXVelocity(angle, acceleration);
		this.yLocation += this.toYVelocity(angle, acceleration);
	}
	
	/**
	 * 
	 * @param velocity
	 * @param factor
	 * @return
	 */
	
	protected double slow(double velocity,double factor){
		if(velocity < .05 && velocity > -.05){
			return(0);
		}
		else{
			return(velocity * factor);
		}
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
	
	protected boolean isFocus;
	public void setFocus(boolean input) {this.isFocus = input;}
	public boolean isFocused() {return this.isFocus;}
	
	/**
	 * Sets the starting xLocation of the Entity
	 * @param xLocation
	 * Sets the starting yLocation of the Entity
	 * @param yLocation
	 * Sets the starting health of the Entity
	 * @param Health
	 * Sets the starting yVelocity of the Entity
	 * @param yVelocity
	 * Sets the starting xVelocity of the Entity
	 * @param xVelocity
	 * Sets the starting height of the Entity
	 * @param Height
	 * Sets the starting width of the Entity
	 * @param Width
	 * Sets the starting size of the Entity
	 * @param size
	 * Sets the hitbox radius of the entity
	 * @param hitR
	 */
	public Entity(double xLocation, double yLocation, int Health, double yVelocity, double xVelocity, double Height, double Width,int size,
			int hitR) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.Health = Health;
		this.yVelocity = yVelocity;
		this.xVelocity = xVelocity;
		this.height = Height;
		this.width = Width;
		this.size = size;
		this.hitR = hitR;
	}
	
	/**
	 * The target that the bullet will be aimed at.
	 * @param target
	 * 
	 * Fires a bullet targeted at another entity. All calculations are handled internally.
	 */
	public void TargetedBullet(Entity target) {
				double tempX = this.xLocation - target.xLocation;
				double tempY = this.yLocation - target.yLocation;
			
				float angleTo = (float) Math.toDegrees(Math.atan2(tempY,tempX));
				new Bullet(this.xLocation, this.yLocation, 1,  0, 1, 5, false, Color.RED);
	}
	
	protected void Bullet(double xVelocity, double yVelocity) {
		new Bullet(this.xLocation, this.yLocation, xVelocity, yVelocity, 1, 5, false, Color.RED);
	}
	public abstract void update();
	
	public abstract void draw(Graphics g);

	public double getDistance(Entity e) {
		double xTest = Math.pow((this.xLocation - e.xLocation), 2);
		double yTest = Math.pow((this.yLocation - e.yLocation), 2);
		return Math.sqrt(xTest + yTest);
	}
	
	
	
}
