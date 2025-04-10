package org.rododin.algorithms.hackerrank.java.medium;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="https://www.hackerrank.com/challenges/duplicate-word/problem">
 *   HackerRank > Practice > Java > Strings > Java Regex 2 - Duplicate Words
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaRegEx2DuplicateWords
{
	public static void main(String[] args)
	{
		final String regex = "\\b(\\w+)\\b(\\s+\\b\\1\\b)+";
		final Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		final Scanner in = new Scanner(System.in);
		int numSentences = Integer.parseInt(in.nextLine());

		while (numSentences-- > 0)
		{
			String input = in.nextLine();

			final Matcher m = p.matcher(input);

			// Check for subsequences of input that match the compiled pattern
			while (m.find())
			{
				input = input.replaceAll(m.toMatchResult().group(), m.toMatchResult().group().split("\\s+")[0]);
			}

			// Prints the modified sentence.
			System.out.println(input);
		}

		in.close();
	}
}
