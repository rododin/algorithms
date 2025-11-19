package org.rododin.algorithms.hackerrank.java.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.hackerrank.com/challenges/can-you-access/problem">
 *   HackerRank > Prepare > Java > Advanced > Can You Access?
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 *
 */
public class CanYouAccess
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());
			Object o;

			// The next line is the main part of the solution
			o = new Inner().new Private();

			System.out.println(num + " is " + ((Inner.Private)o).powerof2(num));
			System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	static class Inner
	{
		private class Private
		{
			private String powerof2(int num)
			{
				return (num & num - 1) == 0 ? "power of 2" : "not a power of 2";
			}
		}
	}
}
