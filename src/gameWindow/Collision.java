package gameWindow;

public class Collision extends Thread{
	private int start;
	private int end;
	
	
	public Collision(int START, int END){
		this.start = START;
		this.end = END;
	}
	
	public void run() {

		for(int i = this.start; i < this.end; i++) {
			for(int b = i + 1; b < this.end; b++) {
				//System.out.println(GameWindow.objList.get(i) + " " + GameWindow.objList.get(b));
				if(GameWindow.objList.get(i).getDistance(GameWindow.objList.get(b)) < GameWindow.objList.get(i).getR() + GameWindow.objList.get(b).getR()) {
					System.out.print(" [] ");
				}


		}
	}

	}
}
