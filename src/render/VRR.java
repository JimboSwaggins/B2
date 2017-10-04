package render;
// Variable Refresh rate
public class VRR {
	public static long lastFPS;
	public static long FPSCounter;
	public static long currSchedule;
<<<<<<< HEAD
	public static long[] listOfTimes;

	
	public static void ping() {
		System.out.println(listOfTimes);
		
=======
	public static long ping() {
		FPSCounter = System.currentTimeMillis();
		currSchedule = FPSCounter - lastFPS;
		//DO YOUR DUMB CALCULUS MEME HERE
		long waitTime = 000;
		return waitTime;
>>>>>>> c58adbd4c7de90ef99c46425a60f637446391012
	}
}
