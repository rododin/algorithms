/*
 * JavaCurrencyFormatter.java
 */

package org.rododin.algorithms.hackerrank.java.easy;

import java.util.Locale;

/**
 * <a href="https://www.hackerrank.com/challenges/java-currency-formatter/problem">
 *   HackerRank > Practice > Java > Introduction > Java Currency Formatter
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaCurrencyFormatter
{
	public static String[] printFormatDefaultCurrencies(double n)
	{
		final String[] rv = formatDefaultCurrencies(n);
		for (String s : rv)
			System.out.println(s);
		return rv;
	}

	public static String[] formatDefaultCurrencies(double n)
	{
		return formatCurrencies(n, Locale.US, new Locale("en", "IN"), Locale.CHINA, Locale.FRANCE);
	}

	public static String[] formatCurrencies(double n, Locale... locales)
	{
		final String[] rv = new String[locales.length];
		int i = 0;
		for (Locale locale : locales)
			rv[i++] = java.text.NumberFormat.getCurrencyInstance(locale).format(n);
		return rv;
	}
}
