package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameWindow.GameWindow;

public class Player extends Entity{

	/** 
	 * @param x
	 * Starting xLocation of the player
	 * @param y
	 * Starting yLocation of the player
	 */
	
	
	
	
	public Player(int x, int y) {
		
		super(x, y, 100, 3, 30.0, 30.0, 5, 2);
		this.setHitTime();
		GameWindow.notBullets.add(this);
		this.lastHit = System.currentTimeMillis();
		GameWindow.lives = 3;
		this.entityType = eTYPE.CRTL;
		this.setFocus(false);
		this.setFiring(false);
		this.hitR = 10;
		this.reloadTime = 10;
		

	}

	
	public void update() {

		if(!isFocus) {
				if(isUp) {
					this.yLocation -= 4;
				}
				if(isDown) {
					this.yLocation += 4;
				}
				if(isRight) {
					this.xLocation += 4;
				}
				if(isLeft) {
					this.xLocation -= 4;
				}

			}
		if(isFocus) {
			if(isUp) {
				this.yLocation -= 2;
			}
			if(isDown) {
				this.yLocation += 2;
			}
			if(isRight) {
				this.xLocation += 2;
			}
			if(isLeft) {
				this.xLocation -= 2;
			}
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

		if(this.isFiring()&&(System.currentTimeMillis() - this.lastFiring >= this.reloadTime)) {
			Bullet(false, 50, 5, 5, 1);
			this.lastFiring = System.currentTimeMillis();
		}
	}

	public void draw(Graphics g) {
		BufferedImage img = null;
		
		try {
			if(this.hitTime > System.currentTimeMillis()) {
				img = ImageIO.read(new File("../B2/img/pHit.png"));
			}else {
				img = ImageIO.read(new File("../B2/img/p.png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, (int)(this.xLocation - (this.width/2) + 1), (int)(this.yLocation - (this.height/2) + 1), null);
		g.setColor(Color.BLUE);
		g.fillOval((int)this.xLocation, (int)this.yLocation, 3, 3);



		
	}

	
	
	
	
	//System Methods
	@Override
	public boolean isBullet() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean sudoku() {
		return false;
	}

}
