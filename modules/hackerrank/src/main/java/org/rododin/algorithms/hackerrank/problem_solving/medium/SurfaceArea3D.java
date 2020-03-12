package org.rododin.algorithms.hackerrank.problem_solving.medium;

/**
 * <a https://www.hackerrank.com/challenges/3d-surface-area/problem">
 *   HackerRank > Practice > Algorithms > Implementation > 3D Surface Area
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SurfaceArea3D
{
	/**
	 * Implements a quite trivial, simple and effective solution.
	 * The complexity is: <code>O(w * h)</code>, where <code>w</code> and <code>h</code> represent the dimension
	 * of the given matrix <code>A</code>. There is no loop over the 3rd dimension.
	 *
	 * @param A the matrix representing the toy described in the task statement
	 * @return the computed surface area of the toy
	 */
	public static int surfaceArea(int[][] A)
	{
		int surface = 0;
		for (int x = 0; x < A.length; x++)
		{
			for (int y = 0; y < A[x].length; y++)
			{
				if (A[x][y] == 0)
					continue;
				surface += A[x][y] * 4 + 2;
				if (x != 0)
					surface -= Math.min(A[x][y], A[x-1][y]);
				if (y != 0)
					surface -= Math.min(A[x][y], A[x][y-1]);;
				if (x != A.length-1)
					surface -= Math.min(A[x][y], A[x+1][y]);
				if (y != A[x].length-1)
					surface -= Math.min(A[x][y], A[x][y+1]);
			}
		}
		return surface;
	}
}
