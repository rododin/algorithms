package org.rododin.algorithms.hackerrank.java.medium;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/tag-content-extractor/problem">
 *   HackerRank > Prepare > Java > Strings > Tag Content Extractor
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class TagContentExtractor
{
	public static final String INVALID_RESULT = "None" + System.lineSeparator();

	public static void main(String[] args)
	{
		final Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases > 0)
		{
			System.out.print(findAndParseTag(in.nextLine(), false));
			testCases--;
		}
	}

	private static String findAndParseTag(String string, boolean tagged)
	{
		if (string.isEmpty())
			return INVALID_RESULT;

		final int tagNameMarkerStartIndex = string.indexOf('<');
		if (tagNameMarkerStartIndex < 0)
		{
			if (tagged)
				return string + System.lineSeparator(); // Considering a non-tagged string as a valid content string here
			else
				return INVALID_RESULT;
		}

		final int tagNameMarkerEndIndex = string.indexOf('>', tagNameMarkerStartIndex + 1);
		if (tagNameMarkerEndIndex < 0)
			return INVALID_RESULT;

		final String tagName = string.substring(tagNameMarkerStartIndex + 1, tagNameMarkerEndIndex);
		final String endTagNameFull = "</" + tagName + ">";
		final int endTagNameIndex = string.lastIndexOf(endTagNameFull);

		String nestedResult = (endTagNameIndex <= tagNameMarkerEndIndex)
		                    ? INVALID_RESULT
		                    : tagName.isEmpty() ? INVALID_RESULT : findAndParseTag(string.substring(tagNameMarkerEndIndex + 1, endTagNameIndex), true);

		String postResult = endTagNameIndex + endTagNameFull.length() < string.length()
		                  ? findAndParseTag(string.substring(endTagNameIndex + endTagNameFull.length()), false)
		                  : "";

		if (INVALID_RESULT.equals(nestedResult))
			nestedResult = "";
		if (INVALID_RESULT.equals(postResult))
			postResult = "";

		String result = nestedResult + postResult;
		if (result.isEmpty())
			result = INVALID_RESULT;

		return result;
	}
}
