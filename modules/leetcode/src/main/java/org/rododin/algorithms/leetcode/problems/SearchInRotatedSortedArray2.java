package org.rododin.algorithms.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/">
 *   LeetCode > Problems > Search in Rotated Sorted Array II <sub>(medium)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SearchInRotatedSortedArray2
{
	public boolean search(int[] nums, int target)
	{
		if (nums == null || nums.length == 0)
			return false;
		return search(nums, target, 0, nums.length - 1);
	}

	public boolean search(int[] nums, int target, int low, int high)
	{
		if (low > high)
			return false;
		int mid = low + (high - low) / 2;
		if (nums[mid] == target)
			return true;
		if (nums[low] < nums[mid] && nums[low] <= target && target < nums[mid])
			return regularBinSearch(nums, target, low, mid);
		else if (nums[mid] < nums[high] && nums[mid] < target && target <= nums[high])
			return regularBinSearch(nums, target, mid, high);
		else
		{
			return search(nums, target, low    , mid - 1)
			    || search(nums, target, mid + 1, high   );
		}
	}

	public boolean regularBinSearch(int[] nums, int target, int low, int high)
	{
		if (low > high)
			return false;
		int mid = low + (high - low) / 2;
		if (nums[mid] == target)
			return true;
		if (target < nums[mid])
			return regularBinSearch(nums, target, low, mid - 1);
		else
			return regularBinSearch(nums, target, mid + 1, high);
	}
}
