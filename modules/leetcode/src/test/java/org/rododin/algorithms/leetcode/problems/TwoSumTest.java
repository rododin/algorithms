package org.rododin.algorithms.leetcode.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link TwoSum}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class TwoSumTest
{
	@Test
	public void test0()
	{
		doTest(new int[]{0,0}, 0);
	}

	@Test
	public void test1()
	{
		doTest(new int[]{0,1}, 3, 1, 2);
	}

	@Test
	public void test2()
	{
		doTest(new int[]{0,1}, 9, 2,7,11,15);
	}

	@Test
	public void test3()
	{
		doTest(new int[]{1,2}, 6, 3,2,4);
	}

	@Test
	public void test4()
	{
		doTest(new int[]{8,9}, 50, 3,2,4,5,7,9,11,17,19,31);
	}

	private static void doTest(int[] expected, int target, int... array)
	{
		Assert.assertArrayEquals(expected, new TwoSum().twoSum(array, target));
	}
}
