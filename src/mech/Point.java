package mech;

public class Point{
	private double Xloc;
	private double Yloc;
	
	public double getX() {
		return this.Xloc;
	}
	public double getY() {
		return this.Yloc;
	}
	
	public Point(double xLocation, double yLocation) {
		this.Xloc = xLocation;
		this.Yloc = yLocation;
	}
}
