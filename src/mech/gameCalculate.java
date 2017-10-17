package mech;

import java.util.ArrayList;

import gameWindow.GameWindow;
import gameWindow.Entities.Entity;

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
		ArrayList<Entity> temp = objList;
		for(int i = 0; i < objList.size(); i++) {
			try {
 				temp.get(i).update();
				}catch(NullPointerException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static double convToZero(double i, double delta) {
		if(i > 0) {
			i -= delta;
		}if(i < 0) {
			i += delta;
		}
		if(Math.abs(i) < 0.05) {
			i = 0;
		}
		
		return i;
	}
}
