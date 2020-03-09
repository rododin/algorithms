/*
 * JavaBigDecimal.java
 */

package org.rododin.algorithms.hackerrank.java.medium;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/java-bigdecimal/problem">
 *   HackerRank > Practice > Java > BigNumber > Java BigDecimal
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaBigDecimal
{
	public static void printSortBigDecimals(String[] numbers)
	{
		sortBigDecimals(numbers);
		for (String number : numbers)
			System.out.println(number);
	}

	/**
	 * Implements a very elegant solution for the problem:
	 * keeping strings, but converting to <code>{@link BigDecimal}</code> on comparison.

	 * @param numbers the array of the given big decimal numbers in textual form as defined at the task statement
	 */
	public static void sortBigDecimals(String[] numbers)
	{
		Arrays.sort(numbers, (s1, s2) -> - new BigDecimal(s1).compareTo(new BigDecimal(s2)));
	}
}
