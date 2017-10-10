package render;

public class powerLaw extends VRR{
	//Sets up array within class to be possibly used anywhere.
	public void function(double[] array)
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
		int n = array.length;
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
			double lnX = Math.log(i);
			double lnXS = lnX * lnS;
			sumLnX += lnX;
			sumLnS += lnS;
			sumXTimesS += lnXS;
			
		}
		
	}
}
