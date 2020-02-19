/*
 * BirthdayCakeCandlesTest.java
 */

package org.rododin.algorithms.misc.birthday_cake_candles;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link BirthdayCakeCandles}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BirthdayCakeCandlesTest
{
	@Test
	public void test0()
	{
		Assert.assertEquals(0, BirthdayCakeCandles.birthdayCakeCandles(new int[0]));
	}

	@Test
	public void test1()
	{
		Assert.assertEquals(1, BirthdayCakeCandles.birthdayCakeCandles(new int[] {100}));
	}

	@Test
	public void test2()
	{
		Assert.assertEquals(2, BirthdayCakeCandles.birthdayCakeCandles(new int[] {100, 100}));
	}

	@Test
	public void test3()
	{
		Assert.assertEquals(2, BirthdayCakeCandles.birthdayCakeCandles(new int[] {100, 100, 1}));
	}

	@Test
	public void test4()
	{
		Assert.assertEquals(2, BirthdayCakeCandles.birthdayCakeCandles(new int[] {3, 2, 1, 3}));
	}

	@Test
	public void test12()
	{
		Assert.assertEquals(3, BirthdayCakeCandles.birthdayCakeCandles(new int[] {12, 1234, 1120, 3, 1234, 8, 2222, 1234, 2222, 1234, 2222, 222}));
	}

	@Test
	public void test1000000()
	{
		final int N = 1_000_000;
		final int[] array = new int[N];
		final Random R = new Random();
		final int MAX_E = R.nextInt(Integer.MAX_VALUE);
		int max = Integer.MIN_VALUE;
		int maxCount = 0;
		int e;
		for (int i = 0; i < N; i++)
		{
			e = R.nextInt(MAX_E);
			array[i] = e;

			if (max == e)
				maxCount++;
			else if (max < e)
			{
				max = e;
				maxCount = 1;
			}
		}

		Assert.assertEquals(maxCount, BirthdayCakeCandles.birthdayCakeCandles(array));
	}
}
