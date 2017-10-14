package gameWindow.Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity{
	
	
	@SuppressWarnings("unused")
	private double speed;
	//GOTTA GO FAST
	
	public Player(int x, int y, int health, int dx, int dy) {
		super(x, y, health, dx, dy);
		this.isControllable = true;
	}
	
	public Player(int x, int y) {
		super(x, y, 100, 0, 0);
		this.isControllable = true;
		this.setFocus(false);
		this.setFiring(false);
		this.setLives(3);
		this.setScore(0);
	}
	
	//TODO Add speed. In other words, get the delta working based on how long the player has been moving or something, and also make it so that the player's movement speed is based of of their base speed oar acceleration
	public void update() {
		super.update();
	}
	
	public void draw(Graphics g) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("../B2/img/p.png"));
		} catch (IOException e) {
		}
		g.drawImage(img, this.xLocation, this.yLocation, null);
	}
	
	
}
