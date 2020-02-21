/*
 * MiniMaxSumTest.java
 */

package org.rododin.algorithms.hackerrank.easy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link MiniMaxSum}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class MiniMaxSumTest
{
	@Test
	public void test01()
	{
		Assert.assertEquals(Arrays.asList(0L, 0L), MiniMaxSum.miniMaxSum(new int[] {}));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals(Arrays.asList(10L, 14L), MiniMaxSum.miniMaxSum(new int[] {1, 2, 3, 4, 5}));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals(Arrays.asList(16L, 24L), MiniMaxSum.miniMaxSum(new int[] {1, 3, 5, 7, 9}));
	}

	@Test
	public void test04()
	{
		Assert.assertEquals(Arrays.asList(200L, 1600L), MiniMaxSum.miniMaxSum(new int[] {20, 10, 120, 300, -200, -400, 1000, 0, 250, -300, 500, -100}));
	}

	@Test
	public void test05()
	{
		Assert.assertEquals(Arrays.asList(0L, 0L), MiniMaxSum.miniMaxSum(new int[] {100}));
	}

	@Test
	public void test06()
	{
		Assert.assertEquals(Arrays.asList(400L, 400L), MiniMaxSum.miniMaxSum(new int[] {100, 100, 100, 100, 100}));
	}

	@Test
	public void test07()
	{
		Assert.assertEquals(Arrays.asList(5_700_000_000L, 6_800_000_000L), MiniMaxSum.miniMaxSum(new int[] {1_000_000_000, 2_000_000_000, 1_500_000_000, 1_200_000_000, 2_100_000_000}));
	}
}
