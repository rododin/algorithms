package org.rododin.algorithms.hackerrank.problem_solving.easy;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/utopian-tree/problem">
 *   HackerRank > Prepare > Algorithms > Implementation > Utopian Tree
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class UtopianTree
{
	public static void main(String[] args)
	{
		final Scanner scanner = new Scanner(System.in);
		final int t = Integer.parseInt(scanner.nextLine().trim());
		IntStream.range(0, t).forEach(tItr ->
		{
			final int n = Integer.parseInt(scanner.nextLine().trim());
			final int result = Result.utopianTree(n);
			System.out.println(result);
		});
		scanner.close();
	}
}

class Result
{
	public static int utopianTree(int n)
	{
		if (n % 2 == 0)
			return (1 << ((n >> 1) + 1)) - 1;
		else
			return utopianTree(n + 1) - 1;
	}
}