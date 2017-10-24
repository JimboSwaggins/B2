package render;

public class linearRegression {

	public static int nextFrame(int[] array) {
		int n = array.length;
		int sumX = 0;
		int sumY = 0;
		int sumXY = 0;
		int sumX2 = 0;
		for(int i = 0; i < n; i++) {
			sumX += i;
			sumY += array[i];
			sumXY += i*array[i];
			sumX2 += i * i;
		}
		double a = (((sumY * sumX2) - (sumX * sumXY))) / ((n * sumX2) - (sumX * sumX));
		double b = (((n * sumXY) - (sumX * sumY))) / ((n * sumX2) - (sumX * sumX));
		int c = (int) Math.round((b * (n + 1)) + a);
		return c;
	}
}
