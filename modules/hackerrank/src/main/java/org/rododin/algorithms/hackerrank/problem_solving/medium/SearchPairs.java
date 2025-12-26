package org.rododin.algorithms.hackerrank.problem_solving.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/pairs/problem">
 *   HackerRank > Prepare > Algorithms > Search > Pairs
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SearchPairs
{
	public static void main(String[] args)
	{
		final Scanner scanner = new Scanner(System.in);

		final String[] nk = scanner.nextLine().replaceAll("\\s+$", "").split(" ");
		final int n = Integer.parseInt(nk[0]);
		final int k = Integer.parseInt(nk[1]);

		final Map<Long, Integer> map = new HashMap<>(n * 4 / 3 + 1);
		for (int i = 0; i < n; i++)
			map.compute(scanner.nextLong(), (key, value) -> value == null ? 1 : value + 1);

		int count = 0;
		for (Map.Entry<Long, Integer> entry : map.entrySet())
		{
			final Long number = entry.getKey();
			final Integer matchedPair = map.get(number + k);
			if (matchedPair != null)
				count += matchedPair;
		}

		System.out.println(count);

		scanner.close();
	}
}
