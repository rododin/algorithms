/*
 * PlusMinus.java
 */

package org.rododin.algorithms.hackerrank.problem_solving.easy;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/plus-minus/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Plus Minus
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class PlusMinus
{
	public static void printPlusMinus(int[] array)
	{
		for (double d : plusMinus(array))
			System.out.printf("%.8f\n", d);
	}

	public static double[] plusMinus(int[] array)
	{
		int pSum = 0, nSum = 0, zSum = 0;
		for (int e : array)
		{
			if (e > 0)
				pSum++;
			else if (e < 0)
				nSum++;
			else
				zSum++;
		}
		return new double[]
		{
			((double)pSum) / array.length,
			((double)nSum) / array.length,
			((double)zSum) / array.length
		};
	}
}
