package org.rododin.algorithms.hackerrank.problem_solving.medium;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/bigger-is-greater/problem">
 *   HackerRank > Practice > Algorithms > Implementation > Bigger is Greater
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BiggerIsGreater
{
	/**
	 * Implements probably the most trivial solution, which doesn't look effective though.
	 * The estimated complexity in worst cases may be about <code>O(n^2 + n*lon(n))</code> if we assume the
	 * complexity of the <code>{@link Arrays#sort(char[], int, int)}</code> algorithm ia about <code>O(n*log(n))</code>.
	 * In most worst cases the complexity may be about <code>O(n^2 + n^2)</code>.
	 * <p/>
	 * NOTE: It had been still accepted by the HackerRank acceptance system, i.e. still works in satisfied time even on
	 * heavy test cases they have there.
	 */
	public static String biggerIsGreater(String w)
	{
		final char[] chars = w.toCharArray();
		boolean firstSwapped = false;

		int i;
		for (i = chars.length - 2; i >= 0 && !firstSwapped; )
		{
			for (int j = chars.length - 1; j > i && !firstSwapped; )
			{
				if (chars[j] > chars[i])
				{
					swap(chars, i, j);
					firstSwapped = true;
				}
				else
					j--;
			}
			if (!firstSwapped)
				i--;
		}

		if (firstSwapped)
			Arrays.sort(chars, i + 1, chars.length);

		final String rv = new String(chars);
		return rv.equals(w) ? "no answer" : rv;
	}

	private static void swap(char[] chars, int i, int j)
	{
		final char c = chars[i];
		chars[i] = chars[j];
		chars[j] = c;
	}
}
