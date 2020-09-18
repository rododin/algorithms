package org.rododin.algorithms.hackerrank.problem_solving.easy;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/tutorial-intro/problem">
 *   HackerRank > Practice > Algorithms > Sorting > Intro to Tutorial Challenges
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class IntroToTutorialChallenges
{
	/**
	 * Implements a very trivial and effective solution using the binary search algorithm available
	 * in the Standard Java library.
	 * The complexity is <code>O(log<sub>2</sub>n)}</code>, where <code>n</code> is {@code arr.size()}.
	 *
	 * @param V   the integer to be find in {@code arr}, where {@code V ∈ arr}
	 *            (the constraints are weaker compared with the original task)
	 * @param arr a sorted array of integers, where
	 *            <code>{@link Integer#MIN_VALUE} ≤ arr[i] ≤ {@link Integer#MAX_VALUE}</code> and
	 *            <code>0 ≤ arr.size() ≤ {@link Integer#MAX_VALUE}</code>
	 *            (the constraints are also weaker compared with the original task)
	 * @return    the index of {@code V} in {@code arr}
	 */
	public static int introTutorial(int V, int[] arr)
	{
		return Arrays.binarySearch(arr, V);
	}
}
