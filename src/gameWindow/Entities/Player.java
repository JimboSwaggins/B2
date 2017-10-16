package gameWindow.Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameWindow.GameWindow;

public class Player extends Entity{

	@SuppressWarnings("unused")
	private double speed;
	//GOTTA GO FAST
	
	public Player(int x, int y, int health, int dx, int dy) {
		super(x, y, health, dx, dy);
		this.isControllable = true;
		this.speed = 10;
		this.direction = 0;
	}
	
	public Player(int x, int y) {
		super(x, y, 100, 0, 0);
		GameWindow.objList.add(this);
		this.speed = 1;
		
		this.isControllable = true;
		this.setFocus(false);
		this.setFiring(false);
		this.setLives(3);
		this.setScore(0);
	}
	
	//TODO Add speed. In other words, get the delta working based on how long the player has been moving or something, and also make it so that the player's movement speed is based of of their base speed oar acceleration
	public void update() {
		super.update();
		if(isUp) {this.yLocation -= speed;}
		if(isDown) {this.yLocation += speed;}
		if(isRight) {this.xLocation += speed;}
		if(isLeft) {this.xLocation -= speed;}
		if(this.xLocation > 1280) {
			this.xLocation = 1280;
		}if(this.yLocation > 720) {
			this.yLocation = 720;
		}if(this.xLocation < 0) {
			this.xLocation = 0;
		}if(this.yLocation < 0) {
			this.yLocation = 0;
		}
		
		if(this.isFiring()) {
<<<<<<< HEAD
			GameWindow.objList.add(new Bullet(this.xLocation, this.yLocation, 0, 0, 3, 3, Math.toRadians(90)));
=======
			GameWindow.objList.add(new Bullet(this.xLocation, this.yLocation, 0, 0, 3, 3, Math.toRadians(0)));
>>>>>>> 5927bd9ef205525da42390e18ef9888bf3f79c7d
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
		g.drawImage(img, this.xLocation, this.yLocation, null);
	}
	
	
}
