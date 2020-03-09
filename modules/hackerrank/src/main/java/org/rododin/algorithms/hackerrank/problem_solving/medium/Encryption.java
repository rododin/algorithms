/*
 * Encryption.java
 */

package org.rododin.algorithms.hackerrank.problem_solving.medium;

/**
 * <a href="https://www.hackerrank.com/challenges/encryption/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Encryption
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Encryption
{
	public static String printEncryption(String s)
	{
		final String rv = encryption(s);
		System.out.println("'" + s + "'");
		System.out.println("->");
		System.out.println("'" + rv + "'\n");
		return rv;
	}

	public static String encryption(String s)
	{
		s = s.replace(" ", "");
		if (s.length() == 0)
			return "";

		String rv = "";
		final double RL = Math.sqrt(s.length());
		int rn = (int)Math.floor(RL);
		final int cn = (int)Math.ceil(RL);

		if (rn * cn < s.length())
			rn++;

		for (int i = 0; i < cn; i++)
		{
			String word = "";
			for (int j = 0; j < rn; j++)
			{
				final int ci = j * cn + i;
				if (ci < s.length())
					word += s.charAt(ci);
				else
					break;
			}
			rv += word + " ";
		}
		return rv.trim();
	}
}
