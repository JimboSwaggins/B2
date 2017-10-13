package mech;

import gameWindow.GameWindow;

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
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
}
