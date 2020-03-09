package org.rododin.algorithms.hackerrank.java.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://www.hackerrank.com/challenges/java-anagrams/problem">
 *   Practice > Java > Strings > Java Anagrams
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaAnagrams
{
	/**
	 * A case insensitive limited-solution method for the Latin chars only based on fixed-size counter arrays.
	 */
	public static boolean isAnagramLatin(String a, String b)
	{
		if (a.length() != b.length())
			return false;

		final int[] aCounters = countCharsLatin(a), bCounters = countCharsLatin(b);
		for (int i = 0; i < 26; i++)
		{
			if (aCounters[i] != bCounters[i])
				return false;
		}
		return true;
	}

	private static int getCounterIndexLatin(char c)
	{
		return 'a' <= c && c <= 'z' ? c - 'a' : -1;
	}

	private static int[] countCharsLatin(String s)
	{
		final int[] counters = new int[52];
		for (int i = 0; i < s.length(); i++)
			counters[getCounterIndexLatin(Character.toLowerCase(s.charAt(i)))]++;
		return counters;
	}

	/**
	 * A unified case-sensitive method for any characters based on a <code>{@link HashMap}</code>.
	 */
	public static boolean isAnagram(String a, String b)
	{
		if (a.length() != b.length())
			return false;

		final Map<Character, Integer> counters = new HashMap<>();
		for (int i = 0; i < a.length(); i++)
			counters.compute(a.charAt(i), (c, count) -> count == null ? 1 : count+1);
		for (int i = 0; i < b.length(); i++)
			counters.compute(b.charAt(i), (c, count) -> {
				if (count == null)
					return -1;
				else
					count--;
				return  count == 0 ? null : count;
			});
		return counters.isEmpty();
	}
}
