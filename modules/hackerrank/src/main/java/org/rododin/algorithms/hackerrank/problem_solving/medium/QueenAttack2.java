package org.rododin.algorithms.hackerrank.problem_solving.medium;

import java.util.function.BiPredicate;

/**
 * <a href="https://www.hackerrank.com/challenges/queens-attack-2/problem">
 *   HackerRank > Practice > Algorithms > Implementation > Queen's Attack II
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class QueenAttack2
{
	/**
	 * Implements a quick and memory-effective solution.
	 * The complexity is: <code>O(k)</code>, where <code>k</code> is the size/length of the <code>obstacles</code> (aka the number of obstacles).
	 * And we don't allocate any additional memory except the memory for some local variables in the stack.
	 *
	 * @see #queensAttackIneffective(int, int, int, int, int[][])
	 */
	public static int queensAttack(int n, int k, int rQ, int cQ, int[][] obstacles)
	{
		int dN, dE, dS, dW, dNE, dSE, dNW, dSW, or, oc, dr, dc;
		dN = dE = dS = dW = dNE = dSE = dNW = dSW = Integer.MAX_VALUE;
		for (final int[] obstacle : obstacles)
		{
			or = obstacle[0];
			oc = obstacle[1];
			dr = rQ - or;
			dc = cQ - oc;

			if (dc == 0)
			{
				if (dr > 0 && dr < dS)
					dS = dr;
				else if (dr < 0 && -dr < dN)
					dN = -dr;
			}
			else if (dr == 0)
			{
				if (dc > 0 && dc < dW)
					dW = dc;
				else if (dc < 0 && -dc < dE)
					dE = -dc;
			}
			else if (Math.abs(dr) == Math.abs(dc))
			{
				if (dr > 0 && dc > 0 && dr < dSW)
					dSW = dr;
				else if (dr > 0 && dc < 0 && dr < dSE)
					dSE = dr;
				else if (dr < 0 && dc > 0 && dc < dNW)
					dNW = dc;
				else if (dr < 0 && dc < 0 && -dc < dNE)
					dNE = -dc;
			}
		}

		final int cN = n - rQ;
		final int cE = n - cQ;
		final int cS = rQ - 1;
		final int cW = cQ - 1;

		return (dN  != Integer.MAX_VALUE ? dN  - 1 : cN)
		     + (dE  != Integer.MAX_VALUE ? dE  - 1 : cE)
		     + (dS  != Integer.MAX_VALUE ? dS  - 1 : cS)
		     + (dW  != Integer.MAX_VALUE ? dW  - 1 : cW)
		     + (dNE != Integer.MAX_VALUE ? dNE - 1 : Math.min(cN, cE))
		     + (dSE != Integer.MAX_VALUE ? dSE - 1 : Math.min(cS, cE))
		     + (dNW != Integer.MAX_VALUE ? dNW - 1 : Math.min(cN, cW))
		     + (dSW != Integer.MAX_VALUE ? dSW - 1 : Math.min(cS, cW));
	}

	/**
	 * Another ineffective but a trivial solution, where we create the a board of obstacles first of the <code>n * n</code> size.
	 * If <code>n</code> is big, e.g. <code>100K</code>, it allocates a huge amount of memory and may cause an
	 * <code>{@link OutOfMemoryError}</code> on execution. And then we count the cells under the Queen's attack in
	 * each of the eight directions.
	 * <p/>
	 * The complexity here is: <code>O(k + 4 * (n-1))</code>.
	 * Thus, it's also higher than for <code>{@link #queensAttack(int, int, int, int, int[][])}</code>.
	 */
	public static int queensAttackIneffective(int n, int k, int rQ, int cQ, int[][] obstacles)
	{
		rQ--; cQ--; // Converting to 0-based coordinates
		final boolean[][] obstaclesBoard = buildObstaclesBoard(n, obstacles);

		int count = 0;

		count += queensAttackInDirection(rQ, cQ, -1,  0, (r, c) -> r >= 0, obstaclesBoard);
		count += queensAttackInDirection(rQ, cQ, +1,  0, (r, c) -> r <  n, obstaclesBoard);
		count += queensAttackInDirection(rQ, cQ,  0, -1, (r, c) -> c >= 0, obstaclesBoard);
		count += queensAttackInDirection(rQ, cQ,  0, +1, (r, c) -> c <  n, obstaclesBoard);

		count += queensAttackInDirection(rQ, cQ, -1, -1, (r, c) -> r >= 0 && c >= 0, obstaclesBoard);
		count += queensAttackInDirection(rQ, cQ, +1, -1, (r, c) -> r <  n && c >= 0, obstaclesBoard);
		count += queensAttackInDirection(rQ, cQ, +1, +1, (r, c) -> r <  n && c <  n, obstaclesBoard);
		count += queensAttackInDirection(rQ, cQ, -1, +1, (r, c) -> r >= 0 && c <  n, obstaclesBoard);

		return count;
	}

	private static boolean[][] buildObstaclesBoard(int n, int[][] obstacles)
	{
		boolean[][] obstaclesBoard = new boolean[n][n];
		for (int i = 0; i < obstacles.length; i++)
		{
			int or = obstacles[i][0];
			int oc = obstacles[i][1];
			obstaclesBoard[or-1][oc-1] = true;
		}
		return obstaclesBoard;
	}

	private static int queensAttackInDirection(int rQ, int cQ, int rMod, int cMod, BiPredicate<Integer, Integer> pred, boolean[][] obstaclesBoard)
	{
		int count = 0;
		for (int r = rQ + rMod, c = cQ + cMod; pred.test(r, c); r += rMod, c += cMod)
		{
			if (obstaclesBoard[r][c])
				break;
			count++;
		}
		return count;
	}
}
