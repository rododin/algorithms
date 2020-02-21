/*
 * MagicSquareForming.java
 */

package org.rododin.algorithms.hackerrank.medium;

/**
 * <a href="https://www.hackerrank.com/challenges/magic-square-forming/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Forming a Magic Square
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class MagicSquareForming
{
	private static final int N =  3;

	/**
	 * The only following 8 Magic Squares of the size 3x3 are possible for distinct numbers only.
	 */
	private static final int[][][] MAGIC_SQUARES = new int[][][]
	{
		{
			{2, 9, 4},
			{7, 5, 3},
			{6, 1, 8},
		},
		{
			{6, 7, 2},
			{1, 5, 9},
			{8, 3, 4},
		},
		{
			{8, 1, 6},
			{3, 5, 7},
			{4, 9, 2},
		},
		{
			{4, 3, 8},
			{9, 5, 1},
			{2, 7, 6},
		},
		{
			{4, 9, 2},
			{3, 5, 7},
			{8, 1, 6},
		},
		{
			{8, 3, 4},
			{1, 5, 9},
			{6, 7, 2},
		},
		{
			{6, 1, 8},
			{7, 5, 3},
			{2, 9, 4},
		},
		{
			{2, 7, 6},
			{9, 5, 1},
			{4, 3, 8},
		},
	};

	public static void printSquare(int[][] square)
	{
		for (int i = 0; i < square.length; i++)
		{
			for (int j = 0; j < square[i].length; j++)
				System.out.print(square[i][j] + " ");
			System.out.println();
		}
	}

	public static int printFormingMagicSquare(int[][] square)
	{
		System.out.println("\nInitial square:");
		printSquare(square);
		final int formingCost = formingMagicSquare(square);
		System.out.println("Forming cost: " + formingCost);
		return formingCost;
	}

	public static int formingMagicSquare(int[][] square)
	{
		int minCost = Integer.MAX_VALUE;
		int selK = 0;
		for (int k = 0; k < MAGIC_SQUARES.length; k++)
		{
			int cost = 0;
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					cost += Math.abs(square[i][j] - MAGIC_SQUARES[k][i][j]);
				}
			}
			if (minCost > cost)
			{
				minCost = cost;
				selK = k;
			}
		}

		System.out.println("Formed square:");
		printSquare(MAGIC_SQUARES[selK]);

		return minCost;
	}
}
