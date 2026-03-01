package org.rododin.algorithms.leetcode.problems;

import java.util.ArrayDeque;

/**
 * TODO: Add description.
 */
public class ValidParentheses
{
	private static final char[] OPENINGS = new char[] {'(', '{', '['};
	private static final char[] ENDINGS  = new char[] {')', '}', ']'};

	public boolean isValid(String s)
	{
		final ArrayDeque<Character> stack = new ArrayDeque<>(s.length());
		for (int i = 0; i < s.length(); i++)
		{
			final char c = s.charAt(i);
			if (c == OPENINGS[0] || c == OPENINGS[1] || c == OPENINGS[2])
			{
				stack.push(c);
				continue;
			}
			final Character expectedOpening  = ENDINGS[0] == c ? OPENINGS[0] : ENDINGS[1] == c ? OPENINGS[1] : OPENINGS[2];
			final Character retrievedOpening = stack.poll();
			if (!expectedOpening.equals(retrievedOpening))
				return false;
		}
		return stack.isEmpty();
	}
}
