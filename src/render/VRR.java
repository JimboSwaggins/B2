package render;

import java.util.ArrayList;

// Variable Refresh rate
public class VRR {
	protected static long currentTime;
	protected static ArrayList<Long> listOfTimes = new ArrayList<Long>();
	protected static ArrayList<Long> deltaX = new ArrayList<Long>();
	
	
	/*
	 * I don't know what this does, but it works, so  that's cool. 
	 * Ethan.
	 * 
	 * Also, use "//TODO" in order to mark down stuff that needs to be done. It'll come up in the "Tasks" portion of the GUI in eclipse. If there is something you need me to do, 
	 * do that. Thanks.
	 */
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
			// linearRegression.nextFrame(deltaX);
		}
		//System.out.println(listOfTimes);
		//System.out.println(deltaX);
	}
}
