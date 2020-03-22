package org.rododin.algorithms.hackerrank.problem_solving.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem">
 *   HackerRank > Practice > Algorithms > Implementation > Jumping on the Clouds: Revisited
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JumpingOnTheClouds
{
	/**
	 * Implements a quite trivial and effective solution.
	 * Assuming {@code n} is the size (aka length) of the given {@code c} array the complexity is:
	 * <p/><ul>
	 *   <li>{@code O(n / k)} if {@code n % k = 0}</li>
	 *   <li>{@code O(n)} if {@code n % k ≠ 0}</li>
	 * </ul>
	 * <p/> NOTE: The method doesn't check any constraints. If they are violated, the result is undefined.
	 *
	 * @param c non-{@code null} {@code int} array instance where {@code c[i] ∈ {0, 1}}, {@code c.length = n}, {@code 2 ≤ n ≤ 25}
	 * @param k the jump length, {@code 1 ≤ k ≤ n}
	 * @return the value of the energy {@code e} remained after jumping, {@code 0 ≤ e ≤ 100} if the constraints provided,
	 *         otherwise the result is undefined
	 */
	public static int jumpingOnClouds(int[] c, int k)
	{
		if (c.length % k == 0)
		{
			int e = 100;
			for (int i = 0; i < c.length; i += k)
				e -= c[i] == 1 ? 3 : 1;
			return e;
		}
		else
		{
			int tc = 0;
			for (final int ci: c)
			{
				if (ci == 1)
					tc++;
			}
			return 100 - (tc * k + (c.length - tc));
		}
	}
}
