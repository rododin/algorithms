/*
 * ExtraLongFactorials.java
 */

package org.rododin.algorithms.hackerrank.medium;

import java.math.BigInteger;

/**
 * <a href="https://www.hackerrank.com/challenges/extra-long-factorials/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Extra Long Factorials
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class ExtraLongFactorials
{
	public static BigInteger printExtraLongFactorials(int n)
	{
		final BigInteger rv = extraLongFactorials(n);
		System.out.println(n + "! = " + rv);
		return rv;
	}

	public static BigInteger extraLongFactorials(int n)
	{
		BigInteger bi = new BigInteger("1");
		for (int i = 2; i <= n; i++)
			bi = bi.multiply(new BigInteger("" + i));
		return bi;
	}
}
