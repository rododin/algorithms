package org.rododin.algorithms.hackerrank.problem_solving.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/cavity-map/problem">
 *   HackerRank > Practice > Algorithms > Implementation > Cavity Map
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CavityMap
{
	/**
	 * Implements a trivial and quite effective solution for computing the cavity cells in the given {@code grid}.
	 * The complexity is <code>O((n-2)<sup>2</sup>)</code> where {@code n = grid.length = grid[i].length()}.
	 * @param grid the grid of the cells to be analysed as defined in the task,
	 *             where each {@code grid[i].length() = grid.length} and {@code 0 ≤ grid.length ≤ Integer.MAX_VALUE}
	 *             and each <code>grid[i].charAt[j] ∈ {'0'...'9'}</code>. Thus the constraints are even weaker than
	 *             in the original task.
	 * @return the modified {@code grid} where the cavity cells are exchanged with the {@code 'X'} character
	 *         as requested in the original task
	 */
	public static String[] cavityMap(String[] grid)
	{
		for (int i = 1; i < grid.length - 1; i++)
		{
			final StringBuilder sb = new StringBuilder(grid[i]);
			for (int j = 1; j < grid[i].length() - 1; j++)
			{
				final int cell = grid[i].charAt(j) - '0';
				if (  cell > grid[i-1].charAt(j  ) - '0'
				   && cell > grid[i+1].charAt(j  ) - '0'
				   && cell > grid[i  ].charAt(j-1) - '0'
				   && cell > grid[i  ].charAt(j+1) - '0'
				   )
					sb.setCharAt(j, 'X');
			}
			grid[i] = sb.toString();
		}
		return grid;
	}
}
