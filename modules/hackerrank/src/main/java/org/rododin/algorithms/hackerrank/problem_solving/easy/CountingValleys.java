package org.rododin.algorithms.hackerrank.problem_solving.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/counting-valleys/problem">
 *   HackerRank > Practice > Algorithms > Implementation > Counting Valleys
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CountingValleys
{
	/**
	 * The service method for {@link #countingValleys(int, String)} which prints the given parameters and
	 * the computation result returned by {@link #countingValleys(int, String)}.
	 *
	 * @see #countingValleys(int, String)
	 */
	public static int printCountingValleys(int n, String s)
	{
		final int valleyCount = countingValleys(n, s);
		System.out.println("Valley Count: n=" + n + ", s=" + s + "\n\tvalleyCount=" + valleyCount);
		return valleyCount;
	}

	/**
	 * Implements a very trivial solution.
	 * The complexity is: {@code O(n)}, where {@code n} is the length of the given path {@code s}.
	 *
	 * @param  n the length of the path {@code s}, where <code>2 ≤ n ≤ 10<sup>6</sup></code> (by task statement),
	 *           meanwhile the implementation allows the wider range of <code>0 ≤ n ≤ 2<sup>31</sup>-1</code>.
	 *           This parameter is ignored by the implementation, because in Java it's more consistent to manipulate with
	 *           {@code s.length()} directly.
	 * @param  s the path {@code s} as defined at the task statement, where <code>s<sub>i</sub> ∈ {DU}</code>
	 * @return the count of valleys as defined at the task statement, where <code>0 ≤ returnedValue ≤ n / 2</code>
	 */
	public static int countingValleys(int n, String s)
	{
		int level = 0;
		int valleyCount = 0;
		char c;
		int modifier;
		for (int i = 0; i < s.length(); i++)
		{
			c = s.charAt(i);
			modifier = c == 'D' ? -1 : c == 'U' ? 1 : 0;
			if (level == 0 && modifier == -1)
				valleyCount++;
			level += modifier;
		}
		return valleyCount;
	}
}
