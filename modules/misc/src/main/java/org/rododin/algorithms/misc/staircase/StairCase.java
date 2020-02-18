/*
 * StairCase.java
 */

package org.rododin.algorithms.misc.staircase;

/**
 * <a href="https://www.hackerrank.com/challenges/staircase/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Staircase
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class StairCase
{
	public static void printStairCase(int n)
	{
		System.out.println(stairCase(n));
	}

	public static String stairCase(int n)
	{
		final StringBuilder sb = new StringBuilder((n + 1) * n);
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (j < n - 1 - i)
					sb.append(' ');
				else
					sb.append('#');
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}
