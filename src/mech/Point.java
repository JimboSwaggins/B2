package mech;

public class Point {
	private double Xloc;
	private double Yloc;
	
	public double getX() {
		return this.Xloc;
	}
	public double getY() {
		return this.Yloc;
	}
	
	public Point(double x, double y) {
		this.Xloc = x;
		this.Yloc = y;
	}
}
