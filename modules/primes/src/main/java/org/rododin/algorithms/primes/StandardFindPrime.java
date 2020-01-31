/*
 * StandardFindPrime.java
 */

package org.rododin.algorithms.primes;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class StandardFindPrime
	implements FindPrime
{
	public static final int[] FIRST_PRIMES = new int[] {1, 2, 3, 5, 7};
	public static final int[] NEXT_PRIME_ENDS = new int[] {1, 3, 7, 9};
	public static final int MAX_BASE = 2147483640;

	private int last = 1;
	private int lastBase = 10;
	private int lastOffIdx = 0;

	public int next()
	{
		if (last < FIRST_PRIMES[FIRST_PRIMES.length - 1])
		{
			for (int i = FIRST_PRIMES.length - 2; i >= 0; i--)
			{
				if (last == FIRST_PRIMES[i])
				{
					last = FIRST_PRIMES[i + 1];
					return last;
				}
			}
		}

		for ( ; lastBase < MAX_BASE; lastBase += 10, lastOffIdx = 0)
		{
			for (; lastOffIdx < NEXT_PRIME_ENDS.length; lastOffIdx++)
			{
				final int cand = lastBase + NEXT_PRIME_ENDS[lastOffIdx];
				if (cand > last && Utils.isPrime(cand))
				{
					last = cand;
					return last;
				}
			}
		}

		return 0;
	}
}
