package org.rododin.algorithms.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/single-number/description/">
 *   LeetCode > Problems > Single Number <sub>(easy)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SingleNumber
{
	public int singleNumber(int[] nums)
	{
		int acc = 0;
		for (int n : nums)
			acc ^= n;
		return acc;
	}
}
