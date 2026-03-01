package org.rododin.algorithms.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/description/">
 *   LeetCode > Problems > Group Anagrams <sub>(medium)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class GroupAnagrams
{
	public List<List<String>> groupAnagrams(String[] strs)
	{
		final Map<Key, List<String>> map = new HashMap<>();
		for (String str : strs)
			map.compute(new Key(str), (k, v) -> v == null ? new ArrayList<>() : v).add(str);
		return new ArrayList<>(map.values());
	}

	private static class Key
	{
		final int[] array = new int[26];
		final int hashCode;

		Key(String str)
		{
			for (int i = 0; i < str.length(); i++)
				array[str.charAt(i) - 'a']++;
			hashCode = Arrays.hashCode(array);
		}

		@Override
		public final boolean equals(Object o)
		{
			if (!(o instanceof final Key key))
				return false;
			return Arrays.equals(array, key.array);
		}

		@Override
		public int hashCode()
		{
			return hashCode;
		}
	}
}
