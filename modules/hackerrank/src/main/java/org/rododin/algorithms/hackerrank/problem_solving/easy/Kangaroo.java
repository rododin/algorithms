package org.rododin.algorithms.hackerrank.problem_solving.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/kangaroo/problem">
 *   HackerRank > Practice > Algorithms > Implementation > Kangaroo
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Kangaroo
{
	/**
	 * Implements a trivial and effective solution. The complexity is {@code O(1)}.
	 * The implementation allows even weaker constraints than defined in the original task.
	 *
	 * @param x1 the initial position of the first Kangaroo, {@code x1 ≥ 0}
	 * @param v1 the jump distance of the first Kangaroo, {@code v1 ≥ 0}
	 * @param x2 the initial position of the second Kangaroo, {@code x2 ≥ 0}
	 * @param v2 the jump distance of the second Kangaroo, {@code v2 ≥ 0}
	 * @return {@code "YES"} if two Kangaroos meet at a point after an integer number of jumps, "NO" otherwise
	 */
	public static String kangaroo(int x1, int v1, int x2, int v2)
	{
		return x1 == x2 ? "YES"
		     : v1 == v2 ? "NO"
		     : ((x2 - x1) / (v1 - v2) > 0) && ((x2 - x1) % (v1 - v2) == 0) ? "YES"
		     : "NO";
	}
}
