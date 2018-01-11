package gameWindow.Entities.BadGuy;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.Entities.Badguy;

public class Glitch extends Badguy{
	private double amplitude;
	private int line;
	private int LWidth;
	private int LY;
	private int cT;
	private int sT;
	private double xV;
	private double yV;

	/**
	 * 
	 * @param xLocation
	 * @param yLocation
	 * @param Health
	 * @param xVel
	 * @param yVel
	 * @param Size
	 * @param Amplitude How fat the Shaking goes
	 */
	
	public Glitch(double xLocation, double yLocation, int Health, double xVel, double yVel, int Size, double Amplitude) {
		super(xLocation, yLocation, Health, 0);
		this.size = Size;
		this.xV = xVel;
		this.yV = yVel;
		this.hitR = size /2;
		this.amplitude = Amplitude;
		this.line = 0;
		this.cT = 0;
		this.sT = 0;
	}
	
	public void update(){
		double roll = Math.random();
		if(roll < .8){
			this.xLocation += xV;
			this.yLocation += yV;
		}
		else if(roll < .9){
			this.xLocation += (Math.random() -.5) * this.amplitude;
			this.yLocation += (Math.random() -.5) * this.amplitude;
		}
		else if(roll < .99){
			this.xLocation += (Math.random() -.5) * 5 * this.amplitude;
			this.yLocation += (Math.random() -.5) * 5 * this.amplitude;
		}
		else{
			this.xLocation += Math.signum(Math.random() - .5) * 5 * this.amplitude;
			this.yLocation += Math.signum(Math.random() - .5) * 5 * this.amplitude;
		}
	}
	
	public void draw(Graphics g) {
		if(Math.random() < .99) {
			if(cT > 0){
				g.setColor(Color.CYAN);
				cT --;
			}
			else{
				g.setColor(Color.RED);
				if(Math.random() > .995){
					cT = (int) (Math.random() * 30);
				}
			}
			
			if(sT > 0){
				g.fillRect((int)xLocation - this.size/2, (int)yLocation - this.size/2, this.size, this.size);
				sT --;
			}
			else{
				g.fillOval((int)xLocation - this.size/2, (int)yLocation - this.size/2, this.size, this.size);
				if(Math.random() > .995){
					sT = (int) (Math.random() * 120);
				}
			}
		}

		if(sT > 0){
			g.drawImage(bugSprite2, (int)(this.xLocation - (bugSprite2.getWidth()/2)+1), (int)(this.yLocation - (bugSprite2.getHeight()/2)+1), null);
			sT--;
		}
		else{
			g.drawImage(bugSprite, (int)(this.xLocation - (bugSprite.getWidth()/2)+1), (int)(this.yLocation - (bugSprite.getHeight()/2)+1), null);
			if(Math.random() > .995){
				sT = (int) (Math.random() * 120);

		
		if(Math.random() > .1) {
			if(line > 0){
				line --;
				g.setColor(Color.WHITE);
				g.fillRect(0,LY,1920,LWidth);
			}
			else{
				if(Math.random() > .99){
					LWidth = (int)(Math.random() * 6);
					LY = (int)(Math.random() * 720);
					line = (int)(Math.random() * 120);
				}

			}
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
	
	public boolean isBullet() {
		return false;
	}
}
