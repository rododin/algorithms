/*
 * CutTheSticks.java
 */

package org.rododin.algorithms.hackerrank.problem_solving.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/cut-the-sticks/problem">
 *   HackerRank > Practice > Algorithms > Implementation > Cut the sticks
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CutTheSticks
{
	/**
	 * Implements a solution for the <a href="https://www.hackerrank.com/challenges/cut-the-sticks/problem">Cut the sticks</a> problem.
	 * The method signature is precisely the same as provided in the HackerRank code template.
	 * Internally it passes the job to the other recursive {@link #cutTheSticks(List, List)} method.
	 * <p/>
	 * NOTE:
	 *   The complexity is {@code O(2n(n-1))}. Thus, the solution is not effective.
	 *   Also, the recursion introduces additional constraints disallowing to handle too huge input arrays.
	 *   However it still passed all the HackerRank tests and was accepted.
	 *
	 * @param arr non-<code>null</code> list of the stick lengths to be cut.
	 * @return empty list if the given {@code arr} is empty,
	 *         or a singleton list of {@code 1} if the given {@code arr} size is 1,
	 *         or a list of numbers of sticks processed on each iteration according to the task definition
	 */
	public static List<Integer> cutTheSticks(List<Integer> arr)
	{
		final List<Integer> rv = new LinkedList<>();
		cutTheSticks(arr, rv);
		return rv;
	}

	private static void cutTheSticks(List<Integer> arr, List<Integer> result)
	{
		if (arr.size() > 0)
			result.add(arr.size());

		final List<Integer> nextIteration = new LinkedList<>();
		int min = Integer.MAX_VALUE;
		for (Integer e : arr)
		{
			if (min > e)
				min = e;
		}
		for (Integer e : arr)
		{
			if (e > min)
				nextIteration.add(e - min);
		}
		if (nextIteration.size() > 0)
			cutTheSticks(nextIteration, result);
	}
}
