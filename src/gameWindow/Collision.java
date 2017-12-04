package gameWindow;

import gameWindow.Entities.Entity;

public class Collision extends Thread{

	
	public void run() {
		for(int i = 0; i < GameWindow.objList.size() - 1; i++) {
			for(int b = i + 1; b < GameWindow.objList.size(); b++) {

			 GameWindow.objList.get(b);
				System.out.println(GameWindow.objList.get(i) + " " + GameWindow.objList.get(b));

				
			}
		}
	}
}
