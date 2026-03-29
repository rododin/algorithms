package org.rododin.algorithms.utils;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * Extends the standard {@link Math} API with some useful function implementation like
 * {@link #log2(double) binary logarithm} or {@link #fact(long) factorial}.
 *
 * @author Nikolay Chebotaryov
 */
public abstract class MathX
{
	/**
	 * Computes and returns the binary logarithm of {@code n}.
	 */
	public static double log2(double n)
	{
		return Math.log(n) / Math.log(2);
	}

	/**
	 * Computes and returns the factorial of {@code n} as {@link BigInteger}.
	 */
	public static BigInteger fact(long n)
	{
		return n < 2 ? BigInteger.valueOf(1) : LongStream.rangeClosed(2, n).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
	}

	/**
	 * Computes and returns the factorial of {@code n} converting it to {@code long}.
	 * <p>NOTE: If the computed value is too big, the only lowest 64 bits are returned.
	 * See {@link BigInteger#longValue()} for more details.
	 */
	public static long factToLong(long n)
	{
		return fact(n).longValue();
	}

	/**
	 * Computes and returns the factorial of {@code n} converting it to {@code double}.
	 * <p>NOTE: The computation precision may be very rough especially for big numbers. Also if the computed value is too
	 * big, the {@link Double#POSITIVE_INFINITY} will be returned.
	 * See {@link BigInteger#doubleValue()} for more details.
	 */
	public static double factToDouble(long n)
	{
		return fact(n).doubleValue();
	}
}

