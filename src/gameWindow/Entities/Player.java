package gameWindow.Entities;

public class Player {
	private int Health;
	public int getHealth() {return this.Health;}
	public void setHealth(int toChange) {this.Health = toChange;}
	
	@SuppressWarnings("unused")
	private int xLocation;
	public int getX() {return this.xLocation;}
	public void setX(int i) {this.xLocation = i;}
	@SuppressWarnings("unused")
	private int xDelta;
	
	@SuppressWarnings("unused")
	private int yLocation;
	public int getY() {return this.yLocation;}
	@SuppressWarnings("unused")
	private int yDelta;
	
	@SuppressWarnings("unused")
	private double speed;
	//GOTTA GO FAST
	
	private int score;
	//score messing things
	public void scoreArithmetic(int deltaValue) {this.score += deltaValue;
	//POSSIBILITY OF ADDING MULTIPLIER VALUES?
		}
	public int getScore() {return this.score;}
	
	private int bombs;
	public void bombsArithmetic(int deltaValue) {this.bombs += deltaValue;}
	public int getBombs() {return this.bombs;}
	
	private int lives;
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
	
	
	public Player() {
		this.xLocation = 0;
		this.yLocation = 0;
		this.isUp = false;
		this.isDown = false;
		this.isLeft = false;
		this.isRight = false;
	}
	
	//TODO Add speed. In other words, get the delta working based on how long the player has been moving or something, and also make it so that the player's movement speed is based of of their base speed oar acceleration
	public void update() {
		if(isUp) {
			this.yLocation--;
		}if(isDown) {
			this.yLocation++;
		}if(isLeft) {
			this.xLocation--;
		}if(isRight) {
			this.xLocation++;
		}
	}
	
	
}
