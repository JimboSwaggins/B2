package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.GameWindow;
import mech.Point;

public abstract class Entity implements Runnable{

	//Classification values
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
	public enum eTYPE{
		CRTL, HOSTILE, HARMLESS
	}

	/**
	 * Gives the eTYPE of the entity that calls the function
	 * @return The eTYPE of the entity that calls the function
	 */
	public eTYPE geteTYPE() {
		return this.entityType;
	}
	
	/**
	 * The eTYPE of the entity
	 */
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
	 * Boolean based on whether or not caller is a bullet
	 * @return true if entity is bullet, otherwise returns false
	 */
	public abstract boolean isBullet();

	//Metadata on Entities

	/**
	 * The height of the entity.
	 */
	protected final double height;

	/**
	 * The width of the entity
	 */
	protected final double width;

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
	/**
	 * The size of the entity.
	 */
	protected int size;
	/**
	 * The angle at which an entity is going to move. Only relevant to targeted bullets as of now.
	 */
	protected double angle;
	/**
	 * The speed of the entity
	 */
	protected double speed;

	/**
	 * Changes the speed of the caller
	 * @param newSpeed The value that will be the caller's new speed
	 */
	public void setSpeed(double newSpeed) {this.speed = newSpeed;}

	/**
	 * Gets the speed of the entity it is called on.
	 * @return the speed of the entity it is called on.
	 */
	public double getSpeed() {return this.speed;}

	protected Color color;

	//Sprite related variables
	/**
	 * The direction that the entity is facing. Used for spritedrawing purposes.
	 */
	protected int direction;

	/**
	 * Sets the direction of the entity that it is called on. Only used for spritedrawing purposes.
	 * @param i the direction which the entity will now be facing.
	 */
	public void setDirection(int i) {
		if(i <= 4&&i >= 0) {
			this.direction = i;
		}
		else {
			this.direction = 1;
		}
	}


	//Player Only Variables
	/**
	 * The score of the player.
	 */
	protected int Score;

	/**
	 * The number of bombs that the player has
	 */
	private static int bombs;

	/**
	 * Modifies the number of bombs that an entity has.
	 * @param deltaValue The amount by which bombs should be changed.
	 */
	public void bombsArithmetic(int deltaValue) {bombs += deltaValue;}

	/**
	 * 
	 * @return number of bombs in an entity's possession.
	 */
	public int getBombs() {return bombs;}

	/**
	 * Number of lives that the player has.
	 */
	protected static int lives;

	/**
	 * Overwrites the number of lives that the player has. 
	 * @param i new amount of lives that the player has.
	 */
	public void setLives(int i) {lives = i;}

	/**
	 * Adds a number to the player's number of lives. Use negative numbers to subtract lives from the player's lives. 
	 * @param deltaValue number to be added or subtracted.
	 */
	public void livesArithmetic(int deltaValue) {lives += deltaValue;}

	/**
	 * Returns the number of lives that the player has.
	 * @return number of lives the player has.
	 */
	public int getLives() {return lives;}
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


	//Location based variables and methods
	/**
	 * The current xLocation of the entity in pixels.
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
	 * Gets the yLocation of the entity in pixels.
	 * @return the yLocation of the entity in pixels.
	 */
	public double getY() {return this.yLocation;}

	/**
	 * Sets the yLocation of the entity to the given value
	 * @param newY the value that the entity's yLocation will be set to.
	 */
	public void setY(double newY) {this.yLocation = newY;}

	/**
	 * Tells the update processor to remove the entity if it is far enough out of the game bounds. The player will always return false.
	 * @return true if the entity is far enough off-screen, false otherwise.
	 */
	public boolean sudoku() {
		if(this.xLocation > 8000||this.xLocation < -1000||this.yLocation >8000||this.yLocation < -1000) {
			return true;
		}if(this.Health <= 0) {
			return true;
		}
		return false;

	}



	//MATHEMATICAL FUNCTIONS
	
