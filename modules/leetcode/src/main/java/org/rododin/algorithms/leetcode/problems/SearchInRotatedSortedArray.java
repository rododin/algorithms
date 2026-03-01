package org.rododin.algorithms.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/description/">
 *   LeetCode > Problems > Search in Rotated Sorted Array <sub>(medium)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SearchInRotatedSortedArray
{
	public int search(int[] nums, int target)
	{
		if (nums == null || nums.length == 0)
			return -1;
		if (nums[0] <= nums[nums.length - 1])
			return binarySearch(nums, target, 0, nums.length - 1);

		int low = 0, high = nums.length - 1;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			if (nums[low] <= nums[mid])
			{
				if (target >= nums[low] && target <= nums[mid])
					return binarySearch(nums, target, low, mid);
				low = mid + 1;
			}
			else if (nums[mid] <= nums[high])
			{
				if (target >= nums[mid] && target <= nums[high])
					return binarySearch(nums, target, mid, high);
				high = mid - 1;
			}
		}
		return -1;
	}

	int binarySearch(int[] nums, int target, int low, int high)
	{
		if (low > high)
			return -1;
		final int mid = low + (high - low) / 2;
		if (nums[mid] == target)
			return mid;
		if (target < nums[mid])
			return binarySearch(nums, target, low, mid - 1);
		return binarySearch(nums, target, mid + 1, high);
	}
}
