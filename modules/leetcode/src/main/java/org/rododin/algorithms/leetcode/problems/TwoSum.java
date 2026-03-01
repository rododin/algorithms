package org.rododin.algorithms.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/description/">
 *   LeetCode > Problems > Two Sum <sub>(easy)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class TwoSum
{
	public int[] twoSum(int[] nums, int target)
	{
		final Map<Integer, Integer> map = new HashMap<>((int)(nums.length / 0.75F) + 1);
		for (int i = 0; i < nums.length; i++)
		{
			final int diff = target - nums[i];
			final Integer candidate = map.get(diff);
			if (candidate != null)
				return new int[]{candidate, i};
			map.put(nums[i], i);
		}
		return new int[]{0, 0};
	}
}
