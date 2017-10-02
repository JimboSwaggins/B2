package render;
// Variable Refresh rate
public class VRR {
	private static int frameCount = 0;
	public static double[] pastFrames;
	public double currentTime;
	public static void ping() {
		for(int i = 1; i <= pastFrames.length())
		frameCount ++;
	}
}
