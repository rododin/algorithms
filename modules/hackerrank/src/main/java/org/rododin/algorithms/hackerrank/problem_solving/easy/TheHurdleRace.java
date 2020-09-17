package org.rododin.algorithms.hackerrank.problem_solving.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/the-hurdle-race/problem">
 *   Practice > Algorithms > Implementation > The Hurdle Race
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class TheHurdleRace
{
	/**
	 * Implements a trivial and effective solution for computing the number of the potion doses to be taken to pass all
	 * hurdles. The complexity is: {@code O(n)}, where <code>n</code> is {@code heights.size()}.
	 *
	 * @param k       the maximal hurdle height a character may jump over naturally without taking any potion doses,
	 *                <code>0 ≤ k ≤ {@link Integer#MAX_VALUE}</code>
	 *                (the constraints are weaker compared with the original task)
	 * @param heights the hurdle heights, where <code>0 ≤ heights[i] ≤ {@link Integer#MAX_VALUE}</code> and
	 *                <code>0 ≤ heights.size() ≤ {@link Integer#MAX_VALUE}</code>
	 *                (the constraints are also weaker compared with the original task)
	 * @return        the number of potion doses to be taken to pass all the hurdles
	 */
	public static int hurdleRace(int k, int[] heights)
	{
		int maxHurdleHeight = 0;
		for (int h : heights)
		{
			if (h > maxHurdleHeight)
				maxHurdleHeight = h;
		}
		final int d = maxHurdleHeight - k;
		return d < 0 ? 0 : d;
	}
}
