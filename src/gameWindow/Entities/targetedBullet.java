package gameWindow.Entities;

import java.awt.Color;

class targetedBullet extends Bullet{
	public targetedBullet(double xLocation, double yLocation, double angle, double speed, int size,
			boolean hostile, Color color) {
		super(xLocation, yLocation, 0, 0, speed, size, hostile, color);
		this.angle = angle;
	}
	@Override 
	public void update() {
		double rad = Math.toRadians(this.angle);
		this.xLocation -= .5 * Math.cos(rad) * this.getSpeed() * render.VRR.time;
		this.yLocation -= .5 * Math.sin(rad)  * this.getSpeed() * render.VRR.time;
	}
}