package org.rododin.algorithms.leetcode.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link FindMinimumInRotatedSortedArray}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class FindMinimumInRotatedSortedArrayTest
{
	@Test
	public void test0()
	{
		doTest(-1);
	}

	@Test
	public void test1()
	{
		doTest(0, 0);
	}

	@Test
	public void testMinor1()
	{
		doTest(1, 3,4,5,1,2);
	}

	@Test
	public void testMinor2()
	{
		doTest(0, 4,5,6,7,0,1,2);
	}

	@Test
	public void testMinor3()
	{
		doTest(11, 11,13,15,17);
	}

	private static void doTest(int expected, int... array)
	{
		Assert.assertEquals(expected, new FindMinimumInRotatedSortedArray().findMin(array));
	}
}
