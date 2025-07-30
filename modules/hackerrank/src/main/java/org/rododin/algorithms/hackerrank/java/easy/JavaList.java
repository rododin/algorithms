package org.rododin.algorithms.hackerrank.java.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/java-list/problem">
 *   HackerRank > Prepare > Java > Data Structures > Java List
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaList
{
	public static void main(String[] args)
	{
		final Scanner scanner = new Scanner(System.in);
		final int n = Integer.parseInt(scanner.nextLine());
		final List<Integer> list = new ArrayList<>(n);
		final String[] theListStrings = scanner.nextLine().split("\\s");

		for (String str : theListStrings)
			list.add(Integer.parseInt(str));

		final int q = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < q; i++ )
		{
			final String query = scanner.nextLine();
			final String[] queryParams = scanner.nextLine().split("\\s");
			final int index = Integer.parseInt(queryParams[0]);
			final int value = queryParams.length > 1 ? Integer.parseInt(queryParams[1]) : 0;
			switch (query)
			{
				case "Insert":
					list.add(index, value);
					break;
				case "Delete":
					list.remove(index);
					break;
			}
		}

		scanner.close();

		System.out.println(list.stream().map(element -> Integer.toString(element)).collect(Collectors.joining(" ")));
	}
}
