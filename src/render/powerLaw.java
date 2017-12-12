/*
 * Due to my inability to find proper documentation on how this formula is
 * actually supposed to work I am no longer using it but leaving the code
 * in case I ever discover a fix.
 */



package render;

public class powerLaw extends VRR{
	private double sumLnX;
	//will store summation of natural log of x

	private double sumLnS;
	//will store summation of natural log of s
	
	@SuppressWarnings("unused")
	private double sumLnY;
	//Will store summation of natural log of y
	
	private double n;
	//number of frames being calculated
	
	private double sumLnXSquared;
	//stores SUM(ln x)^2
	
	private double sumXTimesS;
	//stores (SUM(ln x)(ln s))
	
	
	//Sets up array within class to be possibly used anywhere.
	
	/**
	 * 
	 * Maik - I know it seems really petty of me to rag on you having the brackets be under the thing, but PLEASE do not do that. It makes it really hard for me to read your code and 
	 * debug it. It's okay if you don't, but it would make it a lot easier on me when I bug check. 
	 * Thanks,
	 * Ethan
	 * 
	 */
	
	public static void main(String[] args) {
		new powerLaw();
	}
	
	public powerLaw() {
		double[] a = {4, 3, 2, 1};
		function(a);
	}
	/**
	 *You can directly get the list of times from VRR because this extends it in order to use the array within function.
	 *Also, there is no sigma function in java, so you will have to create one. Here is a link that I think might help you.
	 *https://stackoverflow.com/questions/24286713/summation-equation-in-java
	 *
	 */
	
	public void function(double[] array){
		
		/* Power Law Formula
		 * [                                                      ]
		 * |           [                 [(SUM(ln x))(SUM(ln s))]]|
		 * |           |(SUM(ln x)(ln s)-|----------------------|||
		 * |           |                 [          N           ]||
		 * |(SUM(ln x))|-----------------------------------------||   +
		 * |           |                    [(SUM(ln x))^2]      ||
		 * |           |    (SUM((ln x)^2))-|-------------|      ||
		 * |           [                    [      N      ]      ]|
		 * [                                                      ]
		 * 
		 * 
		 * 
		 * if(GameWindow.objList.get(i).getDistance(GameWindow.objList.get(b)) > GameWindow.objList.get(i).getR()) {
					System.out.println("AAAAAAAA");
				}
		 * 
		 * [                                                                     ]
		 * |                         [                  [(SUM(ln x))(SUM(ln s))]]|
		 * |                         |(SUM(ln x))(ln s)-|----------------------|||
		 * |                         |                  [          N           ]||
		 * |(SUM(ln y)) - (SUM(ln x))|------------------------------------------||
		 * |                         |                     [(SUM(ln x))^2]      ||
		 * |                         |     (SUM((ln x)^2))-|-------------|      ||
		 * |                         [                     [      N      ]      ]|
		 * |---------------------------------------------------------------------|
		 * |                                   N                                 |
		 * [                                                                     ]
		 * 
		 * 
		 * s = time interval
		 * x = index of time "s"
		 * N = total number of frames to be calculated or total number of time intervals
		 * y = 
		 */
		
		//will store summation of natural log of x
		sumLnX = 0;
		sumLnS = 0;
		sumLnY = 0;
		n = array.length;
		sumXTimesS  = 0;	
		sumLnXSquared = 0;
		double y = array[0];
		for(int i = 0; i < n; i++){
			double lnS = Math.log(array[i]);
			double lnX = Math.log(i+1);
			double lnXS = lnX * lnS;
			double lnX2 = lnX * lnX;
			sumLnX += lnX;
			sumLnS += lnS;
			sumXTimesS += lnXS;
			sumLnXSquared += lnX2;
			y = recursive(sumLnX, sumLnS, n, sumXTimesS, sumLnXSquared, y);
			if (lnX == 0) {
				y = array[0];
			}
			System.out.println(y);
		}
		//System.out.println(y);
		//System.out.println(Arrays.toString(array));
		//System.out.println(sumLnX + " " + sumLnS +  " " + sumXTimesS);
	}
	public double recursive(double sumLnX, double sumLnS, double n, double sumXTimesS, double sumLnXSquared, double sumY){
		double b = (sumLnX * sumLnS)/n;
		double c = (sumLnX * sumLnX / n);
		double d = sumXTimesS - b;
		double e = sumLnXSquared - c;
		double f = d / e;
		double firstSection = sumLnX * f;
		double secondSection = firstSection / n;
		double y = firstSection - secondSection + (sumY/n);
		return y;
	}
}
