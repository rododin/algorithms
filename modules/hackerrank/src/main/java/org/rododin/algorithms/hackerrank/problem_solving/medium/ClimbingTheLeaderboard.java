package org.rododin.algorithms.hackerrank.problem_solving.medium;

/**
 * <a href="https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem">
 *   Practice > Algorithms > Implementation > Climbing the Leaderboard
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class ClimbingTheLeaderboard
{
	/**
	 * Implements the problem solution.
	 * The complexity is: <code>O(n + m * log(n))</code>, where <code>n</code> is the size/length of the <code>scores</code>
	 * array, and <code>m</code> is the size/length of the <code>alice</code> array.
	 * In other words, we compute the places for the given <code>scores</code>, it's just <code>O(n)</code>. And then
	 * we do a binary search over <code>scores</code> (which is <code>O(log(n))</code>) for each element from <code>alice</code>.
	 */
	public static int[] climbingLeaderboard(int[] scores, int[] alice)
	{
		final int[] places = findPlaces(scores);
		final int[] alicePositions = new int[alice.length];
		int j = 0;
		for (int aliceScore : alice)
			alicePositions[j++] = findPlace(scores, places, aliceScore);
		return alicePositions;
	}

	/**
	 * Computes the place for the given <code>aliceScore</code>, executed once per each Alice's score.
	 * The complexity is: <code>O(1)</code>.
	 */
	public static int findPlace(int[] scores, int[] places, int aliceScore)
	{
		if (scores.length == 0)
			return 1;
		final int aliceIndex = binarySearchInDescendingArray(scores, aliceScore);
		if (aliceIndex >= places.length)
			return places[aliceIndex-1] + 1;
		return places[aliceIndex];
	}

	/**
	 * Computes <code>places</code> for the given scores. It's executed only once.
	 * The complexity is: <code>O(n)</code>.
	 */
	public static int[] findPlaces(int[] scores)
	{
		final int[] places = new int[scores.length];
		int place = 0;
		int lastScore = Integer.MAX_VALUE;
		for (int i = 0; i < scores.length; i++)
		{
			if (scores[i] < lastScore)
			{
				lastScore = scores[i];
				place++;
			}
			places[i] = place;
		}
		return places;
	}

	/**
	 * A typical binary search, but for the reverse-ordered <code>array</code>.
	 * It's used to compute the index of the current Alice's score in the reverse-ordered <code>scores</code> array,
	 * executed once per each Alice's score appropriately.
	 * The complexity is: <code>O(log(n))</code>.
	 */
	public static int binarySearchInDescendingArray(int[] array, int value)
	{
		int low = array.length - 1;
		int high = 0;
		while (low >= high)
		{
			int mid = (low + high) >>> 1;
			int midVal = array[mid];

			if (midVal < value)
				low = mid - 1;
			else if (midVal > value)
				high = mid + 1;
			else
				return mid;
		}
		return (low + 1);
	}
}
