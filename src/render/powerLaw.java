package render;

import java.util.Arrays;

public class powerLaw extends VRR{
	//Sets up array within class to be possibly used anywhere.\
	public static void main(String[] args) {
		double[] a = {1, 2, 3, 4};
		function(a);
	}
	public static double recursive()
	{
		double b = (sumLnX * sumLnS)/n;
		double c = (sumLnX * sumLnX / n);
		double d = sumXTimesS - b;
		double e = sumLnXSquared - c;
		double f = d / e;
		double firstSection = sumLnX * f;
		double secondSection = firstSection / n;
		double y = firstSection - secondSection;
		return y;
	}
	public static void function(double[] array)
	{
		
		//You can directly get the list of times from VRR because this extends it.
		//In order to use array within function.
		//There is no sigma function in java, so you will have to create one. Here is a link that I think might help you.
		//https://stackoverflow.com/questions/24286713/summation-equation-in-java
		

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
		
		@SuppressWarnings("unused")
		double sumLnX = 0;
			//will store summation of natural log of x
		@SuppressWarnings("unused")
		double sumLnS = 0;
		//will store summation of natural log of s
		@SuppressWarnings("unused")
		double sumLnY = 0;
			//I have yet to determine what y is
		double n = array.length;
			//number of frames being calculated
		@SuppressWarnings("unused")
		double sumXTimesS  = 0;
			//stores (SUM(ln x)(ln s))
		@SuppressWarnings("unused")
		double sumLnXSquared = 0;
			//stores SUM(ln x)^2
		
		for(int i = 0; i < n; i++)
		{
			double lnS = Math.log(array[i]);
			double lnX = Math.log(i+1);
			double lnXS = lnX * lnS;
			double lnX2 = lnX * lnX;
			sumLnX += lnX;
			sumLnS += lnS;
			sumXTimesS += lnXS;
			sumLnXSquared += lnX2;
			
		}
		double y = recursive();
		System.out.println(y);
		System.out.println(Arrays.toString(array));
		//System.out.println(sumLnX + " " + sumLnS +  " " + sumXTimesS);
	}
}
