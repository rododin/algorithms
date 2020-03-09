/*
 * AppleAndOrange.java
 */

package org.rododin.algorithms.hackerrank.problem_solving.easy;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/apple-and-orange/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Apple and Orange
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class AppleAndOrange
{
	public static int[] printCountApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges)
	{
		final int[] rv = countApplesAndOranges(s, t, a, b, apples, oranges);
		Arrays.stream(rv).forEach(System.out::println);
		return rv;
	}

	public static int[] countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges)
	{
		int appleHouseIntersection = 0;
		for (int apple : apples)
		{
			if (a + apple >= s && a + apple <= t)
				appleHouseIntersection++;
		}

		int orangeHouseIntersection = 0;
		for (int orange : oranges)
		{
			if (b + orange >= s && b + orange <= t)
				orangeHouseIntersection++;
		}

		return new int[] {appleHouseIntersection, orangeHouseIntersection};
	}
}
