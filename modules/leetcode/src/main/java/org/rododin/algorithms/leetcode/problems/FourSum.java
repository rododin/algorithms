package org.rododin.algorithms.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/4sum/description/">
 *   LeetCode > Problems > 4Sum <sub>(medium)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class FourSum
{
	public static class Four
	{
		final int[] four = new int[4];

		public Four(int... elements)
		{
			for (int i = 0; i < 4 && i < elements.length; i++)
				four[i] = elements[i];
		}

		@Override
		public final boolean equals(Object o)
		{
			if (!(o instanceof final Four four1))
				return false;

			return Arrays.equals(four, four1.four);
		}

		@Override
		public int hashCode()
		{
			return Arrays.hashCode(four);
		}

		public List<Integer> toList()
		{
			return Arrays.stream(four).boxed().toList();
		}
	}

	//public List<List<Integer>> fourSum(int[] nums, int target)
	//{
	//	if (nums == null || nums.length < 4)
	//		return List.of();
	//
	//	Arrays.sort(nums);
	//
	//	final Set<Four> result = new HashSet<>();
	//
	//	for (int i = 0; i < nums.length - 3; i++)
	//	{
	//		//if (nums[i] < 0 && target < nums[i] && target < 4 * nums[i])
	//		//	break;
	//		if (nums[i] >= 0 && target < nums[i])
	//			break;
	//
	//		Four four = new Four(nums[i]);
	//		boolean fourFound = false;
	//
	//		for (int j = i + 1; j < nums.length - 2; j++)
	//		{
	//			final long s2 = (long)nums[i] + (long)nums[j];
	//			//if (nums[j] < 0 && target < nums[j] && target < nums[i] + 3 * (long)nums[j])
	//			//	break;
	//			if (nums[j] >= 0 && target < s2)
	//				break;
	//
	//			four.four[1] = nums[j];
	//
	//			for (int k = j + 1; k < nums.length - 1; k++)
	//			{
	//				final long s3 = s2 + (long)nums[k];
	//				//if (nums[k] < 0 && target < nums[k] && target < s2 + 2 * (long)nums[k])
	//				//	break;
	//				if (nums[k] >= 0 && target < s3)
	//					break;
	//
	//				four.four[2] = nums[k];
	//
	//				for (int l = k + 1; l < nums.length; l++)
	//				{
	//					fourFound = false;
	//					final long s4 = s3 + (long)nums[l];
	//					//if (nums[l] < 0 && target < nums[l] && target < s4)
	//					//	break;
	//					if (nums[l] >= 0 && target < s4)
	//						break;
	//
	//					four.four[3] = nums[l];
	//
	//					if (target == s4)
	//					{
	//						result.add(four);
	//						fourFound = true;
	//						break;
	//					}
	//				}
	//				if (fourFound)
	//					four = new Four(four.four[0], four.four[1], four.four[2]);
	//			}
	//			if (fourFound)
	//				four = new Four(four.four[0], four.four[1]);
	//		}
	//	}
	//
	//	return result.stream().map(Four::toList).toList();
	//}

	//public List<List<Integer>> fourSum(int[] nums, int target)
	//{
	//	if (nums == null || nums.length < 4)
	//		return List.of();
	//
	//	Arrays.sort(nums);
	//
	//	final Set<Four> result = new HashSet<>();
	//
	//	for (int i = 0; i < nums.length - 3; i++)
	//	{
	//		if (i > 0 && nums[i] == nums[i - 1])
	//			continue;
	//		if (nums[i] < 0 && target < nums[i] && target < 4 * nums[i])
	//			break;
	//		if (nums[i] >= 0 && target < nums[i])
	//			break;
	//
	//		Four four = new Four(nums[i]);
	//		boolean fourFound = false;
	//
	//		for (int j = i + 1; j < nums.length - 2; j++)
	//		{
	//			if (j > i + 1 && nums[j] == nums[j - 1])
	//				continue;
	//			final long s2 = (long)nums[i] + (long)nums[j];
	//			if (nums[j] < 0 && target < nums[j] && target < nums[i] + 3 * (long)nums[j])
	//				break;
	//			if (nums[j] >= 0 && target < s2)
	//				break;
	//
	//			four.four[1] = nums[j];
	//
	//			for (int k = j + 1; k < nums.length - 1; k++)
	//			{
	//				if (k > j + 1 && nums[k] == nums[k - 1])
	//					continue;
	//				final long s3 = s2 + (long)nums[k];
	//				if (nums[k] < 0 && target < nums[k] && target < s2 + 2 * (long)nums[k])
	//					break;
	//				if (nums[k] >= 0 && target < s3)
	//					break;
	//
	//				four.four[2] = nums[k];
	//
	//				fourFound = false;
	//				final int fourth = binarySearch(nums, target - s3, k + 1, nums.length - 1);
	//				if (fourth >= 0)
	//				{
	//					fourFound = true;
	//					four.four[3] = nums[fourth];
	//					result.add(four);
	//				}
	//				if (fourFound)
	//					four = new Four(four.four[0], four.four[1], four.four[2]);
	//			}
	//			if (fourFound)
	//				four = new Four(four.four[0], four.four[1]);
	//		}
	//	}
	//
	//	return result.stream().map(Four::toList).toList();
	//}

	//public static int binarySearch(int[] nums, long target, int low, int high)
	//{
	//	while (low <= high)
	//	{
	//		final int mid = low + ((high - low) / 2);
	//		if (nums[mid] == target)
	//			return mid;
	//		if (nums[mid] < target)
	//			low = mid + 1;
	//		else if (nums[mid] > target)
	//			high = mid - 1;
	//	}
	//	return -1;
	//}

	public List<List<Integer>> fourSum(int[] nums, int target)
	{
		if (nums == null || nums.length < 4)
			return List.of();

		final List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++)
		{
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			for (int j = i + 1; j < nums.length - 2; j++)
			{
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;

				int left = j + 1;
				int right = nums.length - 1;

				while (left < right)
				{
					final long sum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];

					if (sum < target)
						left++;
					else if (sum > target)
						right--;
					else
					{
						result.add(List.of(nums[i], nums[j], nums[left], nums[right]));
						left++;
						right--;

						while (left < right && nums[left] == nums[left - 1])
							left++;

						while (left < right && nums[right] == nums[right + 1])
							right--;
					}
				}
			}
		}
		return result;
	}
}
