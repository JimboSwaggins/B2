package render;

import java.util.ArrayList;

// Variable Refresh rate
public class VRR {
	protected static long currentTime;
	protected static ArrayList<Long> listOfTimes = new ArrayList<Long>();
	protected static ArrayList<Long> deltaX = new ArrayList<Long>();
	
	public static void ping() {
		currentTime = (long) System.currentTimeMillis();
		listOfTimes.add(0, currentTime);
		if(listOfTimes.size() > 6) {
			listOfTimes.remove((listOfTimes.size() - 1));
		}
		if(listOfTimes.size() < 2) {
			listOfTimes.add(currentTime);
		}
		deltaX.clear();
		for(int i = 1 ; i < (listOfTimes.size()); i++){
			long x1 = listOfTimes.get((i));
			long x2 = listOfTimes.get((i - 1));
			long delta = x2 - x1;
			deltaX.add(delta);
		}
		System.out.println(listOfTimes);
		System.out.println(deltaX);
	}
}
