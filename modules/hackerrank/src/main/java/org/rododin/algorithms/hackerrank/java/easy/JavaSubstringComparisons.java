package org.rododin.algorithms.hackerrank.java.easy;

import java.util.LinkedList;

/**
 * <a href="https://www.hackerrank.com/challenges/java-string-compare/problem">
 *   Practice > Java > Strings > Java Substring Comparisons
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaSubstringComparisons
{
	public static String[] printMinMaxSubStrings(String s, int k)
	{
		final String[] strings = findMinMaxStrings(s, k);
		for (String str : strings)
			System.out.println(str);
		return strings;
	}

	public static String[] findMinMaxStrings(String s, int k)
	{
		final LinkedList<String> substrings = new LinkedList<>();
		for (int i = 0, j = k; i < j && j <= s.length(); i++, j++)
			substrings.add(s.substring(i, j));
		substrings.sort(String::compareTo);
		if (substrings.size() > 0)
			return new String[] {substrings.getFirst(), substrings.getLast()};
		else
			return new String[] {};
	}
}
