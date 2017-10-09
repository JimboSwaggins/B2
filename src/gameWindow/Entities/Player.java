package gameWindow.Entities;

public class Player {
	private int Health;
	public int getHealth() {return this.Health;}
	public void setHealth(int toChange) {this.Health = toChange;}
	
	private int xLocation;
	private int xDelta;
	
	private int yLocation;
	private int yDelta;
	
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
	
	private boolean isFiring;
	public void setFiring(boolean input) {this.isFiring = input;}
	
	private boolean isFocus;
	public void setFocus(boolean input) {this.isFocus = input;}
	
	
	
	public void update() {
		
	}
	
	
}
