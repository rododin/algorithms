package org.rododin.algorithms.hackerrank.java.easy;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * <a href="https://www.hackerrank.com/challenges/pattern-syntax-checker/problem">
 *   HackerRank > Prepare > Java > Strings > Pattern Syntax Checker
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaPatternSyntaxChecker
{
	public static void main(String[] args)
	{
		final Scanner in = new Scanner(System.in);
		final int testCases = Integer.parseInt(in.nextLine());
		for(int i = 0; i < testCases; i++)
			System.out.println(isPatternValid(in.nextLine()) ? "Valid" : "Invalid");
	}

	public static boolean isPatternValid(String pattern)
	{
		try
		{
			Pattern.compile(pattern);
			return true;
		}
		catch (Throwable t)
		{
			return false;
		}
	}
}
