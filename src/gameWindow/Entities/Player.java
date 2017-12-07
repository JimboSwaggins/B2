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
	

	/** 
	 * @param x
	 * Starting xLocation of the player
	 * @param y
	 * Starting yLocation of the player
	 */
	
	
	public Player(int x, int y) {
		super(x, y, 100, 0, 0, 30.0, 30.0, 5, 5);
		GameWindow.objList.add(this);
		this.acceleration = .01;

		this.entityType = eTYPE.CRTL;
		this.setFocus(false);
		this.setFiring(false);

		this.reloadTime = 100;

		this.setLives(3);
		this.Score = 0;;
	}

	public void update() {
		this.acceleration = .0024 * render.VRR.time;
		if(!isFocus) {
				if(isUp) {
					if(yVelocity > 0.1) {
						this.yVelocity -= this.yVelocity * .01 * render.VRR.time;
					}
					this.yVelocity -= acceleration;
				}
				if(isDown) {
					if(yVelocity < -0.1) {
						this.yVelocity -= this.yVelocity * .01 * render.VRR.time;
					}
					else{
						this.yVelocity += acceleration;
					}	
				}
				if(isRight) {
					this.xLocation += 1;
				}
				if(isLeft) {
					this.xLocation -= 1;
				}

				//System.out.println(this.xVelocity);

				if(this.xLocation > 1280) {
					this.xLocation = 1280;
					this.xVelocity *=  -.75;
				}
				if(this.yLocation > 720) {
					this.yLocation = 720;
					this.yVelocity *= -.75;
				}
				if(this.xLocation < 0) {
					this.xLocation = 0;
					this.xVelocity *=  -.75;
				}
				if(this.yLocation < 0) {
					this.yLocation = 0;
					this.yVelocity *= -.75;
				}


				if(! isLeft && ! isRight) {
					this.xVelocity = this.slow(this.xVelocity, 0.99);
				}
				if(! isUp && ! isDown) {
					this.yVelocity = this.slow(this.yVelocity, 0.99);
				}

				this.yLocation +=  .6 * this.yVelocity * render.VRR.time;
			}
		if(isFocus) {
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
			if(this.xLocation > 1280) {
				this.xLocation = 1280;
			}
			if(this.yLocation > 720) {
				this.yLocation = 720;
			}
			if(this.xLocation < 0) {
				this.xLocation = 0;
			}
			if(this.yLocation < 0) {
				this.yLocation = 0;
			}

			
		}

		if(this.isFiring()&&(System.currentTimeMillis() - this.lastFiring >= this.reloadTime)) {
			Bullet(0, this.yVelocity, false);
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



		// System.out.println(Math.sqrt(this.xVelocity * this.xVelocity + this.yVelocity * this.yVelocity));
	}

}
