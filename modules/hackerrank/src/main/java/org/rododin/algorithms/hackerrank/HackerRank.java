package org.rododin.algorithms.hackerrank;

import org.rododin.algorithms.Constants;
import org.rododin.algorithms.hackerrank.easy.RepeatedString;

/**
 * Just an app stub for quick testing.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class HackerRank
	implements Constants
{
	public static void main(String[] args)
	{
		RepeatedString.printRepeatedString("abcac", 10);
		RepeatedString.printRepeatedString("aba", 10);
		RepeatedString.printRepeatedString("a", 1_000_000_000_000L);
		RepeatedString.printRepeatedString("bcd", 100);
		RepeatedString.printRepeatedString("", 100);
	}
}
