/*
 * DayOfTheProgrammer.java
 */

package org.rododin.algorithms.hackerrank.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/day-of-the-programmer/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Day of the Programmer
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class DayOfTheProgrammer
{
	public static void printDayOfProgrammer(int year)
	{
		System.out.println(dayOfProgrammer(year));
	}

	public static String dayOfProgrammer(int year)
	{
		if (year < 1700 || year > 2700)
			throw new IllegalArgumentException("Unsupported year: " + year + ", expected: 1700 ≤ year ≤ 2700");

		if (year == 1918)
			return "26.09.1918";
		else
		{
			if (year % 4 == 0)
			{
				if (year < 1918)
					return "12.09." + year;
				else
				{
					if (year % 400 == 0)
						return "12.09." + year;
					else if (year % 100 == 0)
						return "13.09." + year;
					else
						return "12.09." + year;
				}
			}
			else
				return "13.09." + year;
		}
	}
}
