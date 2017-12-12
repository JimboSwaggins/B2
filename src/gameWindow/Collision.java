package gameWindow;

import gameWindow.Entities.Entity;

public class Collision extends Thread{
	private int start;
	private int end;


	public Collision(int START, int END){
		this.start = START;
		this.end = END;
	}

	public void run() {

		for(Entity e: GameWindow.notBullets) {
			if(!e.isBullet()){
				for(Entity b : GameWindow.bullets) {
					//System.out.println(GameWindow.objList.get(i) + " " + GameWindow.objList.get(b));
					if(e.getDistance(b) < e.getR() + b.getR()&&!e.CtrlCheck()) {
						b.setX(8000);
					}
				}
			}
		}
	}
}

