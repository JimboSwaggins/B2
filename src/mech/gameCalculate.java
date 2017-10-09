package mech;

public class gameCalculate{
	public enum GAMESTATE{
		MENU,
	}
	
	public static GAMESTATE status = GAMESTATE.MENU;
	public static void update() {
		if(status == GAMESTATE.MENU) {
		}
	}
}
