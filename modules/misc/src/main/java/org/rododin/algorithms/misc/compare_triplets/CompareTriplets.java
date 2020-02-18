/*
 * CompareTriplets.java
 */

package org.rododin.algorithms.misc.compare_triplets;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/compare-the-triplets/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Compare the Triplets
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CompareTriplets
{
	public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b)
	{
		int ar = 0, br = 0;
		final Iterator<Integer> ai = a.iterator();
		final Iterator<Integer> bi = b.iterator();
		while (ai.hasNext() && bi.hasNext())
		{
			final Integer ae = ai.next();
			final Integer be = bi.next();
			final int r = ae.compareTo(be);
			if (r > 0)
				ar++;
			else if (r < 0)
				br++;
		}
		return Arrays.asList(ar, br);
	}
}
