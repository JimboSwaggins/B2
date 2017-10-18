package gameWindow.Entities;

public class Badguy extends Entity{

	private int rSpeed;
	private long lastShot;
	
	
	public double angleTarget() {
		double i = 0;
		return i;
		//get angle to player and stuff here.
		
	}
	
	public Badguy(double xLocation, double yLocation, int Health) {
		super(xLocation, yLocation, Health, 0, 0);
		this.entityType = eTYPE.HOSTILE;
		this.rSpeed = 300;
		this.lastShot = System.currentTimeMillis();
	}
	
	public void update() {
		
	}

}
