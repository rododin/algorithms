package org.rododin.algorithms.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/description/">
 *   LeetCode > Problems > Search a 2D Matrix <sub>(medium)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Search2DMatrix
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		int low = 0;
		int high = matrix.length - 1;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			int f = matrix[mid][0];
			if (f == target)
				return true;
			if (f > target)
				high = mid - 1;
			else
			{
				int l = matrix[mid][matrix[mid].length - 1];
				if (target == l)
					return true;
				else if (target < l)
					return searchInLine(matrix[mid],target);
				else
					low = mid + 1;
			}
		}
		return false;
	}

	private boolean searchInLine(int[] line, int target)
	{
		int low = 0;
		int high = line.length - 1;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			if (line[mid] == target)
				return true;
			if (line[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}
}
