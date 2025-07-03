package org.rododin.algorithms.hackerrank.java.medium;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-1d-array/problem">
 *   HackerRank > Prepare > Java > Data Structures > Java 1D Array (Part 2)
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Java1DArrayPart2
{
	public static void main(String[] args)
	{
		final Scanner scan = new Scanner(System.in);
		for (int q = scan.nextInt(); q > 0; q--)
		{
			final int n = scan.nextInt();
			final int leap = scan.nextInt();

			final int[] game = new int[n];
			for (int i = 0; i < n; i++)
				game[i] = scan.nextInt();

			System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
		}
		scan.close();
	}

	public static boolean canWin(int leap, int[] game)
	{
		return canWin(0, leap, game);
	}

	public static boolean canWin(int currentIndex, int leap, int[] game)
	{
		// Checking whether we can stay at the current position or not, and if we cannot do, then returning false
		if (currentIndex < 0 || (currentIndex < game.length && game[currentIndex] != 0))
			return false;

		// If we reached the last/finish position, or jumped out the game, we have won, so, returning false
		if (currentIndex >= game.length - 1)
			return true;

		game[currentIndex] = -1; // Marking the current position as checked with -1, so, if we reach it again we'll return false immediately

		// If not yet winning, repeating the canWin routine recursively starting from the jump position
		if (canWin(currentIndex + leap, leap, game))
			return true;

		// If still not yet winning, repeating the canWin routine recursively by moving one step forward if still possible
		if (canWin(currentIndex + 1, leap, game))
			return true;

		// If still not yet winning, repeating the canWin routine recursively by moving one step backward if still possible
		if (canWin(currentIndex - 1, leap, game))
			return true;

		// If we have not yet won, we cannot do, so, returning false
		return false;
	}
}
