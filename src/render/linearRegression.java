package render;

	public static int nextFrame(int[] array) {
		int n = array.length;
		double sumX = 0;
		double sumY = 0;
		double sumXY = 0;
		double sumX2 = 0;
		for(int i = 0; i < n; i++) {
			sumX += i + 1;
			sumY += array[i];
			sumXY += (i + 1)*array[i];
			sumX2 += (i + 1) * (i + 1);
		}
		double a = (((sumY * sumX2) - (sumX * sumXY))) / ((n * sumX2) - (sumX * sumX));
		double b = (((n * sumXY) - (sumX * sumY))) / ((n * sumX2) - (sumX * sumX));
		int c = (int) Math.round((b * (n + 1)) + a);
		System.out.println((a + " " + b));
		System.out.println(c);
		return c;
	}
}
