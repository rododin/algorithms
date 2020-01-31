/*
 * ConnectivityProblem.java
 */

package org.rododin.algorithms.connectivity_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.rododin.algorithms.Constants;
import org.rododin.algorithms.structures.Pair;
import org.rododin.algorithms.structures.Structures;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class ConnectivityProblem
	implements Constants
{
	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			Log.error("Wrong arguments: {}", Arrays.asList(args));
			return;
		}

		final int N;
		final int P;
		try
		{
			N = Integer.parseInt(args[0]);
			P = Integer.parseInt(args[1]);
		}
		catch (NumberFormatException x)
		{
			Log.error("Integer arguments expected: {}", Arrays.asList(args), x);
			return;
		}

		Log.info("Generating random pairs, P={}", P);
		final Random R = new Random();
		final List<Pair<Integer, Integer>> pairs = new ArrayList<>(P);

		for (int i = 0; i < P; i++)
		{
			final int f = R.nextInt(N);
			int s;
			do
			{
				s = R.nextInt(N);
			} while (f == s);

			final Pair<Integer, Integer> pair = Structures.createUnmodifiablePair(f, s);
			pairs.add(pair);
		}

		final List<Pair<Integer, Integer>> uniquePairs = QuickFind.execute(N, pairs);

		final Iterator<Pair<Integer, Integer>> uniquePairsIterator = uniquePairs.iterator();
		Pair<Integer, Integer> uniquePair = null;
		for (int i = 0; i < P; i++)
		{
			final Pair<Integer, Integer> pair = pairs.get(i);
			if (uniquePair == null && uniquePairsIterator.hasNext())
				uniquePair = uniquePairsIterator.next();
			String uniquePairStr = null;
			if (pair.equals(uniquePair))
			{
				uniquePairStr = uniquePair.toString();
				uniquePair = null;
			}
			Log.info("{} -- {}", pair, uniquePairStr != null ? uniquePairStr : "already connected");
		}
	}
}
