package gameWindow.Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameWindow.GameWindow;

public class Player extends Entity{
	
<<<<<<< HEAD
	@SuppressWarnings("unused")
	private int yLocation;
	public int getY() {return this.yLocation;}
	public void setY(int i) {this.yLocation = i;}
	@SuppressWarnings("unused")
	private int yDelta;
=======
>>>>>>> f2fbd8ff000057a49aa0c9c349624654ad4a2af2
	
	@SuppressWarnings("unused")
	private double speed;
	//GOTTA GO FAST
	
	public Player(int x, int y, int health, int dx, int dy) {
		super(x, y, health, dx, dy);
		this.isControllable = true;
		this.direction = 0;
	}
	
	public Player(int x, int y) {
		super(x, y, 100, 0, 0);
		GameWindow.objList.add(this);
		this.isControllable = true;
		this.setFocus(false);
		this.setFiring(false);
		this.setLives(3);
		this.setScore(0);
	}
	
	//TODO Add speed. In other words, get the delta working based on how long the player has been moving or something, and also make it so that the player's movement speed is based of of their base speed oar acceleration
	public void update() {
<<<<<<< HEAD

		if(isUp) {
			this.yLocation--;
		}if(isDown) {
			this.yLocation++;
		}if(isLeft) {
			this.xLocation--;
		}if(isRight) {
			this.xLocation++;
		}
=======
		super.update();
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
>>>>>>> f2fbd8ff000057a49aa0c9c349624654ad4a2af2
	}
	
	
}
