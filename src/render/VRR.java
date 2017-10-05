package render;

import java.util.ArrayDeque;
import java.util.Deque;

// Variable Refresh rate
public class VRR {
	public static long lastFPS;
	public static long FPSCounter;
	public static long currSchedule;
	public static Deque<Long> h;
	public static void ping() {
		h.addFirst((long) 12312);
		
	}
}
