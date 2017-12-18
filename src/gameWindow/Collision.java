package gameWindow;

import gameWindow.Entities.Entity;

public class Collision implements Runnable{
	private final int start;
	private final int end;


	public Collision(int START, int END){
		this.start = START;
		this.end = END;
	}

	public void run() {
		for(int i = 0; i < GameWindow.notBullets.size(); i++) {
			for(int b = 0; b < GameWindow.objList.size(); b++) {
				//System.out.println(GameWindow.objList.get(i) + " " + GameWindow.objList.get(b));
				if(GameWindow.notBullets.get(i).geteTYPE().equals(GameWindow.objList.get(b).geteTYPE())) {
					continue;
				}
				else if(Math.abs(GameWindow.notBullets.get(i).getX() - GameWindow.objList.get(b).getX()) >= 50) {
					continue;
				}
				else if(Math.abs(GameWindow.notBullets.get(i).getY() - GameWindow.objList.get(b).getY()) >= 50) {
					continue;
				}
				else if(GameWindow.notBullets.get(i).getDistance(GameWindow.objList.get(b)) < GameWindow.notBullets.get(i).getR() + GameWindow.objList.get(b).getR()) {
					if(GameWindow.notBullets.get(i).CtrlCheck()&&!GameWindow.objList.get(b).geteTYPE().equals(Entity.eTYPE.HARMLESS)) {
						GameWindow.objList.get(b).setX(8000);
						GameWindow.character.livesArithmetic(-1);
						//GameWindow.notBullets.get(i).setX(8000);\
						continue;
					}else if(GameWindow.notBullets.get(i).geteTYPE().equals(Entity.eTYPE.HOSTILE)) {
						GameWindow.objList.get(b).setX(8000);
						GameWindow.notBullets.get(i).hMath(GameWindow.objList.get(b).getDamage());
						break;
					}
				}
			}
}
	}
}
