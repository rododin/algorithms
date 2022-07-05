/*
 * CutTheSticks.java
 */

package org.rododin.algorithms.hackerrank.problem_solving.easy;

import java.util.Collections;
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
	 * <p/>
	 * NOTE:
	 *   The complexity is {@code O(n + O(standardJavaIntegerListSortAlgorithm))}. This solution is pretty effective.
	 *   It doesn't introduce any additional constraints compared with the recursive {@link #cutTheSticksRecursive(List, List)} algorithm.
	 *   It passed well all the HackerRank tests and was accepted.
	 *
	 * @param arr non-<code>null</code> list of the stick lengths to be cut.
	 * @return empty list if the given {@code arr} is empty,
	 *         or a singleton list of {@code 1} if the given {@code arr} size is 1,
	 *         or a list of numbers of sticks processed on each iteration according to the task definition
	 */
	public static List<Integer> cutTheSticks(List<Integer> arr)
	{
		final List<Integer> result = new LinkedList<>();

		if (arr.size() == 0)
			return result;
		result.add(arr.size());

		Collections.sort(arr);

		int curLength = arr.get(0);
		for (int i = 0; i < arr.size(); i++)
		{
			if (arr.get(i) > curLength)
			{
				curLength = arr.get(i);
				result.add(arr.size() - i);
			}
		}
		return result;
	}

	/**
	 * Implements a solution for the <a href="https://www.hackerrank.com/challenges/cut-the-sticks/problem">Cut the sticks</a>
	 * problem in recursive way. The complexity is {@code O(2n(n-1))}. Thus, the solution is not effective.
	 * Also, the recursion introduces additional constraints disallowing to handle too huge input arrays.
	 * However it still passed all the HackerRank tests and was accepted.
	 *
	 * @param arr non-<code>null</code> list of the stick lengths to be cut.
	 * @param result the list to store the produced results. It remains empty if the given {@code arr} is empty,
	 *               or it becomes a singleton list of {@code 1} if the given {@code arr} size is 1,
	 *               or it becomes a list of numbers of sticks processed on each iteration according to the task definition
	 * @throws StackOverflowError on too huge {@code arr} given (e.g. 1 million of elements)
	 */	private static void cutTheSticksRecursive(List<Integer> arr, List<Integer> result)
	{
		if (arr.size() == 0)
			return;
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
			cutTheSticksRecursive(nextIteration, result);
	}
}
