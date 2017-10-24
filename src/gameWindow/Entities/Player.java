package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameWindow.GameWindow;

public class Player extends Entity{

	private double acceleration;
	private long lastFiring;

	private long rSpeed;

	//GOTTA GO FAST


	public Player(int x, int y) {
		super(x, y, 100, 0, 0);
		GameWindow.objList.add(this);
		this.acceleration = .01;
		this.height = 30.0;
		this.width = 30.0;

		this.hitR = 3;

		this.entityType = eTYPE.CRTL;
		this.setFocus(false);
		this.setFiring(false);

		this.rSpeed = 100;

		this.setLives(3);
		this.Score = 0;;
	}

	//TODO Add speed. In other words, get the delta working based on how long the player has been moving or something, and also make it so that the player's movement speed is based of of their base speed oar acceleration
	public void update() {
		if(!isFocus) {
			if(isUp) {
				if(yVelocity > 0) {
					this.yVelocity -= 2 * acceleration;
				}
				else {
					this.yVelocity -= acceleration;
				}
			}
			if(isDown) {
				if(yVelocity < 0) {
					this.yVelocity *= 0.99;
				}
				this.yVelocity += acceleration;
			}
			if(isRight) {
				if(xVelocity < 0) {
					this.xVelocity *= 0.99;
				}
				this.xVelocity += acceleration;
			}
			if(isLeft) {
				if(xVelocity > 0) {
					this.xVelocity *= 0.99;
				}
				this.xVelocity -= acceleration;
			}

			if(! isLeft && ! isRight) {this.xVelocity *= 0.99;}
			if(! isUp && ! isDown) {this.yVelocity *= 0.99;}
			this.xLocation += this.xVelocity;
			this.yLocation += this.yVelocity;
		}if(isFocus) {
			if(isUp) {
				this.yLocation -= 0.5;
			}
			if(isDown) {
				this.yLocation += 0.5;
			}
			if(isRight) {
				this.xLocation += 0.5;
			}
			if(isLeft) {
				this.xLocation -= 0.5;
			}
		}

		if(this.xLocation > 1280) {
			this.xLocation = 1280;
		}if(this.yLocation > 720) {
			this.yLocation = 720;
		}if(this.xLocation < 0) {
			this.xLocation = 0;
		}if(this.yLocation < 0) {
			this.yLocation = 0;
		}

		if(this.isFiring()&&(System.currentTimeMillis() - this.lastFiring >= this.rSpeed)) {
			new Bullet(this.xLocation, this.yLocation, 0, -3, 4, 9, false, Color.BLUE);
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
