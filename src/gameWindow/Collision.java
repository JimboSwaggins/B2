package gameWindow;

import gameWindow.Entities.Entity;

public class Collision extends Thread{


	@Override
	public void run() {
		for(int i = 0; i < GameWindow.objList.size(); i++) {
			Entity e = GameWindow.objList.get(i);
			for(int b = i; b < GameWindow.objList.size(); b++) {
				GameWindow.objList.get(b);
				
			}
		}
	}
}
