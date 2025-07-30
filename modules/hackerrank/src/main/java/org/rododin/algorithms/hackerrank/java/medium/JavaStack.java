package org.rododin.algorithms.hackerrank.java.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-stack/problem">
 *   HackerRank > Prepare > Java > Data Structures > Java Stack
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaStack
{
	private static final Map<Character, Character> OPENINGS_TO_ENDINGS =
		Map.of( '(', ')'
		      , '[', ']'
		      , '{', '}'
		      , '<', '>'
		      );

	public static void main(String[] args)
	{
		final Scanner scanner = new Scanner(System.in);

		while ((scanner.hasNextLine()))
		{
			final Deque<Character> stack = new LinkedList<>();
			final String line = scanner.nextLine();
			boolean balanced = true;
			for (int i = 0; i < line.length(); i++)
			{
				final char ch = line.charAt(i);
				final Character ending = OPENINGS_TO_ENDINGS.get(ch);
				if (ending != null)
				{
					stack.push(ending);
					continue;
				}
				final Character expectedEnding = stack.peek();
				if (expectedEnding != null && expectedEnding == ch)
				{
					stack.pop();
					continue;
				}
				balanced = false;
				break;
			}
			System.out.println(balanced && stack.isEmpty());
		}

		scanner.close();
	}
}
