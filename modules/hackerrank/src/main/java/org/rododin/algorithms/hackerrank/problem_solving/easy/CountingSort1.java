package org.rododin.algorithms.hackerrank.problem_solving.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/countingsort1/problem">
 *   HackerRank > Practice > Algorithms > Sorting > Counting Sort 1
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CountingSort1
{
	/**
	 * A shortcut method for {@link #countingSort(int[], int)} which passes {@code 99} for the {@code maxArrValue}.
	 * Thus it provides the API of the method from the original task where {@code}0 ≤ arr[i] < 100}.
	 */
	public static int[] countingSort(int[] arr)
	{
		return countingSort(arr, 99);
	}

	/**
	 * Implements a very trivial and effective solution.
	 * The complexity is <code>O(n)}</code>, where <code>n</code> is {@code arr.size()}.
	 *
	 * @param arr         an array of integers, where {@code}0 ≤ arr[i] ≤ maxArrValue} and
	 *                    <code>0 ≤ arr.size() ≤ {@link Integer#MAX_VALUE}</code>
	 *                    (the constraints are also weaker compared with the original task)
	 * @param maxArrValue the maximal value of an element in {@code arr}, where
	 *                    <code>0 ≤ maxArrValue ≤ {@link Integer#MAX_VALUE} - 1</code>
	 *                    (the constraints are weaker compared with the original task, but note,
	 *                    the maximal value of {@code maxArrValue} also depends on the memory available)
	 * @return            the array of {@code maxArrValue + 1} size where each element represents a counter of
	 *                    appropriate value in the given {@code arr} (see the original task for more details)
	 */
	public static int[] countingSort(int[] arr, int maxArrValue)
	{
		final int[] rv = new int[maxArrValue+1];
		for (int a : arr)
			rv[a]++;
		return rv;
	}
}
