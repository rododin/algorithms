package org.rododin.algorithms.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/description/">
 *   LeetCode > Problems > Find All Anagrams in a String <sub>(medium)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class FindAllAnagrams
{
	public static List<Integer> findAnagrams(String s, String p)
	{
		if (s == null || p == null || s.length() < p.length())
			return List.of();

		final int[] pCounters = computeCharCounters(p);
		final int[] sCurrentCounters = computeCharCounters(s.substring(0, p.length()));

		final List<Integer> result = new ArrayList<>();
		for (int i = 0; i <= s.length() - p.length(); i++)
		{
			if (i > 0)
			{
				sCurrentCounters[s.charAt(i - 1) - 'a']--;
				sCurrentCounters[s.charAt(i + p.length() - 1) - 'a']++;
			}

			if (isAnagram(sCurrentCounters, pCounters))
				result.add(i);
		}
		return result;
	}

	private static int[] computeCharCounters(String p)
	{
		int[] counters = new int[26];
		for (int i = 0; i < p.length(); i++)
			counters[p.charAt(i) - 'a']++;
		return counters;
	}

	private static boolean isAnagram(int[] sCounters, int[] pCounters)
	{
		for (int i = 0; i < sCounters.length; i++)
		{
			if (sCounters[i] != pCounters[i])
				return false;
		}
		return true;
	}

	private static boolean isAnagram(String s, int[] counters)
	{
		for (int i = 0; i < s.length(); i++)
			counters[s.charAt(i) - 'a']--;
		int counter = 0;
		for (int i = 0; i < 26; i++)
			counter = counters[i] != 0 ? counter + 1 : counter;
		return counter == 0;
	}

	public static boolean isAnagram(String s, String t)
	{
		if (s.length() != t.length())
			return false;

		int[] counters = new int[26];
		for (int i = 0; i < s.length(); i++)
		{
			counters[s.charAt(i) - 'a']++;
			counters[t.charAt(i) - 'a']--;
		}
		int counter = 0;
		for (int i = 0; i < 26; i++)
			counter = counters[i] != 0 ? counter + 1 : counter;
		return counter == 0;
	}

}
