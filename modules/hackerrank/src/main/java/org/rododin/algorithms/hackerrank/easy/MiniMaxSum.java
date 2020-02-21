/*
 * MiniMaxSum.java
 */

package org.rododin.algorithms.hackerrank.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/mini-max-sum/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Mini-Max Sum
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class MiniMaxSum
{
	public static void printMiniMaxSum(int[] array)
	{
		System.out.println(miniMaxSum(array).stream().map(Object::toString).collect(Collectors.joining(" ")));
	}

	public static List<Long> miniMaxSum(int[] array)
	{
		int min = array.length > 0 ? Integer.MAX_VALUE : 0;
		int max = array.length > 0 ? Integer.MIN_VALUE : 0;
		long sum = 0;
		int e;
		for (int i = 0; i < array.length; i++)
		{
			e = array[i];
			sum += e;
			if (min > e)
				min = e;
			if (max < e)
				max = e;
		}
		return Arrays.asList(sum - max, sum - min);
	}
}
