package org.rododin.algorithms.hackerrank.java.easy;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-string-tokens/problem">
 *   HackerRank > Practice > Java > Introduction > Java String Tokens
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaStringTokens
{
	public static void main(String[] args)
	{
		final Scanner scan = new Scanner(System.in);
		final String source = "c " + scan.nextLine();
		scan.close();
		final String[] strings = source.split("[ !,?._'@]+");
		System.out.println(strings.length - 1);
		for (int i = 1; i < strings.length; i++)
			System.out.println(strings[i]);
	}
}
