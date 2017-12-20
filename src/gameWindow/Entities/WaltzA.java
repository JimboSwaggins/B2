package gameWindow.Entities;

import java.awt.Color;

import mech.Point;

public class WaltzA extends Badguy{

	private Point[] choreo;

	public WaltzA(double x, double y, Point[] choreography, double size, Color color, long delay, double rotSpeed, double orbitalDistance) {
		super(x, y, -1, 3);
	}
	public void update() {
		for(int i = 0; i < choreo.length;i++) {
			
		}
	}
}