/*
 * BirthdayCakeCandles.java
 */

package org.rododin.algorithms.misc.birthday_cake_candles;

/**
 * <a href="https://www.hackerrank.com/challenges/birthday-cake-candles/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Birthday Cake Candles
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BirthdayCakeCandles
{
	public static void printBirthdayCakeCandles(int[] array)
	{
		System.out.println(birthdayCakeCandles(array));
	}

	public static int birthdayCakeCandles(int[] array)
	{
		// The complexity: O(n) = n

		int max = Integer.MIN_VALUE;
		int maxCount = 0;
		for (int e : array)
		{
			if (e == max)
				maxCount++;
			else if (e > max)
			{
				max = e;
				maxCount = 1;
			}
		}

		return maxCount;
	}
}