	public Point toPoint() {
		return new Point(this.xLocation, this.yLocation);
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
	 * Standard distance formula.
	 * @param e The target entity
	 * @return the distance between the entity that calls this method and the target (e) in pixels as a double.
	 */
	public double getDistance(Entity e) {
		double xTest = Math.pow((this.xLocation - e.xLocation), 2);
		double yTest = Math.pow((this.yLocation - e.yLocation), 2);
		return Math.sqrt(xTest + yTest);
	}

	//Damage related variables
	/**
	 * Amount of time in milliseconds between shots fired by this entity
	 */
	protected int reloadTime;

	/**
	 * The last time that the entity fired a bullet / pattern of bullets
	 */
	protected long lastShot;

	/**
	 * The last time that the entity fired
	 */
	protected long lastFiring;

	/**
	 * The health of the entity.
	 */
	protected int Health;
	/**
	 * Damages the entity by the number input
	 * @param damageTaken the damage to be taken from the health
	 */
	public void hMath(int damageTaken) {this.Health -= damageTaken;}

	/**
	 * The damage dealt by the entity on contact with another. Note that the player only has lives, not a health system.
	 */
	protected int damage;
	/**
	 * Get the damage value of the caller
	 * @return the damage value of the caller
	 */
	public int getDamage() {return this.damage;}



	/**
	 * Don't use this
	 * @param newDamage Don't use this.
	 */
	public void setDamage(int newDamage) {this.damage = newDamage;}
	/**
	 * The last time that the entity took damage
	 */
	protected long lastHit = 0;
	
	/**
	 * Get the last time in milliseconds that the entity was damaged
	 * @return The last time in milliseconds that the entity was damaged
	 */
	public long getLastHit() {return this.lastHit;}
	
	/**
	 * Changes the last time that the entity was damaged. Measured in milliseconds.
	 * @param lastHit The time that will repoace the previous entry for last hit.
	 */
	public void setLastHit(long lastHit) {this.lastHit = lastHit;}
	//Mechanical methods
	/**
	 * Updates the current entity. Completely abstract.
	 */
	public abstract void update();

	/**
	 * Draws the entity on the screen.
	 * @param g its a pre-initialized graphics thing
	 */
	public abstract void draw(Graphics g);

	//Constructors and Bullet firing mechanisms
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
	 * @param Speed
	 * Sest the sped of the entity
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
	public Entity(double xLocation, double yLocation, int Health, double speed, double Height, double Width,int size,
			int hitR) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.speed = speed;
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
	protected void Bullet(int damage) {
		new Bullet(this.xLocation, this.yLocation, 1, 5, false, Color.RED, damage);
	}

	/**
	 * Fires a bullet from the entity that calls the method. Calls the bullet constructor with default parameters. Bullets can be friendly or hostile
	 * @param xVelocity The xVelocity of the fired bullet.
	 * @param yVelocity The yVelocity of the fired bullet.
	 * @param hostile If true, the bullet will be hostile to players. 
	 * 
	 * .
	 */
	protected void Bullet(boolean hostile, int damage, double speed, int size) {
		new Bullet(this.xLocation, this.yLocation, speed, size, hostile, Color.RED, damage);
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
		new targetedBullet(this.xLocation, this.yLocation, angleTo, speed, size, true, Color.RED, 6);
	}

	/**
	 * Fires a bullet at a predetermined point
	 * @param p the point to fire a bullet at
	 * @param speed the speed of the bullet
	 * @param size the size of the bullet
	 */ 
	public void TargetedBulletToPoint(Point p, double speed, int size) {
		double tempX = this.xLocation - p.getX();
		double tempY = this.yLocation - p.getY();

		float angleTo = (float) Math.toDegrees(Math.atan2(tempY,tempX));
		new targetedBullet(this.xLocation, this.yLocation, angleTo, speed, size, true, Color.RED, 6);
	}
	
	public void TargetedBulletToPoint(Point p, double speed, int size, double e) {
		double tempX = this.xLocation - p.getX();
		double tempY = this.yLocation - p.getY();

		float angleTo = (float) Math.toDegrees(Math.atan2(tempY,tempX));
		new targetedBullet(this.xLocation, this.yLocation, angleTo, speed, size, true, Color.RED, 6, e);
	}
	
	/**
	 * Fires a bullet at an angle from the entity. Can be used for bombs or for spiral patterns.
	 * @param angle The angle at which the bullet should be fired
	 * @param speed The speed at which the bullet should move
	 * @param size The size of the bullet
	 */
	public void angledBullet(int angle, double speed, int size) {
		new targetedBullet(this.xLocation, this.yLocation, angle, speed, size, true, Color.RED, 6);
	}
	
	
	
	/**
	 * Gets the position of another entity as a point
	 * @param e the Entity that is being checked
	 * @return The location of e as a point
	 */
	public Point getPoint(Entity e) {
		return new Point(e.xLocation, e.yLocation);
	}


	/**
	 * The hit-detection method of all entities
	 */
	@Override
	public void run() {
		for(int b = 0; b < GameWindow.bullets.size(); b++) {
			hitCheck(GameWindow.bullets.get(b));
		}
		for(int j = 0; j <  GameWindow.notBullets.size(); j++) {
			hitCheck(GameWindow.notBullets.get(j));
		}
	}
	/**
	 * Checks if the entity calling the method is touching another entity's hit-radius
	 * @param b The entity being check against
	 */
	private void hitCheck(Entity b) {
		if(this.geteTYPE() == b.geteTYPE()) {
			return;
		}
		if(Math.abs(this.getX() - b.getX()) > 500||Math.abs(this.getY() - b.getY()) > 500){
			return;
		}

		else if(this.getDistance(b) < this.getR() + b.getR()) {
			if(this.CtrlCheck()&&!b.geteTYPE().equals(Entity.eTYPE.HARMLESS)) {
				b.setX(8000);
				GameWindow.lives--;
				this.setLastHit(System.currentTimeMillis());
				return;	
			}if(this.geteTYPE().equals(Entity.eTYPE.HOSTILE)&&!b.geteTYPE().equals(Entity.eTYPE.HOSTILE)) {
				b.setX(8000);
				this.hMath(b.getDamage());
				return;
			}if(this.geteTYPE().equals(Entity.eTYPE.CRTL)&&b.geteTYPE().equals(Entity.eTYPE.HOSTILE)) {
				b.hMath(50);
				GameWindow.lives--;
			}
		}
	}
}
