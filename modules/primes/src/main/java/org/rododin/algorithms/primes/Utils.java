/*
 * Utils.java
 */

package org.rododin.algorithms.primes;

import java.util.Collection;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Utils
{
	public static final int[] FIRST_PRIMES = new int[] {2, 3, 5, 7};
	public static final int[] NEXT_PRIME_ENDS = new int[] {1, 3, 7, 9};

	public static boolean isPrime(int number)
	{
		//if (number <= 0)
		//  return false;
		//if (number == 1)
		//  return false;

		for (int div : FIRST_PRIMES)
		{
			if (number % div == 0)
				return false;
		}

		final int max = (int)Math.sqrt(number);
		for (int base = 10; base <= max; base += 10)
		{
			for (int off : NEXT_PRIME_ENDS)
			{
				if (number % (base + off) == 0)
					return false;
			}
		}

		return true;
	}

	public static boolean isPrime(int number, Collection<Integer> knownPrimes)
	{
		//if (number <= 0)
		//  return false;
		//if (number == 1)
		//  return false;

		final int max = (int)Math.sqrt(number);
		for (int div : knownPrimes)
		{
			if (div > max)
				break;
			if (number % div == 0)
				return false;
		}
		return true;
	}
}
