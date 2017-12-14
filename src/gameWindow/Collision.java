package gameWindow;

import gameWindow.Entities.Entity;

public class Collision extends Thread implements Runnable{
	private int start;
	private int end;


	public Collision(){
		
	}

	public void run() {
		for(int i = 0; i < GameWindow.notBullets.size(); i++) {
			for(int b = 0; b < GameWindow.bullets.size(); b++) {
				//System.out.println(GameWindow.objList.get(i) + " " + GameWindow.objList.get(b));
				if(GameWindow.notBullets.get(i).geteTYPE().equals(GameWindow.bullets.get(b).geteTYPE())) {
					continue;
				}
				else if(Math.abs(GameWindow.notBullets.get(i).getX() - GameWindow.bullets.get(b).getX()) >= 50) {
					continue;
				}
				else if(Math.abs(GameWindow.notBullets.get(i).getY() - GameWindow.bullets.get(b).getY()) >= 50) {
					continue;
				}
				else if(GameWindow.notBullets.get(i).getDistance(GameWindow.bullets.get(b)) < GameWindow.notBullets.get(i).getR() + GameWindow.bullets.get(b).getR()) {
					if(GameWindow.notBullets.get(i).CtrlCheck()&&!GameWindow.bullets.get(b).geteTYPE().equals(Entity.eTYPE.HARMLESS)) {
						GameWindow.bullets.get(b).setX(8000);
						//GameWindow.notBullets.get(i).setX(8000);\
						continue;
					}else if(GameWindow.notBullets.get(i).geteTYPE().equals(Entity.eTYPE.HOSTILE)) {
						GameWindow.bullets.get(b).setX(8000);
						GameWindow.notBullets.get(i).hMath(GameWindow.bullets.get(b).getDamage());
						break;
					}
				}
			}
		}
	}
}
