/*
 * MagicSquareForming.java
 */

package org.rododin.algorithms.misc.magic_square_forming;

import java.util.function.BiFunction;

/**
 * <a href="https://www.hackerrank.com/challenges/magic-square-forming/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Forming a Magic Square
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class MagicSquareForming
{
	private static final int N             =  3;
	private static final int MAGIC_NUMBER  = 15;
	private static final int CENTRAL_CELL  =  5;
	private static final int CENTRAL_INDEX =  1;

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
			{3, 0, 7},
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

	public static int formingMagicSquareExp(int[][] square)
	{
		int formingCost = 0; // the result magic square forming cost

		// Step 1: Fixing the central square, it can be only equal to the predefined CENTRAL_CELL value, nothing else is possible
		final int ccDif = CENTRAL_CELL - square[CENTRAL_INDEX][CENTRAL_INDEX];
		square[1][1] += ccDif;
		formingCost += Math.abs(ccDif);

		//System.out.println("\nStep 1, the square:");
		//printSquare(square);
		//System.out.println("Step 1, the cost: " + formingCost);

		int spd = 0;              // Primary diagonal sum
		int ssd = 0;              // Secondary diagonal sum
		int[] sRows = new int[N]; // Row sums
		int[] sCols = new int[N]; // Column sums
		int e;                    // Current element (cell value), aka the square[i][j]

		// Step 2: Computing the sums
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				e = square[i][j];
				sRows[i] += e;
				sCols[j] += e;
				if (i == j)
					spd += e;
				if (i == N - j - 1)
					ssd += e;
			}
		}

		// Step 3: Fixing the primary diagonal, i == j
		final int spdDif = MAGIC_NUMBER - spd;
		if (spdDif != 0)
		{
			int optI = 0;
			int minChange = 0;
			for (int i = 0; i < N; i++)
			{
				if (i == CENTRAL_INDEX)
					continue;
				final int change = Math.abs(MAGIC_NUMBER - (sRows[i] + spdDif)) + Math.abs(MAGIC_NUMBER - (sCols[i] + spdDif));
				if (change < minChange)
				{
					optI = i;
					minChange = change;
				}
			}
			square[optI][optI] += spdDif;
			spd += spdDif;
			sRows[optI] += spdDif;
			sCols[optI] += spdDif;
		}

		// Step 4: Fixing the secondary diagonal, j = N - i - 1
		final int ssdDif = MAGIC_NUMBER - ssd;
		if (ssdDif != 0)
		{
			int optI = 0;
			int optJ = 0;
			int minChange = 0;
			for (int i = 0, j = N - 1; i < N; i++, j--)
			{
				if (i == CENTRAL_INDEX)
					continue;
				final int change = Math.abs(MAGIC_NUMBER - (sRows[i] + ssdDif)) + Math.abs(MAGIC_NUMBER - (sCols[j] + ssdDif));
				if (change < minChange)
				{
					optI = i;
					optJ = j;
					minChange = change;
				}
			}
			square[optI][optJ] += ssdDif;
			ssd += ssdDif;
			sRows[optI] += ssdDif;
			sCols[optJ] += ssdDif;
		}

		int optI = 0;
		int optJ = 0;
		int minChange = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (1 == j || i == N - j - 1)
					continue;
				final int rDif = MAGIC_NUMBER - sRows[i];
				final int cDif = MAGIC_NUMBER - sCols[j];
				final int dif = Math.abs(rDif) < Math.abs(cDif) ? rDif : cDif;

				// TODO: Complete it...
			}
		}

		//for (int i = 0; i < N; i++)
		//{
		//	formingCost += fixCell(square, i, i, sRows, sCols, spdDif, (ii, jj) -> CENTRAL_INDEX == ii);
		//}

		//System.out.println("\nStep 3, the square:");
		//printSquare(square);
		//System.out.println("Step 3, the cost: " + formingCost);

		// Step 4: Fixing the secondary diagonal, j = N - i - 1
		//int ssdDif = MAGIC_NUMBER - ssd;
		//for (int i = 0, j = N - i - 1; i < N; i++, j--)
		//	formingCost += fixCell(square, i, j, sRows, sCols, ssdDif, Integer::equals);

		//System.out.println("\nStep 4, the square:");
		//printSquare(square);
		//System.out.println("Step 4, the cost: " + formingCost);

		//// Step 5: Fixing the other non-diagonal cells
		//for (int i = 0; i < N; i++)
		//{
		//	for (int j = 0; j < N; j++)
		//	{
		//		if (i == CENTRAL_INDEX && i == j)
		//			continue;
		//		final int rDif = MAGIC_NUMBER - sRows[i];
		//		final int cDif = MAGIC_NUMBER - sCols[j];
		//		final int dDif = i == j
		//		               ? MAGIC_NUMBER - spd
		//		               : i == N - j - 1
		//		               ? MAGIC_NUMBER - ssd
		//		               : cDif;
		//		int minDif = Math.abs(rDif) < Math.abs(cDif) ? rDif : cDif;
		//		minDif = Math.abs(dDif) < Math.abs(minDif) ? dDif : minDif;
		//		minDif = minDif >  8 ? 8
		//		       : minDif < -8 ? -8
		//		       : minDif;
		//
		//		if (minDif == 0)
		//			continue;
		//
		//		square[i][j] += minDif;
		//		sRows[i] += minDif;
		//		sCols[j] += minDif;
		//
		//		if (i == j)
		//			spd += minDif;
		//		else if (i == N - j - 1)
		//			ssd += minDif;
		//
		//		formingCost += Math.abs(minDif);
		//		//formingCost += fixCell(square, i, j, sRows, sCols, cDif, (ii, jj) -> ii.equals(jj) || ii.equals(N - jj - 1));
		//	}
		//}

		return formingCost;
	}

	private static int fixCell(int[][] square, int i, int j, int[] sRows, int[] sCols, int dif, BiFunction<Integer, Integer, Boolean> cellSkipper)
	{
		if (cellSkipper.apply(i, j))        // skipping central cell, it's already set
			return 0;
		if (sRows[i] + dif > MAGIC_NUMBER)  // skipping the cell if its row sum would become more than the MAGIC_NUMBER
			return 0;
		if (sCols[j] + dif > MAGIC_NUMBER)  // same, skipping the cell if its column sum would become more than the MAGIC_NUMBER
			return 0;
		square[i][j] += dif;                // and otherwise, if not skipped, fixing the cell:
		sRows[i] += dif;                    //  - updating the sums
		sCols[j] += dif;                    //    ...
		return Math.abs(dif);               //  - and returning the forming cost value
	}
}
