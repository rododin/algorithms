package org.rododin.algorithms.hackerrank.problem_solving.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/strange-code/problem">
 *   HackerRank >  Practice > Algorithms > Implementation > Strange Counter
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class StrangeCounter
{
	/**
	 * Implements a trivial and effective solution for computing the strange counter value.
	 * The complexity is: <code>O(log<sub>2</sub>(t/3))</code>, where <code>t</code> is the given time value.
	 *
	 * @param t the given time value to compute the counter for, <code>1 ≤ t ≤ 10<sup>12</sup></code>
	 * @return the computed strange counter value
	 */
	public static long strangeCounter(long t)
	{
		long base = 0;
		for (long pow2 = 1; base < t; pow2 <<= 1)
			base += pow2 * 3;
		return base + 1 - t;
	}
}
