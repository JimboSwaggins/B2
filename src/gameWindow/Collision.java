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
			for(int b = start; b < end; b++) {
				hitCheck(GameWindow.notBullets.get(i), GameWindow.bullets.get(b));
			}
		}
	}
		
	private void hitCheck(Entity e, Entity b) {
		if(e.geteTYPE().equals(b.geteTYPE())) {
			return;
		}

		else if(e.getDistance(b) < e.getR() + b.getR()) {
			if(e.CtrlCheck()&&!b.geteTYPE().equals(Entity.eTYPE.HARMLESS)) {
				b.setX(8000);
				GameWindow.character.livesArithmetic(-1);
				//GameWindow.notBullets.get(i).setX(8000);\
				return;
			}else if(e.geteTYPE().equals(Entity.eTYPE.HOSTILE)) {
				b.setX(8000);
				e.hMath(b.getDamage());
				return;
			}
		}
	}
}
