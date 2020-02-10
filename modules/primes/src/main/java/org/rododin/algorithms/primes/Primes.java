/*
 * Primes.java
 */

package org.rododin.algorithms.primes;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Primes
{
// The Main Routine ----------------------------------------------------------------------------------------------------

	public static void main(String[] args)
	{
		final StandardFindPrime standardFindPrime = new StandardFindPrime();

		int num;
		while ((num = standardFindPrime.next()) <= 10870)
		{
			System.out.println(num);
		}
	}
}

