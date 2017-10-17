package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameWindow.GameWindow;
import mech.gameCalculate;

public class Player extends Entity{

	@SuppressWarnings("unused")
	private double speed;
	private long lastFiring;
	private long rSpeed;
	
	//GOTTA GO FAST
	
	public Player(int x, int y, int health, int dx, int dy) {
		super(x, y, health, dx, dy);
		this.isControllable = true;
		this.speed = 10;
		this.direction = 0;
		this.height = 16.0;
		this.width = 16.0;
	}
	
	public Player(int x, int y) {
		super(x, y, 100, 0, 0);
		GameWindow.objList.add(this);
		this.speed = 1;
		this.height = 29.0;
		this.width = 29.0;
		
		this.isControllable = true;
		this.setFocus(false);
		this.setFiring(false);
		
		this.rSpeed = 30;
		
		this.setLives(3);
		this.setScore(0);
	}
	
	//TODO Add speed. In other words, get the delta working based on how long the player has been moving or something, and also make it so that the player's movement speed is based of of their base speed oar acceleration
	public void update() {
		super.update();
		if(isUp) {this.yDelta -= .01;}
		if(isDown) {this.yDelta += .01;}
		if(isRight) {this.xDelta += .01;}
		if(isLeft) {this.xDelta -= .01;}
		if(this.xLocation > 1280) {
			this.xLocation = 1280;
		}if(this.yLocation > 720) {
			this.yLocation = 720;
		}if(this.xLocation < 0) {
			this.xLocation = 0;
		}if(this.yLocation < 0) {
			this.yLocation = 0;
		}
		
		//if(Math.sqrt(Math.pow(this.xDelta, 2) + Math.pow(this.yDelta, 2)) > 1) {
			//make it so that the sum is evened out IDK
		//}
		if(!isRight&&!isLeft) {
			this.xDelta = gameCalculate.convToZero(this.xDelta, 0.01);
		}
		if(!isUp&&!isDown) {
			this.yDelta = gameCalculate.convToZero(this.yDelta, 0.01);
		}
		
		this.xLocation += this.xDelta;
		this.yLocation += this.yDelta;
		if(this.isFiring()&&(System.currentTimeMillis() - this.lastFiring >= this.rSpeed)) {
			GameWindow.objList.add(new Bullet(this.xLocation, this.yLocation, 0, 0,0.1 + (-1 * this.yDelta), Math.toRadians(90), 8));
			this.lastFiring = System.currentTimeMillis();
		}
	}
	
	public void draw(Graphics g) {
		BufferedImage img = null;
		try {
			switch(direction){
			case 1:
				img = ImageIO.read(new File("../B2/img/p_up.png"));
				break;
			case 2:
				img = ImageIO.read(new File("../B2/img/p_right.png"));
				break;
			case 3:
				img = ImageIO.read(new File("../B2/img/p_down.png"));
				break;
			case 4:
				img = ImageIO.read(new File("../B2/img/p_left.png"));
				break;
			default:
				img = ImageIO.read(new File("../B2/img/p.png"));
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, (int)(this.xLocation - (this.width/2) + 1), (int)(this.yLocation - (this.height/2) + 1), null);
		g.setColor(Color.BLUE);
		g.fillOval((int)this.xLocation, (int)this.yLocation, 3, 3);
	}
}
