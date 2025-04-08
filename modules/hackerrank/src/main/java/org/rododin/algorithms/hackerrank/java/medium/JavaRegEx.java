package org.rododin.algorithms.hackerrank.java.medium;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-regex/problem">
 *   HackerRank > Practice > Java > Strings > Java Regex
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaRegEx
{
	public static void main(String[] args)
	{
		final Scanner in = new Scanner(System.in);
		while (in.hasNext())
		{
			final String IP = in.nextLine();
			System.out.println(IP.matches(new MyRegex().pattern));
		}
	}
}

class MyRegex
{
	String subpattern = "([0-9]|[0-9][0-9]|[0-1][0-9][0-9]|[0-2][0-4][0-9]|[0-2]5[0-5])";
	String pattern = subpattern + "\\." + subpattern + "\\." + subpattern + "\\." + subpattern;
}
