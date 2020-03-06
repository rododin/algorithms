/*
 * TimeConversion.java
 */

package org.rododin.algorithms.hackerrank.problem_solving.easy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * <a href="https://www.hackerrank.com/challenges/time-conversion/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Time Conversion
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class TimeConversion
{
	public static void printTimeConversion(String input)
	{
		System.out.println(timeConversion(input));
	}

	public static void printTimeConversionOld(String input)
	{
		System.out.println(timeConversionOld(input));
	}

	public static String timeConversion(String input)
	{
		return DateTimeFormatter.ofPattern("HH:mm:ss").format(DateTimeFormatter.ofPattern("hh:mm:ssa").parse(input));
	}

	public static String timeConversionOld(String input)
	{
		try
		{
			return new SimpleDateFormat("HH:mm:ss").format(new SimpleDateFormat("hh:mm:ssa").parse(input));
		}
		catch (ParseException x)
		{
			x.printStackTrace();
			return input;
		}
	}
}
