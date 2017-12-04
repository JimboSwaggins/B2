package gameWindow;

import gameWindow.Entities.Entity;

public class Collision extends Thread{

	
	public void run() {
		for(int i = 0; i < GameWindow.objList.size(); i++) {
			GameWindow.objList.get(i);
			for(int b = i; b < GameWindow.objList.size(); b++) {
				GameWindow.objList.get(b);
				if(GameWindow.objList.get(i).getDistance(GameWindow.objList.get(b)) < GameWindow.objList.get(i).getR());
			}
		}
	}
}
