package render;
// Variable Refresh rate
public class VRR {
	public static long lastFPS;
	public static long FPSCounter;
	public static long currSchedule;
	public static long ping() {
		FPSCounter = System.currentTimeMillis();
		currSchedule = FPSCounter - lastFPS;
		//DO YOUR DUMB CALCULUS MEME HERE
		long waitTime = 000;
		return waitTime;
	}
}
