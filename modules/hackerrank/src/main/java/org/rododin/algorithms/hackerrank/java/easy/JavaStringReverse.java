package org.rododin.algorithms.hackerrank.java.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/java-string-reverse/problem">
 *   HackerRank > Practice > Java > Strings > Java String Reverse
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaStringReverse
{
	public static boolean printIsPalindrome(String s)
	{
		final boolean rv = isPalindrome(s);
		System.out.println(s + " -> isPalindrome? -" + (rv ? "yes" : "no"));
		return rv;
	}

	public static boolean isPalindrome(String s)
	{
		boolean rv = true;
		for (int i = 0, j = s.length() - 1; i < j; i++, j--)
		{
			if (s.charAt(i) != s.charAt(j))
			{
				rv = false;
				break;
			}
		}
		return rv;
	}
}
