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
	 * 
	 * HARMLESS indicates that it cannot hurt the player, but can hurt enemies.
	 * 
	 * HOSTILE indicates that it can hurt the player, and is hurt by HARMLESS entities.
	 * CTRL indicates that it is player controlled.
	 * 
	 *
	 */
	protected enum eTYPE{
		CRTL, HOSTILE, HARMLESS
	}
	
	public eTYPE geteTYPE() {
		return this.entityType;
	}
	protected eTYPE entityType;
	
	/**
	 * Determines whether or  not an entity is controlled by the player
	 * @return a boolean based off the entity type, true if controllable, false if anything else.
	 */
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
	
	/**
	 * Returns the radius of the callers hitbox.
	 * @return The hitbox radius as a double.
	 */
	public double getR() {
		return this.hitR;
	}
	
	
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
	protected int Score;
	
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
	
	/**
	 * Current yLocation in pixels of the entity
	 */
	protected double yLocation;
	
	/**
	 * Current velocity on the y-axis in pixels/second of the entity.
	 */

	public boolean sudoku() {
		if(this.xLocation > 1500||this.xLocation < -220||this.yLocation > 940||this.yLocation < -220) {
			return true;
		}return false;
	}
	
	
	/**
	 * Calculates the speed that an object is moving on the x-axis if it is moving at an angle
	 * 
	 * @param theta the angle that the object is moving
	 * @param acceleration the base acceleration
	 * @return the value that the object should be moving on the x-axis based on the angle it is moving.
	 */
	public double toXVelocity(double theta, double acceleration) {
		theta = Math.cos(theta);
		return(theta * acceleration);
	}
	
	/**
	 * Calculates the speed that an object is moving on the y-axis if it is moving at an angle
	 * 
	 * @param theta the angle that the object is moving
	 * @param acceleration the base acceleration
	 * @return the value that the object should be moving on the y-axis based on the angle it is moving.
	 */
	public double toYVelocity(double theta, double acceleration) {
		theta = Math.sin(theta);
		return(-1 * theta * acceleration);
	}
	
	/**
	 * moves an object based on an angle with left being 0 degrees. 
	 * @param angle The angle that the object should be moving.
	 * @param acceleration The instantaneous acceleration of the object
	 */
	public void updateOnAngle(double angle, double acceleration) {
		this.xLocation += this.toXVelocity(angle, acceleration);
		this.yLocation += this.toYVelocity(angle, acceleration);
	}
	
	/**
	 * Dampens the speed of the object if it's not moving.
	 * @param velocity The current velocity of the object
	 * @param factor The factor by which the object should be dampened
	 * @return The new speed of the object
	 */
	protected double slow(double velocity,double factor){
		if(velocity < .05 && velocity > -.05){
			return(0);
		}
		else{
			return(velocity * factor);
		}
	}
	
	/**
	 * The number of bombs that an entity has.
	 */
	private int bombs;
	
	/**
	 * Modifies the number of bombs that an entity has.
	 * @param deltaValue The amount by which bombs should be changed.
	 */
	public void bombsArithmetic(int deltaValue) {this.bombs += deltaValue;}
	
	/**
	 * 
	 * @return number of bombs in an entity's possession.
	 */
	public int getBombs() {return this.bombs;}
	
	/**
	 * Number of lives that an entity has.
	 */
	private int lives;
	
	/**
	 * Overwrites the number of lives that an entity has. 
	 * @param i new amount of lives that the entity has.
	 */
	public void setLives(int i) {this.lives = i;}
	
	/**
	 * Adds a number to an entity's number of lives. Use negative numbers to subtract lives from the entities lives. 
	 * @param deltaValue number to be added or subtracted.
	 */
	public void livesArithmetic(int deltaValue) {this.lives += deltaValue;}
	
	/**
	 * Returns the number of lives than entity has.
	 * @return number of lives an entity has.
	 */
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
	
	
	/**
	 * Whether or not the current entity is focused (Player only).
	 */
	protected boolean isFocus;
	public void setFocus(boolean input) {this.isFocus = input;}
	public boolean isFocused() {return this.isFocus;}
	
	/**
	 * 
	 * @param xLocation
	 * Sets the starting xLocation of the Entity
	 * 
	 * @param yLocation
	 * Sets the starting yLocation of the Entity
	 * 
	 * @param Health
	 * Sets the starting health of the Entity
	 * 
	 * @param yVelocity
	 * Sets the starting yVelocity of the Entity
	 * 
	 * @param xVelocity
	 * Sets the starting xVelocity of the Entity
	 * 
	 * @param Height
	 * Sets the starting height of the Entity
	 * 
	 * @param Width
	 * Sets the starting width of the Entity
	 * 
	 * @param size
	 * Sets the starting size of the Entity
	 * 
	 * @param hitR
	 * Sets the hitbox radius of the Entity
	 */
	public Entity(double xLocation, double yLocation, int Health, double Height, double Width,int size,
			int hitR) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.Health = Health;
		this.height = Height;
		this.width = Width;
		this.size = size;
		this.hitR = hitR;
	}
	
	
	
	/**
	 * Fires a bullet from the entity that calls the method. Calls the bullet constructor with default parameters. This method always fires friendly bullets.
	 * @param xVelocity The xVelocity of the fired bullet.
	 * @param yVelocity The yVelocity of the fired bullet.
	 * 
	 * 
	 */
	protected void Bullet() {
		new Bullet(this.xLocation, this.yLocation, 1, 5, false, Color.RED);
	}
	
	/**
	 * Fires a bullet from the entity that calls the method. Calls the bullet constructor with default parameters. Bullets can be friendly or hostile
	 * @param xVelocity The xVelocity of the fired bullet.
	 * @param yVelocity The yVelocity of the fired bullet.
	 * @param hostile If true, the bullet will be hostile to players. 
	 * 
	 * .
	 */
	protected void Bullet(boolean hostile) {
		new Bullet(this.xLocation, this.yLocation, 1, 5, hostile, Color.RED);
	}
	
	/**
	 * The target that the bullet will be aimed at.
	 * @param target
	 * 
	 * Fires a bullet targeted at another entity. All calculations are handled internally.
	 */
	public void TargetedBullet(Entity target, double speed, int size) {
				double tempX = this.xLocation - target.xLocation;
				double tempY = this.yLocation - target.yLocation;
			
				float angleTo = (float) Math.toDegrees(Math.atan2(tempY,tempX));
				new targetedBullet(this.xLocation, this.yLocation, angleTo, speed, size, false, Color.RED);
	}
	
	/**
	 * Updates the current entity. Completely abstract.
	 */
	public abstract void update();
	
	/**
	 * Draws the entity on the screen.
	 * @param g its a pre-initialized graphics thing
	 */
	public abstract void draw(Graphics g);


	/**
	 * Standard distance formula.
	 * @param e The target entity
	 * @return the distance between the entity that calls this method and the target (e) in pixels as a double.
 	 */
	public double getDistance(Entity e) {
		double xTest = Math.pow((this.xLocation - e.xLocation), 2);
		double yTest = Math.pow((this.yLocation - e.yLocation), 2);
		return Math.sqrt(xTest + yTest);
	}
	
	public abstract boolean isBullet();
}
