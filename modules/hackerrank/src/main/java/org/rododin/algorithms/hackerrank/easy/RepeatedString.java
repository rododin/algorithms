/*
 * RepeatedString.java
 */

package org.rododin.algorithms.hackerrank.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/repeated-string/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Repeated String
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class RepeatedString
{
	public static long printRepeatedString(String s, long n)
	{
		final long rv = repeatedString(s, n);
		System.out.printf("%s, %d -> %d\n", s, n, rv);
		return rv;
	}

	public static long repeatedString(String s, long n)
	{
		if (s.length() == 0)
			return 0;
		final long fullRepeatedStringCount = n / s.length();
		final int lastSubstringLength = (int)(n % s.length());
		final int aCountInLastSubstring = countChars(s, 0, lastSubstringLength);
		final int aCount = aCountInLastSubstring + countChars(s, lastSubstringLength, s.length());
		return fullRepeatedStringCount * aCount + aCountInLastSubstring;
	}

	private static int countChars(String s, int from, int till)
	{
		int count = 0;
		for (int i = from; i < till; i++)
		{
			if (s.charAt(i) == 'a')
				count++;
		}
		return count;
	}
}
