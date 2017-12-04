package gameWindow;

import gameWindow.Entities.Entity;

public class Collision extends Thread{

	
	public void run() {
		for(int i = 0; i < GameWindow.objList.size(); i++) {
			Entity e = GameWindow.objList.get(i);
			for(int b = i; b < GameWindow.objList.size(); b++) {

				Entity f = GameWindow.objList.get(b);
				System.out.println(e + " " + f);

				GameWindow.objList.get(b);
				
			}
		}
	}
}
