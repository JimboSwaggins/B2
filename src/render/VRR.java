package render;

import java.util.ArrayDeque;
import java.util.Deque;

// Variable Refresh rate
public class VRR {
	public static long currentTime;
	public static Deque<Long> listOfTimes = new ArrayDeque<Long>();
	
	public static void ping() {
		currentTime = (long) System.currentTimeMillis();
		listOfTimes.push(currentTime);
		System.out.println(listOfTimes);
		if(listOfTimes.size() >= 5) {
			listOfTimes.removeLast();
		}
	}
}
