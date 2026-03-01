package org.rododin.algorithms.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/">
 *   LeetCode > Problems > Find Minimum in Rotated Sorted Array <sub>(medium)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class FindMinimumInRotatedSortedArray
{
	public int findMin(int[] nums)
	{
		if (nums == null || nums.length == 0)
			return -1;
		int low = 0;
		int high = nums.length - 1;
		if (nums[low] <= nums[high])
			return nums[low];

		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[mid+1])
				return nums[mid+1];
			if (nums[low] <= nums[mid])
				low = mid + 1;
			else if (nums[mid] <= nums[high])
				high = mid - 1;
		}
		return -1;
	}
}
