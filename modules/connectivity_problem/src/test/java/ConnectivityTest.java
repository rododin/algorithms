/*
 * ConnectivityTest.java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.rododin.algorithms.connectivity_problem.QuickFind;
import org.rododin.algorithms.measure.Period;
import org.rododin.algorithms.structures.Pair;
import org.rododin.algorithms.structures.Structures;

/**
 * Description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
@RunWith(JUnit4.class)
public class ConnectivityTest
{
	@Test
	public void testQuickFind()
	{
		doQuickFindTest(new int[][]
			{
				{5, 2, 1},
				{2, 0, 1},
				{8, 5, 1},
				{0, 8, 0},
				{8, 2, 0},
				{7, 5, 1},
				{9, 2, 1},
				{0, 3, 1},
				{4, 5, 1},
				{8, 9, 0},
			});

		doQuickFindTest(new int[][]
			{
				{5, 1, 1},
				{7, 0, 1},
				{7, 2, 1},
				{4, 1, 1},
				{4, 1, 0},
				{4, 2, 1},
				{9, 4, 1},
				{4, 3, 1},
				{4, 2, 0},
				{2, 0, 0},
			});

		doQuickFindTest(new int[][]
			{
				{ 7,  2, 1},
				{13, 11, 1},
				{13,  7, 1},
				{17, 16, 1},
				{11, 10, 1},
				{ 9,  7, 1},
				{ 1,  4, 1},
				{10,  4, 1},
				{14,  7, 1},
				{ 9,  7, 0},
				{ 9,  7, 0},
				{10, 11, 0},
				{11,  0, 1},
				{13, 15, 1},
				{ 4, 17, 1},
				{16,  3, 1},
				{ 6,  5, 1},
				{ 2,  7, 0},
				{10,  5, 1},
				{18, 19, 1},
			});
	}

	private static void doQuickFindTest(int[][] pairs)
	{
		int N = 0;
		final int P = pairs.length;

		final List<Pair<Integer, Integer>> initPairs   = new ArrayList<>(P);
		final List<Pair<Integer, Integer>> uniquePairs = new ArrayList<>(P);

		for (int[] pair : pairs)
		{
			Assert.assertTrue(pair.length == 3);
			final int first  = pair[0]; Assert.assertTrue(first  >= 0);
			final int second = pair[1]; Assert.assertTrue(second >= 0);
			final boolean unique = pair[2] != 0;
			final Pair<Integer, Integer> pairObj = Structures.createUnmodifiablePair(first, second);
			initPairs.add(pairObj);
			if (unique)
				uniquePairs.add(pairObj);

			if (first  > N) N = first;
			if (second > N) N = second;
		}
		N++;

		final List<Pair<Integer, Integer>> foundPairs = QuickFind.execute(N, initPairs);

		//System.out.println("initPairs  =" + initPairs  );
		//System.out.println("uniquePairs=" + uniquePairs);
		//System.out.println("foundPairs =" + foundPairs );

		Assert.assertTrue(uniquePairs.equals(foundPairs));
	}
}
