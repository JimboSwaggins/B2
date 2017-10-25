package render;

import java.util.ArrayList;

public class weightedEstimate {
	static double frameTime = 0;
	static double weight = 0;
	
	public static double nextFrame(ArrayList<Long> deltaX){
		frameTime = 0;
		for(double i = 0; i< deltaX.size(); i++){
			frameTime += (double) deltaX.get((int)i) * (6.0 - i)/6.0;
		}
		frameTime /= 3.5;
		return(frameTime);
	}	
}
