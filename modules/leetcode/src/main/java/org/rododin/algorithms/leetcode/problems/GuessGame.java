package org.rododin.algorithms.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/guess-number-higher-or-lower/description/">
 *   LeetCode > Problems > Guess Number Higher or Lower <sub>(easy)</sub>
 * </a> Problem Solution.
 * <p>
 * <b>NOTE:</b> It's the base class for the issue.
 *
 * @see GuessNumber
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class GuessGame
{
	private int pickedNumber;

	public void setPickedNumber(int pickedNumber)
	{
		this.pickedNumber = pickedNumber;
	}

	public int guess(int num)
	{
		return Integer.compare(pickedNumber, num);
	}
}
