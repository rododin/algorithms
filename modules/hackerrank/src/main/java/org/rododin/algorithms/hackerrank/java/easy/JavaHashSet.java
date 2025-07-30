package org.rododin.algorithms.hackerrank.java.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/java-hashset/problem">
 *   HackerRank > Prepare > Java > Data Structures > Java Hashset
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaHashSet
{
	public static void main(String[] args)
	{
		final Set<Set<String>> set = new HashSet<>();
		final Scanner scanner = new Scanner(System.in);
		final int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++)
		{
			set.add(Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toSet()));
			System.out.println(set.size());
		}
		scanner.close();
	}
}
