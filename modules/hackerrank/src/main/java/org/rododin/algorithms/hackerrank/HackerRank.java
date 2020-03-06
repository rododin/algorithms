package org.rododin.algorithms.hackerrank;

import java.util.Scanner;

import org.rododin.algorithms.Constants;

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
		isPalindrome();
	}

	public static void isPalindrome()
	{
		final Scanner scan = new Scanner(System.in);
		final String s = scan.nextLine();
		scan.close();

		String result = "yes";
		for (int i = 0, j = s.length() - 1; i < j; i++, j--)
		{
			if (s.charAt(i) != s.charAt(j))
			{
				result = "no";
				break;
			}
		}
		System.out.println(result);
	}
}
