package org.rododin.algorithms.hackerrank.java.easy;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-end-of-file/problem">
 *   HackerRank > Practice > Java > Introduction > Java End-of-file
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaEOF
{
	public static void enumerateStdInLines()
	{
		final Scanner scanner = new Scanner(System.in);
		int n = 0;
		while (scanner.hasNextLine())
			System.out.println(++n + " " + scanner.nextLine());
		scanner.close();
	}
}
