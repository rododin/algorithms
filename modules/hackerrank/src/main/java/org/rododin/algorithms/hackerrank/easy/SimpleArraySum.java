/*
 * SimpleArraySum.java
 */

package org.rododin.algorithms.hackerrank.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * <a href="https://www.hackerrank.com/challenges/simple-array-sum/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Simple Array Sum
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SimpleArraySum
{
	public static int sum(int[] array)
	{
		return sum(Arrays.stream(array));
	}

	public static long sum(long[] array)
	{
		return sum(Arrays.stream(array));
	}

	public static int sum(IntStream intStream)
	{
		return intStream.sum();
	}

	public static long sum(LongStream intStream)
	{
		return intStream.sum();
	}

	public static int sum(List<Integer> list)
	{
		return sum(list.stream());
	}

	public static int sum(Stream<Integer> stream)
	{
		return stream.reduce(0, Integer::sum);
	}

	public static int sumS(Stream<String> stream)
	{
		return sum(stream.map(Integer::parseInt));
	}
}
