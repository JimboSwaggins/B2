package render;

public class powerLaw {
	long[] listOfTimes;
	int x;
	//Sets up array within class to be possibly used anywhere.
	public void function(long[] array)
	{
		listOfTimes = array;
		//In order to use array within function.
		
		
		
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
	}
}
