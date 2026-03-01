package org.rododin.algorithms.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/guess-number-higher-or-lower/description/">
 *   LeetCode > Problems > Guess Number Higher or Lower <sub>(easy)</sub>
 * </a> Problem Solution.
 * <p>
 * <b>NOTE:</b> It's the solution class for the issue.
 *
 * @see GuessGame
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class GuessNumber
	extends GuessGame
{
	public int guessNumber(int n)
	{
		int low = 0;
		int high = n;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			int g = guess(mid);
			if (g == 0)
				return mid;
			if (g < 0)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}
}
