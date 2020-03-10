package org.rododin.algorithms.hackerrank.problem_solving.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/find-digits/problem">
 *   HackerRank > Practice > Algorithms > Implementation > Find Digits
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class FindDigits
{
	/**
	 * A quite trivial, but probably not most-effective solution, based on Java Strings API.
	 */
	public static int findDigits(int n)
	{
		final String s = Integer.toString(n);
		int count = 0;
		for (int d, i = 0; i < s.length(); i++)
		{
			d = Integer.parseInt(s.substring(i, i + 1));
			if (d != 0 && n % d == 0)
				count++;
		}
		return count;
	}
}
