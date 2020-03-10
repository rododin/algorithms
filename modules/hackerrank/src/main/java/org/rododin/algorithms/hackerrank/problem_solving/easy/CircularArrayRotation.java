package org.rododin.algorithms.hackerrank.problem_solving.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/circular-array-rotation/problem">
 *   HackerRank > Practice > Algorithms > Implementation > Circular Array Rotation
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CircularArrayRotation
{
	/**
	 * Implements an effective <code>O(q)</code> complexity solution, where <code>q</code> is the size of the given
	 * <code>queries</code> array, i.e. there're no iterations over the given <code>a</code> array at all.
	 */
	public static int[] circularArrayRotation(int[] a, int k, int[] queries)
	{
		final int[] responses = new int[queries.length];
		if (a.length == 0 || queries.length == 0)
			return responses;
		final int offset = k % a.length;
		int i = 0;
		for (int query : queries)
			responses[i++] = circularArrayRotation(a, offset, query);
		return responses;
	}

	private static int circularArrayRotation(int[] a, int offset, int query)
	{
		int i = query - offset;
		if (i < 0)
			i += a.length;
		return a[i];
	}
}
