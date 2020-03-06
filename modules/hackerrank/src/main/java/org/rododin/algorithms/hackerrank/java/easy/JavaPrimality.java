package org.rododin.algorithms.hackerrank.java.easy;

import java.math.BigInteger;

/**
 * <a href="https://www.hackerrank.com/challenges/java-primality-test/problem">
 *   HackerRank > Practice > Java BigNumber > Java Primality Test
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaPrimality
{
	public static String printIsProbablePrime(String bigInteger)
	{
		final boolean rv = isProbablePrime(bigInteger);
		final String strRV = (rv ? "" : "not ") + "prime";
		System.out.println(bigInteger + " -> " + strRV);
		return strRV;
	}

	public static boolean isProbablePrime(String bigInteger)
	{
		return new BigInteger(bigInteger).isProbablePrime(20);
	}
}
