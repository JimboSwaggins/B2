package mech;

import gameWindow.GameWindow;
import render.gameRender;

public class gameCalculate extends GameWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public enum GAMESTATE{
		MENU,
	}
	
	public static GAMESTATE status = GAMESTATE.MENU;
	public static void update() {
		for(int i = 0; i < objList.size(); i++) {
			try {
				objList.get(i).update();
				try {
					if(objList.get(i).CtrlCheck()) {
						gameRender.setLifeNum(objList.get(i).getLives());
						gameRender.setScore(objList.get(i).getScore());
					}
				}catch(NullPointerException e) {
					e.printStackTrace();
				}
				
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
}
