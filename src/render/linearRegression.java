package render;

import java.util.ArrayList;

public class linearRegression {

	public static int nextFrame(ArrayList<Long> deltaX) {
		int n = deltaX.length();
		int sumX = 0;
		int sumY = 0;
		int sumXY = 0;
		int sumX2 = 0;
		for(int i = 0; i < n; i++) {
			sumX += i;
			sumY += deltaX[i];
			sumXY += i*deltaX[i];
			sumX2 += i * i;
		}
		double a = (((sumY * sumX2) - (sumX * sumXY))) / ((n * sumX2) - (sumX * sumX));
		double b = (((n * sumXY) - (sumX * sumY))) / ((n * sumX2) - (sumX * sumX));
		int c = (int) Math.round((b * (n + 1)) + a);
		return c;
	}
}
