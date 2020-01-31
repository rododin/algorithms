/*
 * QuickFind.java
 */

package org.rododin.algorithms.connectivity_problem;

import java.util.LinkedList;
import java.util.List;

import org.rododin.algorithms.structures.Pair;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public final class QuickFind
{
	/**
	 * Executes the Quick Find algorithm to solve the Connectivity Problem.
	 * @param N The size of a buffer array created by the algorithm to do the job.
	 * @param pairs The pairs of connected integer numbers to handle. Please note, the maximal integer value in a pair should be greater or equal to 0, and less than N.
	 * @return The filtered list of the pairs where the pairs represent unique connections according the the rule of transitivity.
	 */
	public static List<Pair<Integer, Integer>> execute(int N, List<Pair<Integer, Integer>> pairs)
	{
		final List<Pair<Integer, Integer>> rv = new LinkedList<Pair<Integer, Integer>>();
		int id[] = new int[N];
		for (int i = 0; i < N ; i++)
			id[i] = i;

		for(Pair<Integer, Integer> pair : pairs)
		{
			final int p = pair.getFirst();
			final int q = pair.getSecond();

			final int t = id[p];

			if (t == id[q])
				continue;

			for (int i = 0; i < N; i++)
			{
				if (id[i] == t)
					id[i] = id[q];
			}

			rv.add(pair);
		}

		return rv;
	}
}
