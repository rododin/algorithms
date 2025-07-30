package org.rododin.algorithms.hackerrank.java.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/phone-book/problem">
 *   HackerRank > Prepare > Java > Data Structures > Java Map
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaMap
{
	public static void main(String[] args)
	{
		final Scanner scanner = new Scanner(System.in);
		final int n = Integer.parseInt(scanner.nextLine());
		final Map<String, String> map = new HashMap<>(((int)(n / 0.75)) + 1);

		for (int i = 0; i < n; i++ )
			map.put(scanner.nextLine(), scanner.nextLine());

		while ((scanner.hasNextLine()))
		{
			final String name = scanner.nextLine();
			final String phone = map.get(name);
			System.out.println(phone != null ? name + "=" + phone : "Not found");
		}

		scanner.close();
	}
}
