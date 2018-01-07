package gameWindow.Entities.BadGuy;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.Entities.Badguy;

public class Glitch extends Badguy{
	private int xVel;
	private int yVel;
	private double amplitude;
	private int line;
	private int LWidth;
	private int LY;

	public Glitch(double xLocation, double yLocation, int Health, int xVel, int yVel, int Size, double Amplitude) {
		super(xLocation, yLocation, Health, 0);
		this.size = Size;
		this.xVel = xVel;
		this.yVel = yVel;
		this.hitR = size /2;
		this.amplitude = Amplitude;
		this.line = 0;
	}
	
	public void update(){
		double roll = Math.random();
		if(roll < .75){
			this.xLocation += xVel;
			this.yLocation += yVel;
		}
		else if(roll < .98){
			this.xLocation += (Math.random() -.5) * this.amplitude;
			this.yLocation += (Math.random() -.5) * this.amplitude;
		}
		else{
			this.xLocation += Math.signum(Math.random() - .5) * 5 * this.amplitude;
			this.yLocation += Math.signum(Math.random() - .5) * 5 * this.amplitude;
		}
	}
	
	public void draw(Graphics g) {
		if(line > 0){
			line --;
			g.setColor(Color.WHITE);
			g.fillRect(0,LY,1920,LWidth);
		}
		else{
			if(Math.random() > .995){
				LWidth = (int)(Math.random() * 10);
				LY = (int)(Math.random() * 720);
				line = (int)(Math.random() * 120);
			}
		}
		
		if(Math.random() > .95){
			g.setColor(Color.CYAN);
		}
		else{
			g.setColor(Color.YELLOW);
		}
		
		if(Math.random() > .95){
			g.fillRect((int)xLocation - this.size/2, (int)yLocation - this.size/2, this.size, this.size);
		}
		else{
			g.fillOval((int)xLocation - this.size/2, (int)yLocation - this.size/2, this.size, this.size);
		}
		
	}
	
	public boolean sudoku() {
		if(this.xLocation > 1290||this.xLocation < -10||this.yLocation >730||this.yLocation < -10) {
			return true;
		}if(this.Health <= 0) {
			return true;
		}
		return false;
	}
}
