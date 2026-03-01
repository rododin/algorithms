package org.rododin.algorithms.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/binary-search/description/">
 *   LeetCode > Problems > Binary Search <sub>(easy)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BinarySearch
{
	public static int search(int[] nums, int target)
	{
		int low = 0;
		int high = nums.length - 1;
		while (low <= high)
		{
			final int mid = low  + ((high - low) / 2);
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < target)
				low = mid + 1;
			else if (nums[mid] > target)
				high = mid - 1;
		}
		return -1;
	}

	public static int searchInsertionPosition(int[] nums, int target)
	{
		int low = 0;
		int high = nums.length - 1;
		while (low <= high)
		{
			final int mid = low  + ((high - low) / 2);
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < target)
				low = mid + 1;
			else if (nums[mid] > target)
				high = mid - 1;
		}
		return low;
	}

	public static int searchRecursive(int[] nums, int target)
	{
		return searchRecursive(nums, target, 0, nums.length - 1);
	}

	public static int searchRecursive(int[] nums, int target, int low, int high)
	{
		if (low > high)
			return -1;
		final int mid = low + ((high - low) / 2);
		if (nums[mid] == target)
			return mid;
		if (nums[mid] < target)
			return searchRecursive(nums, target, mid + 1, high);
		else
			return searchRecursive(nums, target, low, mid - 1);
	}
}
