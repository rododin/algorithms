package org.rododin.algorithms.hackerrank.java.easy;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/valid-username-checker/problem">
 *   HackerRank > Prepare > Java > Strings > Valid Username Regular Expression
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class ValidUsernameRegularExpression
{
	public static final String VALID_USERNAME_PATTERN = "[a-zA-Z]{1}[a-zA-Z_0-9]{7,29}";

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args)
	{
		int n = Integer.parseInt(scan.nextLine());
		while (n-- != 0)
		{
			final String userName = scan.nextLine();

			if (userName.matches(VALID_USERNAME_PATTERN))
				System.out.println("Valid");
			else
				System.out.println("Invalid");
		}
	}
}
