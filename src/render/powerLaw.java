package render;

public class powerLaw {
	long[] listOfTimes;
	int x;
	//Sets up array within class to be possibly used anywhere.
	public void function(double[] array)
	{
		listOfTimes = array;
		//In order to use array within function.
		
		
		
		/* Power Law Formula
		 * [                                                      ]
		 * |           [                 [(SUM(ln x))(SUM(ln s))]]|
		 * |           |(SUM(ln x)(ln s))-|----------------------|||
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
		 * |                         |(SUM(ln x)(ln s))-|----------------------|||
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
		double sumLnX = 0;
			//will store summation of natural log of x
		double sumLnS = 0;
		//will store summation of natural log of s
		double sumLnY = 0;
			//I have yet to determine what y is
		int n = array.length;
			//number of frames being calculated
		double sumXTimesS  = 0;
			//stores (SUM(ln x)(ln s))
		double sumLnXSquared = 0;
			//stores SUM(ln x)^2
		for(int i = 0; i < n; i++)
		{
			double lnS = Math.log(array[i]);
			double lnX = Math.log(i);
			double lnXS = lnX * lnS;
			sumLnX += lnX;
			sumLnS += lnS;
			sumXTimesS += lnXS;
			
		}
		
	}
}
